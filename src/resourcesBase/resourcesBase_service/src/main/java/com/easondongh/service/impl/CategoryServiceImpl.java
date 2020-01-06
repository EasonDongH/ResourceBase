package com.easondongh.service.impl;

import com.easondongh.dao.CategoryDao;
import com.easondongh.domain.Category;
import com.easondongh.service.CategoryService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> listWithDescOrder() {
        return this.categoryDao.listWithDescOrder();
    }

    @Override
    public List<Category> getParentNodeById(Category category) {
        List<Category> parentNodes = new ArrayList<>();
        if(category != null) {
            parentNodes.add(category);
            do {
                category = this.categoryDao.getCategoryById(category.getPid());
                if(category == null) break;
                parentNodes.add(category);
            }while (!Category.isRoot(category));
            Collections.sort(parentNodes, new Comparator<Category>() {
                @Override
                public int compare(Category o1, Category o2) {
                    return o1.getPid() - o2.getPid();
                }
            });
        }
        return parentNodes;
    }

    @Override
    public Category getCategoryById(Integer id) {
        return this.categoryDao.getCategoryById(id);
    }

    @Override
    public int countCategory() {
        return this.categoryDao.countCategory();
    }
}
