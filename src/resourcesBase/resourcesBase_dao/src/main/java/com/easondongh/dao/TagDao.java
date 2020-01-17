package com.easondongh.dao;

import com.easondongh.domain.Tag;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TagDao {

    /**
     * 获取所有tag
     * @return
     */
    @Select("select * from tag")
    List<Tag> getList();

    /**
     * 根据文章id获取tag
     * @param aid
     * @return
     */
    @Select("select * from tag where id in (select tid from article_tag where aid = 1)")
    List<Tag> getListByAid(Long aid);

    @Select("select count(*) from tag")
    int countTag();
}
