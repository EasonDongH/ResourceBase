package com.easondongh.service;

import com.easondongh.domain.Article;

import java.util.List;

public interface ArticleService {

    /**
     * 查找所有项
     * @return
     */
    List<Article> listAll();
}
