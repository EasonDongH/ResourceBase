package com.easondongh.service.impl;

import com.easondongh.dao.ArticleDao;
import com.easondongh.domain.Article;
import com.easondongh.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> listAll() {
        return this.articleDao.listAll();
    }
}
