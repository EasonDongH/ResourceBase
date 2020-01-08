package com.easondongh.service.impl;

import com.easondongh.dao.ArticleDao;
import com.easondongh.domain.Article;
import com.easondongh.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author EasonDongH
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> listAll() {
        return this.articleDao.listAll();
    }

    @Override
    public Article getArticleById(Integer id) {
        return this.articleDao.getArticleById(id);
    }

    @Override
    public List<Article> getArticleListByCid(Integer cid) {
        return this.articleDao.getArticleListByCid(cid);
    }

    @Override
    public Integer getArticleLikeCountById(Integer id) {
        return this.articleDao.getArticleLikeCountById(id);
    }

    @Override
    public synchronized boolean updateArticleLikeCountById(Integer id, Integer curLikeCnt) {
        Integer result = this.articleDao.updateArticleLikeCountById(id,curLikeCnt);
        return result > 0;
    }

    @Override
    public Integer getArticleViewCountById(Integer id) {
        return this.articleDao.getArticleViewCountById(id);
    }

    @Override
    public synchronized boolean updateArticleViewCountById(Integer id, Integer curViewCnt) {
        return this.articleDao.updateArticleViewCountById(id,curViewCnt) > 0;
    }

    @Override
    public int countArticles() {
        return this.articleDao.countArticles();
    }

    @Override
    public int countArticleComments() {
        return this.articleDao.countArticleComments();
    }

    @Override
    public int countArticleViews() {
        return this.articleDao.countArticleViews();
    }

    @Override
    public List<Article> getMostCommentArticleList() {
        return this.articleDao.getMostCommentArticleList();
    }

    @Override
    public Article getPreviousArticle(Integer id) {
        return this.articleDao.getPreviousArticle(id);
    }

    @Override
    public Article getNextArticle(Integer id) {
        return this.articleDao.getNextArticle(id);
    }
}
