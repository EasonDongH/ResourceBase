package com.easondongh.controller;

import com.easondongh.domain.Article;
import com.easondongh.domain.Category;
import com.easondongh.service.ArticleService;
import com.easondongh.service.CategoryService;
import com.easondongh.service.TagService;
import com.easondongh.util.SiteInfoHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author EasonDongH
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagService tagService;

    @RequestMapping("/{categoryId}")
    public String getArticleListByCid(@RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                      @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                      @PathVariable("categoryId") Long cid, Model model){
        Map<String,Object> params = new HashMap<>();
        params.put("status", 1);
        params.put("categoryId", cid);
        PageInfo<Article> pageInfo = this.articleService.pageArticle(pageIndex, pageSize, params);
        model.addAttribute("pageInfo", pageInfo);
//        List<Article> articleList = this.articleService.getArticleListByCid(cid);
//        model.addAttribute("articleList", articleList);
        // 计算面包屑导航的层次关系
        Category category = this.categoryService.getCategoryById(cid);
        model.addAttribute("category", category);
        List<Category> parentNodes = this.categoryService.getParentNodeById(category);
        model.addAttribute("parentNodes", parentNodes);

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

        return "articleListByCategory";
    }
}
