package com.easondongh.dao;

import com.easondongh.domain.Article;
import com.easondongh.domain.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticleDao {

    /**
     * 查找所有项
     *
     * @return
     */
    @Select("select * from article")
    List<Article> listAll();

    /**
     * 根据文章id获取文章实体
     *
     * @param id
     * @return
     */
    @Select("select * from article where id = #{id}")
    @Results(id = "articleMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "articleTitle", column = "articleTitle"),
            @Result(property = "articleContent", column = "articleContent"),
            @Result(property = "articleSummary", column = "articleSummary"),
            @Result(property = "articleCreateTime", column = "articleCreateTime"),
            @Result(property = "articleUpdateTime", column = "articleUpdateTime"),
            @Result(property = "articleViewCount", column = "articleViewCount"),
            @Result(property = "articleCommentCount", column = "articleCommentCount"),
            @Result(property = "articleLikeCount", column = "articleLikeCount"),
            @Result(property = "articleOrder", column = "articleOrder"),
            @Result(property = "category", column = "categoryId", javaType = Category.class, one = @One(select = "com.easondongh.dao.CategoryDao.getCategoryById"))
    })
    Article getArticleById(Integer id);

    /**
     * 获取该分类id下的所有文章
     * @param cid
     * @return
     */
    @Select("select * from article where categoryId = #{cid}")
    List<Article> getArticleListByCid(Integer cid);

    /**
     * 根据文章id获取文章喜欢数
     *
     * @param id
     * @return
     */
    @Select("select articleLikeCount from article where id = #{id}")
    Integer getArticleLikeCountById(Integer id);

    /**
     * 根据文章id更新文章喜欢数：因为当前只涉及单条记录、单个字段的更新，可以不使用事务
     *
     * @param id
     * @param curLikeCnt
     * @return
     */
    @Update("update article set articleLikeCount=#{curLikeCnt} where id=#{id}")
    int updateArticleLikeCountById(@Param("id") Integer id, @Param("curLikeCnt") Integer curLikeCnt);

    /**
     * 根据文章id获取文章查看数
     * @param id
     * @return
     */
    @Select("select articleViewCount from article where id = #{id}")
    Integer getArticleViewCountById(Integer id);

    /**
     * 根据文章id更新文章查看数：因为当前只涉及单条记录、单个字段的更新，可以不使用事务
     * @param id
     * @param curViewCnt
     * @return
     */
    @Update("update article set articleViewCount=#{curViewCnt} where id=#{id}")
    int updateArticleViewCountById(@Param("id") Integer id, @Param("curViewCnt") Integer curViewCnt);

    /**
     * 统计文章总数
     * @return
     */
    @Select("select count(*) from article")
    int countArticles();

    /**
     * 统计留言总数
     * @return
     */
    @Select("select sum(articleCommentCount) from article")
    int countArticleComments();

    /**
     * 统计查看总数
     * @return
     */
    @Select("select sum(articleViewCount) from article")
    int countArticleViews();

    /**
     * 获取前10热评文章
     * @return
     */
    @Select("select* from article order by articleCommentCount desc limit 10")
    List<Article> getMostCommentArticleList();
}
