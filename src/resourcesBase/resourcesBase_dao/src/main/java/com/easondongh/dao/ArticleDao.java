package com.easondongh.dao;

import com.easondongh.dao.dynamicSql.ArticleDynaSqlProvider;
import com.easondongh.domain.Article;
import com.easondongh.domain.Category;
import com.easondongh.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author EasonDongH
 */
public interface ArticleDao {

    /**
     * 查找所有项
     *
     * @return
     */
    @Select("select * from article where status = 1 " +
            "ORDER BY articleOrder DESC, articleCommentCount DESC, articleLikeCount DESC, articleCreateTime DESC")
    List<Article> listAll();

    /**
     * 根据条件查询
     * @param params
     * @return
     */
    @SelectProvider(type = ArticleDynaSqlProvider.class, method = "selectByParam")
    @ResultMap(value = "articleMap")
    List<Article> pageArticle(Map<String,Object> params);

    /**
     * 根据文章id获取文章实体
     *
     * @param id
     * @return
     */
    @Select("select * from article where id = #{id} and status = 1")
    @Results(id = "articleMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "userId", column = "userId"),
            @Result(property = "articleTitle", column = "articleTitle"),
            @Result(property = "articleContent", column = "articleContent"),
            @Result(property = "articleSummary", column = "articleSummary"),
            @Result(property = "articleCreateTime", column = "articleCreateTime"),
            @Result(property = "articleUpdateTime", column = "articleUpdateTime"),
            @Result(property = "articleViewCount", column = "articleViewCount"),
            @Result(property = "articleCommentCount", column = "articleCommentCount"),
            @Result(property = "articleLikeCount", column = "articleLikeCount"),
            @Result(property = "articleOrder", column = "articleOrder"),
            @Result(property = "category", column = "categoryId", javaType = Category.class, one = @One(select = "com.easondongh.dao.CategoryDao.getCategoryById")),
            @Result(property = "tagList", column = "id", javaType = java.util.List.class, many = @Many(select = "com.easondongh.dao.TagDao.getListByAid")),
            @Result(property = "user", column = "userId", javaType = User.class, one = @One(select = "com.easondongh.dao.UserDao.getById"))
    })
    Article getArticleById(Long id);

    /**
     * 获取该分类id下的所有文章
     * @param cid
     * @return
     */
    @Select("select * from article where status = 1 and categoryId = #{cid} " +
            "ORDER BY articleOrder DESC, articleCommentCount DESC, articleLikeCount DESC, articleCreateTime DESC")
    List<Article> getArticleListByCid(Long cid);

    /**
     * 根据Tag获取文章
     * @param tid
     * @return
     */
    @Select("select * from article where status = 1 and id in (select aid from article_tag where tid = #{tid}) " +
            "ORDER BY articleOrder DESC, articleCommentCount DESC, articleLikeCount DESC, articleCreateTime DESC")
    List<Article> getArticleListByTid(Long tid);

    /**
     * 根据文章id获取文章喜欢数
     *
     * @param id
     * @return
     */
    @Select("select articleLikeCount from article where id = #{id}")
    Integer getArticleLikeCountById(Long id);

    /**
     * 根据文章id更新文章喜欢数：因为当前只涉及单条记录、单个字段的更新，可以不使用事务
     *
     * @param id
     * @param curLikeCnt
     * @return
     */
    @Update("update article set articleLikeCount=#{curLikeCnt} where id=#{id}")
    int updateArticleLikeCountById(@Param("id") Long id, @Param("curLikeCnt") Integer curLikeCnt);

    /**
     * 根据文章id获取文章查看数
     * @param id
     * @return
     */
    @Select("select articleViewCount from article where id = #{id}")
    Integer getArticleViewCountById(Long id);

    /**
     * 根据文章id更新文章查看数：因为当前只涉及单条记录、单个字段的更新，可以不使用事务
     * @param id
     * @param curViewCnt
     * @return
     */
    @Update("update article set articleViewCount=#{curViewCnt} where id=#{id}")
    int updateArticleViewCountById(@Param("id") Long id, @Param("curViewCnt") Integer curViewCnt);

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
    @Select("select * from article where status = 1 order by articleCommentCount desc limit 10")
    List<Article> getMostCommentArticleList();

    /**
     * 获取上一篇文章：上一个id
     * @param id
     * @return
     */
    @Select("select * from article where status = 1 and id < #{id} order by id limit 1")
    @ResultMap(value = "articleMap")
    Article getPreviousArticle(Long id);

    /**
     * 获取下一篇文章：下一个id
     * @param id
     * @return
     */
    @Select("select * from article where status = 1 and id > #{id} order by id limit 1")
    @ResultMap(value = "articleMap")
    Article getNextArticle(Long id);

    @Insert("insert into article (id,articleTitle,articleContent,articleSummary,articleCreateTime,articleUpdateTime,categoryId,userId)" +
            "values(#{id},#{articleTitle},#{articleContent},#{articleSummary},#{articleCreateTime},#{articleUpdateTime},#{categoryId},#{userId})")
    int addArticle(Article article);
}
