package com.easondongh.service;

import com.easondongh.domain.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 按categoryOrder字段倒序排序
     * @return
     */
    List<Category> listWithDescOrder();

    /**
     * 获取该category所有的父节点（包含当前category），按categoryOrder升序排序
     * @param category
     * @return
     */
    List<Category> getParentNodeById(Category category);

    /**
     * 获取该id对应的category
     * @param id
     * @return
     */
    Category getCategoryById(Integer id);

    /**
     * 统计分类数量
     * @return
     */
    int countCategory();
}
