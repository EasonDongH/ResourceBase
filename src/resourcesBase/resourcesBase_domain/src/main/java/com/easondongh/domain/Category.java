package com.easondongh.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Category implements Serializable {

    private Long id;

    /**
     * 父节点id，0表示无父节点
     */
    private Long pid;

    private String categoryName;

    private String categoryDescription;

    /**
     * 排序字段：这里是分类递归层次
     */
    private Integer categoryOrder;

    private String categoryIcon;

    public static boolean isRoot(Category category){
        return category != null && category.getPid() == 0;
    }
}
