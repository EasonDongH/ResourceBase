package com.easondongh.service.impl;

import com.easondongh.dao.CategoryDao;
import com.easondongh.domain.Category;
import com.easondongh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> listWithDescOrder() {
        return this.categoryDao.listWithDescOrder();
    }
}
