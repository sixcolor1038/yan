package com.yan.demo.exceldemo.controller;

import com.yan.common.utils.RResult;
import com.yan.demo.exceldemo.entity.EmployeeDuty;
import com.yan.demo.exceldemo.entity.ProductList;
import com.yan.demo.exceldemo.service.ImportExcelService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Author: sixcolor
 * @Date: 2024-03-03 18:54
 * @Description:
 */
@RestController
@RequestMapping("importExcel")
public class ImportExcelController {

    @Autowired
    private ImportExcelService employeeDutyService;


    @Operation(summary = "通过excel导入产品清单")
    @PostMapping("/importProductList")
    public RResult<List<ProductList>> importProductList(MultipartFile file) throws IOException {
        return RResult.success(employeeDutyService.importProductList(file).getData());
    }

    @Operation(summary = "通过excel导入人员值班数据")
    @PostMapping("/importEmployeeDuty")
    public RResult<List<EmployeeDuty>> importEmployeeDuty(MultipartFile file) throws IOException {
        return RResult.success(employeeDutyService.importEmployeeDuty(file).getData());
    }


    /**
     * 通过ID查询单条数据
     *
     * @param employeeDutyId 主键
     * @return 实例对象
     */
    @GetMapping("{getById}")
    public ResponseEntity<EmployeeDuty> queryById(@RequestParam Long employeeDutyId) {
        return ResponseEntity.ok(employeeDutyService.queryById(employeeDutyId));
    }

    /**
     * 分页查询
     *
     * @param employeeDuty 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<EmployeeDuty>> paginQuery(EmployeeDuty employeeDuty, PageRequest pageRequest) {
        return ResponseEntity.ok(employeeDutyService.paginQuery(employeeDuty, pageRequest));
    }

    /**
     * 新增数据
     *
     * @param employeeDuty 实例对象
     * @return 实例对象
     */
    @PostMapping("/add")
    public RResult<EmployeeDuty> add(@RequestBody EmployeeDuty employeeDuty) {
        employeeDutyService.insertEmployeeDuty(employeeDuty);
        return RResult.create(employeeDuty);
    }

    /**
     * 更新数据
     *
     * @param employeeDuty 实例对象
     * @return 实例对象
     */
    @PutMapping
    public ResponseEntity<EmployeeDuty> edit(EmployeeDuty employeeDuty) {
        return ResponseEntity.ok(employeeDutyService.update(employeeDuty));
    }

    /**
     * 通过主键删除数据
     *
     * @param employeeDutyId 主键
     * @return 是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String employeeDutyId) {
        return ResponseEntity.ok(employeeDutyService.deleteById(employeeDutyId));
    }
}
