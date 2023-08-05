package com.yan.product.productbrand.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yan.common.utils.PageUtils;
import com.yan.product.productbrand.model.ProductBrand;

import java.util.Map;

public interface BrandService extends IService<ProductBrand> {

    PageUtils queryPage(Map<String, Object> params);
}
