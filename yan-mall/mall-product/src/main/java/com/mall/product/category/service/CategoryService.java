package com.mall.product.category.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.product.category.model.CategoryEntity;

import java.util.List;


public interface CategoryService extends IService<CategoryEntity> {

    List<CategoryEntity> listWithTree();
}

