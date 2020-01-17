package com.easondongh.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Menu implements Serializable {

    private Long id;

    private String menuName;

    private Integer menuLevel;

    private String menuUrl;

    private String menuIcon;

    /**
     * 依据该字段进行菜单排序显示（倒序）
     */
    private Integer menuOrder;

}
