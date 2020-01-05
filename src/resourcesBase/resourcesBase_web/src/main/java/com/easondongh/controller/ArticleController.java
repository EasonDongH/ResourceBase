package com.easondongh.controller;

import com.easondongh.domain.Article;
import com.easondongh.domain.Category;
import com.easondongh.domain.ResultInfo;
import com.easondongh.service.ArticleService;
import com.easondongh.service.CategoryService;
import com.easondongh.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 查询文章详细
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{articleId}")
    public String getArticleById(@PathVariable("articleId") Integer id, Model model){
        Article article = this.articleService.getArticleById(id);
        if(article == null) {// 对无效查询响应主页面
            return "index";
        }
        List<Category> parentNodes = this.categoryService.getParentNodeById(article.getCategory());
        model.addAttribute("article", article);
        model.addAttribute("parentNodes", parentNodes);
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
    public String increaseArticleLikeCountById(@PathVariable("articleId") Integer id) throws JsonProcessingException {
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
    public String increaseArticleViewCountById(@PathVariable("articleId") Integer id) throws JsonProcessingException {
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
