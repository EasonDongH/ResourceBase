package com.easondongh.service;

import com.easondongh.domain.Menu;

import java.util.List;

public interface MenuService {

    /**
     * 获取所有菜单信息（按menuOrder进行倒序排序）
     * @return
     */
    List<Menu> listMenuWithDescOrder();
}
