package com.yan.demo.exceldemo.service.impl;

import com.yan.common.utils.RResult;
import com.yan.demo.exceldemo.controller.ImportExcelController;
import com.yan.demo.exceldemo.entity.EmployeeDuty;
import com.yan.demo.exceldemo.entity.ProductList;
import com.yan.demo.exceldemo.mapper.EmployeeDutyMapper;
import com.yan.demo.exceldemo.mapper.ProductListMapper;
import com.yan.demo.exceldemo.service.ImportExcelService;
import com.yan.demo.infra.utils.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sixcolor
 * @Date: 2024-03-03 18:59
 * @Description:
 */
@Service
public class ImportExcelServiceImpl implements ImportExcelService {
    private static final Logger logger = LoggerFactory.getLogger(ImportExcelController.class);
    @Autowired
    private EmployeeDutyMapper employeeDutyMapper;
    @Autowired
    private ProductListMapper productListMapper;

    @Override
    public RResult<List<ProductList>> importProductList(MultipartFile file) throws IOException {
        // 从第二行开始遍历
        int num = 1;
        List<List<String>> excelData = ExcelUtil.readExcelFile(num, file.getInputStream());
        logger.info("读取excel数据:{}", excelData);
        List<ProductList> list = new ArrayList<>();
        for (List<String> data : excelData) {
            if (StringUtils.isNotBlank(data.get(1))) {
                ProductList productList = new ProductList();
                productList.setBusinessMajor(data.get(1));
                productList.setBusinessModule(data.get(2));
                productList.setProductName(data.get(3));
                productList.setBusinessItem(data.get(4));
                productList.setChannels(data.get(5));
                productList.setProductPath(data.get(6));
                productList.setProductCapabilities(data.get(7));
                if (data.get(8).length() >= 10) {
                    productList.setAddedTime(LocalDate.parse(data.get(8).substring(0, 10)));
                }
                productList.setDevelopmentGroup(data.get(9));
                productList.setDevelopmentDataResponsible(data.get(10));
                productList.setProductClassification(data.get(11));
                productList.setFrontendBackendClassification(data.get(12));
                productList.setProductStatus(data.get(13));
                productList.setPromotionApplicationMethod(data.get(14));
                productList.setUsingOrganization(data.get(15));
                productList.setIsPcOrMobile(data.get(16));
                productList.setRemarks(data.get(17));
                list.add(productList);
            }
        }
        logger.info("list:{}", list);
        productListMapper.batchInsertProductList(list);
        return RResult.success(list);
    }

    @Override
    public RResult<List<EmployeeDuty>> importEmployeeDuty(MultipartFile file) throws IOException {
        // 从第二行开始遍历
        int num = 1;
        List<List<String>> excelData = ExcelUtil.readExcelFile(num, file.getInputStream());
        logger.info("读取excel数据:{}", excelData);
        List<EmployeeDuty> list = new ArrayList<>();
        for (List<String> data : excelData) {
            EmployeeDuty duty = new EmployeeDuty();
            duty.setName(data.get(0));
            duty.setEmployeeGroup(data.get(1));
            duty.setSubGroup1(data.get(2));
            duty.setSubGroup2(data.get(3));
            duty.setUnit(data.get(4));
            duty.setOfficeLocation(data.get(5));
            duty.setContact(data.get(6));
            duty.setThisWeekOnDuty(data.get(7));
            duty.setNextWeekOnDuty(data.get(8));
            duty.setRemarks(data.get(9));
            list.add(duty);
        }
        employeeDutyMapper.insertBatch(list);
        return RResult.success(list);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param employeeDutyId 主键
     * @return 实例对象
     */
    public EmployeeDuty queryById(Long employeeDutyId) {
        return employeeDutyMapper.queryById(employeeDutyId);
    }

    /**
     * 分页查询
     *
     * @param employeeDuty 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    public Page<EmployeeDuty> paginQuery(EmployeeDuty employeeDuty, PageRequest pageRequest) {
        long total = employeeDutyMapper.count(employeeDuty);
        return new PageImpl<>(employeeDutyMapper.queryAllByLimit(employeeDuty, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param employeeDuty 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeDuty insertEmployeeDuty(EmployeeDuty employeeDuty) {
        employeeDutyMapper.addEmployeeDuty(employeeDuty);
        return employeeDuty;
    }

    /**
     * 更新数据
     *
     * @param employeeDuty 实例对象
     * @return 实例对象
     */
    public EmployeeDuty update(EmployeeDuty employeeDuty) {
        employeeDutyMapper.update(employeeDuty);
        return queryById(employeeDuty.getEmployeeDutyID());
    }

    /**
     * 通过主键删除数据
     *
     * @param employeeDutyId 主键
     * @return 是否成功
     */
    public boolean deleteById(String employeeDutyId) {
        int total = employeeDutyMapper.deleteById(employeeDutyId);
        return total > 0;
    }
}
