package com.easondongh.dao;

import com.easondongh.domain.Article;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleDao {

    /**
     * 查找所有项
     * @return
     */
    @Select("select * from article")
    List<Article> listAll();
}
