package com.yan.product.productbrand.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yan.common.utils.PageUtils;
import com.yan.common.utils.Query;
import com.yan.product.productbrand.dao.BrandDao;
import com.yan.product.productbrand.model.ProductBrand;
import com.yan.product.productbrand.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, ProductBrand> implements BrandService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProductBrand> page = this.page(
                new Query<ProductBrand>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }
}
