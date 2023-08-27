package com.mall.product.category.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.product.category.dao.CategoryDao;
import com.mall.product.category.model.CategoryEntity;
import com.mall.product.category.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {



    @Override
    public List<CategoryEntity> listWithTree() {
        //查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //找到所有一级分类及下级分类并排序
        return  entities.stream().
                filter(categoryEntity -> categoryEntity.getParentCid() == 0
                ).peek((menu)-> menu.setChildren(getChildren(menu, entities))
                ).sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))
                ).collect(Collectors.toList());

    }

    // 递归查找所有菜单的子菜单
    private List<CategoryEntity> getChildren(CategoryEntity root,List<CategoryEntity> all){

        return all.stream().filter((categoryEntity) -> {
                    return Objects.equals(categoryEntity.getParentCid(), root.getCatId());
                }).peek((categoryEntity) -> {
                    //找到子菜单
                    categoryEntity.setChildren(getChildren(categoryEntity, all));
                })
                //对菜单进行排序
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());

    }

}