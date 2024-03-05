package com.yan.demo.infra.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sixcolor
 * @Date: 2024-03-02 11:08
 * @Description:
 */
public class ExcelUtil {


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
