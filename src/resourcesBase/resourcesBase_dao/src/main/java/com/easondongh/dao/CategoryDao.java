package com.easondongh.dao;

import com.easondongh.domain.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryDao {

    /**
     * 按categoryOrder字段倒序排序
     * @return
     */
    @Select("select * from category order by categoryOrder desc")
    List<Category> listWithDescOrder();
}
