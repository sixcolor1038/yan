package com.yan.product.productbrand.controller;


import com.yan.common.constant.HttpCodeEnum;
import com.yan.common.utils.PageUtils;
import com.yan.common.utils.ResponseResult;
import com.yan.product.productbrand.model.ProductBrand;
import com.yan.product.productbrand.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * 品牌
 *
 * @author sixcolor
 * @date 2023-08-04 20:47:44
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public ResponseResult<List<String>> list(@RequestParam Map<String, Object> params) {
        PageUtils pageUtils = brandService.queryPage(params);
        return ResponseResult.okResult(Collections.singletonList(pageUtils.toString()));
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    public ResponseResult<ProductBrand> info(@PathVariable("brandId") Long brandId) {
        ProductBrand brand = brandService.getById(brandId);

        return ResponseResult.okResult(brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public ResponseResult<Boolean> save(@RequestBody ProductBrand brand) {

        boolean save = brandService.save(brand);
        return ResponseResult.okResult(save);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public ResponseResult<Boolean> update(@RequestBody ProductBrand brand) {

        return ResponseResult.okResult( brandService.updateById(brand));
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public ResponseResult<Boolean> delete(@RequestBody Map<String, Long[]> request) {
        Long[] brandIds = request.get("brandId");
        if (brandIds != null) {
            return ResponseResult.okResult(brandService.removeByIds(Arrays.asList(brandIds)));
        } else {
            return ResponseResult.errorResult(HttpCodeEnum.DATA_NOT_EXIST);
        }
    }



}
