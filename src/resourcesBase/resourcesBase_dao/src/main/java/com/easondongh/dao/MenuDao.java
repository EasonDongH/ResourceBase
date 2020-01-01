package com.easondongh.dao;

import com.easondongh.domain.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuDao {

    /**
     * 获取所有菜单信息（按menuOrder进行倒序排序）
     * @return
     */
    @Select("select * from menu order by menuOrder desc")
    List<Menu> listMenuWithDescOrder();
}
