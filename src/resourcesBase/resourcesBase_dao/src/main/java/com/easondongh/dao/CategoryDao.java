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

    /**
     * 根据id获取category
     * @param id
     * @return
     */
    @Select("select * from category where id = #{id}")
    Category getCategoryById(Long id);

    /**
     * 统计分类数量
     * @return
     */
    @Select("select count(*) from category")
    int countCategory();

    /**
     * 获取该id下的所有子节点的id
     * @param id
     * @return
     */
    @Select("SELECT id FROM category WHERE pid = #{id}")
    List<Long> getChildNodesIdByCid(Long id);
}
