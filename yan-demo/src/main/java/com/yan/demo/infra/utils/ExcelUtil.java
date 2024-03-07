package com.yan.demo.infra.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.filechooser.FileSystemView;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sixcolor
 * @Date: 2024-03-02 11:08
 * @Description:
 */
public class ExcelUtil {


    public static void exportToExcel(List<List<Object>> data, String filePath, String sheetName) {
        if (StringUtils.isBlank(filePath)) {
            FileSystemView fsv = FileSystemView.getFileSystemView();
            String downloadFolderPath = fsv.getDefaultDirectory().toString(); // 获取系统的默认下载路径
            filePath = Paths.get(downloadFolderPath, "product_list.xlsx").toString();

            exportToExcel(data, filePath, sheetName, false);
        } else {
            exportToExcel(data, filePath, sheetName, false);
        }

    }

    public static void exportToExcel(List<List<Object>> data, String filePath, String sheetName, boolean append) {
        /**
         * 参数 append 是用来指定是否向现有的 Excel 文件中追加数据。
         * 如果将其设置为 true，则新的数据将被追加到现有的 Excel 文件中；
         * 如果设置为 false，则将创建一个新的 Excel 文件并写入数据。
         * 这样可以在需要将数据分批次写入到同一个 Excel 文件时很有用，
         * 比如在多次执行导出操作时，将数据添加到同一个文件中而不覆盖之前的数据。
         */
        try (Workbook workbook = append ? WorkbookFactory.create(true) : new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(sheetName);

            int rowNum = 0;
            for (List<Object> rowData : data) {
                Row row = sheet.createRow(rowNum++);
                int colNum = 0;
                for (Object field : rowData) {
                    Cell cell = row.createCell(colNum++);
                    setCellValue(cell, field);
                }
            }

            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
                System.out.println("Excel导出成功！");
            } catch (IOException e) {
                System.err.println("无法写入Excel文件：" + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("无法创建工作簿：" + e.getMessage());
        }
    }

    private static void setCellValue(Cell cell, Object value) {
        if (value instanceof String) {
            cell.setCellValue((String) value);
        } else if (value instanceof Integer || value instanceof Long) {
            cell.setCellValue(Long.parseLong(value.toString()));
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof LocalDate) {
            cell.setCellValue((LocalDate) value);
            // 设置日期格式
            CellStyle cellStyle = cell.getSheet().getWorkbook().createCellStyle();
            cellStyle.setDataFormat(
                    cell.getSheet().getWorkbook().getCreationHelper().createDataFormat().getFormat("yyyy-MM-dd"));
            cell.setCellStyle(cellStyle);
        } else {
            throw new IllegalArgumentException("Unsupported data type: " + value.getClass().getName());
        }
    }


    /**
     * 读取Excel文件并返回所有数据为二维列表
     *
     * @param inputStream 文件输入流
     * @return 二维列表，每一行是一个List对象，每个List内是单元格的值
     */
    public static List<List<String>> readExcelFile(int num, InputStream inputStream) {
        List<List<String>> result = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            // 获取第一个工作表，可根据需要替换为获取指定名称的工作表
            Sheet sheet = workbook.getSheetAt(0);
            // 从第二行开始遍历
            for (int i = num; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);
                if (currentRow == null) {
                    // 如果行为空，则跳过
                    continue;
                }
                List<String> rowData = new ArrayList<>();
                for (Cell currentCell : currentRow) {
                    String cellValue = getFormattedCellValue(currentCell);
                    rowData.add(cellValue);
                }
                result.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String getFormattedCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        switch (cell.getCellType()) {
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    // 修改日期时间格式为 "yyyy/MM/dd HH:mm:ss"
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    return dateFormat.format(cell.getDateCellValue());
                } else {
                    // 如果不是日期类型，则将数字格式化为字符串，避免科学计数法
                    return String.format("%.0f", cell.getNumericCellValue());
                }
            case STRING:
                return cell.getStringCellValue();
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return null;
        }
    }

}
