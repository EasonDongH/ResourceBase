package com.easondongh.service.impl;

import com.easondongh.dao.ArticleDao;
import com.easondongh.domain.Article;
import com.easondongh.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public PageInfo<Article> pageArticle(Integer pageIndex, Integer pageSize, Map<String, Object> params) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Article> articleList = this.articleDao.pageArticle(params);
        return new PageInfo<Article>(articleList);
    }

    @Override
    public PageInfo<Article> pageArticle(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Article> articleList = this.articleDao.listAll();
        return new PageInfo<Article>(articleList);
    }

    @Override
    public PageInfo<Article> pageArticleByTid(Integer pageIndex, Integer pageSize, Long tid) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Article> articleList = this.articleDao.getArticleListByTid(tid);
        return new PageInfo<Article>(articleList);
    }

    @Override
    public Article getArticleById(Long id) {
        return this.articleDao.getArticleById(id);
    }

    @Override
    public List<Article> getArticleListByCid(Long cid) {
        return this.articleDao.getArticleListByCid(cid);
    }

    @Override
    public Integer getArticleLikeCountById(Long id) {
        return this.articleDao.getArticleLikeCountById(id);
    }

    @Override
    public synchronized boolean updateArticleLikeCountById(Long id, Integer curLikeCnt) {
        Integer result = this.articleDao.updateArticleLikeCountById(id,curLikeCnt);
        return result > 0;
    }

    @Override
    public Integer getArticleViewCountById(Long id) {
        return this.articleDao.getArticleViewCountById(id);
    }

    @Override
    public synchronized boolean updateArticleViewCountById(Long id, Integer curViewCnt) {
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
    public Article getPreviousArticle(Long id) {
        return this.articleDao.getPreviousArticle(id);
    }

    @Override
    public Article getNextArticle(Long id) {
        return this.articleDao.getNextArticle(id);
    }
}
