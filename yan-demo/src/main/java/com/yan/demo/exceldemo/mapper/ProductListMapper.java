package com.yan.demo.exceldemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yan.demo.exceldemo.entity.ProductList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: sixcolor
 * @Date: 2024-03-05 17:20
 * @Description:
 */
@Mapper
public interface ProductListMapper extends BaseMapper<ProductList> {

    int batchInsertProductList(@Param("entities") List<ProductList> entities);
}
