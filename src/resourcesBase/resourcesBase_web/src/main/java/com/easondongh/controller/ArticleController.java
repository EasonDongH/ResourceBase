package com.easondongh.controller;

import com.easondongh.domain.Article;
import com.easondongh.domain.Category;
import com.easondongh.domain.Comment;
import com.easondongh.domain.ResultInfo;
import com.easondongh.service.ArticleService;
import com.easondongh.service.CategoryService;
import com.easondongh.service.CommentService;
import com.easondongh.service.TagService;
import com.easondongh.util.JsonUtil;
import com.easondongh.util.SiteInfoHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author EasonDongH
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private TagService tagService;

    /**
     * 查询文章详细
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{articleId}")
    public String getArticleById(@PathVariable("articleId") Long id, Model model){
        Article article = this.articleService.getArticleById(id);
        // 对无效查询响应主页面
        if(article == null) {
            return "index";
        }
        model.addAttribute("article", article);
        // 获取该文章评论列表
        List<Comment> commentList = this.commentService.getCommentListByaid(id);
        model.addAttribute("commentList",commentList);
        // 获取该文章所属的分类层次结构
        List<Category> parentNodes = this.categoryService.getParentNodeById(article.getCategory());
        model.addAttribute("parentNodes", parentNodes);
        //  获取上一篇文章
        Article preArticle = this.articleService.getPreviousArticle(article.getId());
        model.addAttribute("preArticle",preArticle);
        //  获取下一篇文章
        Article nextArticle = this.articleService.getNextArticle(article.getId());
        model.addAttribute("nextArticle",nextArticle);

        // 侧边栏
        // 网站统计情况
        int[] siteBasicStatistics = new int[6];
        // 统计文章总数
        siteBasicStatistics[0] = this.articleService.countArticles();
        // 统计浏览总量
        siteBasicStatistics[1] = this.articleService.countArticleViews();
        // 统计留言数量
        siteBasicStatistics[2] = this.articleService.countArticleComments();
        // 统计分类数量
        siteBasicStatistics[3] = this.categoryService.countCategory();
        // 统计标签总数
        siteBasicStatistics[4] = this.tagService.countTag();
        // 运行天数
        siteBasicStatistics[5] = SiteInfoHelper.getSiteRunDays();
        model.addAttribute("siteBasicStatistics", siteBasicStatistics);
        // 获取热门评论文章
        List<Article> mostCommentArticleList = this.articleService.getMostCommentArticleList();
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);

        return "articleDetail";
    }

    /**
     * 递增文章喜欢数
     * TODO 这里有并发的问题，考虑使用乐观锁，暂时使用悲观锁
     * @param id
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping("/like/{articleId}")
    @ResponseBody
    public String increaseArticleLikeCountById(@PathVariable("articleId") Long id) throws JsonProcessingException {
        Integer curLikeCnt = this.articleService.getArticleLikeCountById(id);
        ResultInfo resultInfo = new ResultInfo();
        if(curLikeCnt != null) {
            curLikeCnt += 1;
            boolean result = this.articleService.updateArticleLikeCountById(id, curLikeCnt);
            resultInfo.setFlag(result);
            resultInfo.setData(curLikeCnt);
        } else {
            resultInfo.setFlag(false);
        }
        return JsonUtil.javaBeanToJson(resultInfo);
    }

    @RequestMapping("/view/{articleId}")
    @ResponseBody
    public String increaseArticleViewCountById(@PathVariable("articleId") Long id) throws JsonProcessingException {
        Integer curViewCnt = this.articleService.getArticleViewCountById(id);
        ResultInfo resultInfo = new ResultInfo();
        if(curViewCnt != null) {
            curViewCnt += 1;
            boolean result = this.articleService.updateArticleViewCountById(id, curViewCnt);
            resultInfo.setFlag(result);
            resultInfo.setData(curViewCnt);
        } else {
            resultInfo.setFlag(false);
        }
        return JsonUtil.javaBeanToJson(resultInfo);
    }
}
