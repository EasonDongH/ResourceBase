package com.easondongh.service;

import com.easondongh.domain.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 按categoryOrder字段倒序排序
     * @return
     */
    List<Category> listWithDescOrder();
}
