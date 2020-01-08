package com.easondongh.service;

import com.easondongh.domain.Article;

import java.util.List;

/**
 * @author EasonDongH
 */
public interface ArticleService {

    /**
     * 查找所有项
     * @return
     */
    List<Article> listAll();

    /**
     * 根据文章id获取文章实体
     * @param id
     * @return
     */
    Article getArticleById(Integer id);

    /**
     * 获取该分类id下的所有文章
     * @param cid
     * @return
     */
    List<Article> getArticleListByCid(Integer cid);

    /**
     * 根据文章id获取文章喜欢数
     * @param id
     * @return
     */
    Integer getArticleLikeCountById(Integer id);

    /**
     * 根据文章id更新文章喜欢数：因为当前只涉及单条记录、单个字段的更新，可以不使用事务
     * @param id
     * @param curLikeCnt
     * @return
     */
    boolean updateArticleLikeCountById(Integer id, Integer curLikeCnt);

    /**
     * 根据文章id获取文章查看数
     * @param id
     * @return
     */
    Integer getArticleViewCountById(Integer id);

    /**
     * 根据文章id更新文章查看数：因为当前只涉及单条记录、单个字段的更新，可以不使用事务
     * @param id
     * @param curViewCnt
     * @return
     */
    boolean updateArticleViewCountById(Integer id, Integer curViewCnt);

    /**
     * 统计文章总数
     * @return
     */
    int countArticles();

    /**
     * 统计留言总数
     * @return
     */
    int countArticleComments();

    /**
     * 统计查看总数
     * @return
     */
    int countArticleViews();

    /**
     * 获取前10热评文章
     * @return
     */
    List<Article> getMostCommentArticleList();

    /**
     * 获取上一篇文章：上一个id
     * @param id
     * @return
     */
    Article getPreviousArticle(Integer id);

    /**
     * 获取下一篇文章：下一个id
     * @param id
     * @return
     */
    Article getNextArticle(Integer id);
}
