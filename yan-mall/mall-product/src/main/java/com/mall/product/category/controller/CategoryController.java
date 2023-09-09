package com.mall.product.category.controller;

import com.mall.product.category.model.CategoryEntity;
import com.mall.product.category.service.CategoryService;
import com.yan.common.utils.RResult;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 查出所有分类及子分类，并以树形结构组装
     */
    @Operation(summary = "商品分类树形")
    @RequestMapping(value = "/list/menuTree",method = RequestMethod.GET)
    public RResult<List<CategoryEntity>> list(){
        return RResult.success(categoryService.listWithTree());
    }
}
