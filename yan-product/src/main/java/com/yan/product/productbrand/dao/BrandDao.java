package com.yan.product.productbrand.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yan.product.productbrand.model.ProductBrand;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrandDao extends BaseMapper<ProductBrand> {

}
