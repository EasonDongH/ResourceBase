package com.easondongh.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Category implements Serializable {

    private Integer id;

    /**
     * 父节点id，0表示无父节点
     */
    private Integer pid;

    private String categoryName;

    private String categoryDescription;

    /**
     * 排序字段
     */
    private Integer categoryOrder;

    private String categoryIcon;
}
