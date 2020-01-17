package com.easondongh.controller;

import com.easondongh.domain.Article;
import com.easondongh.domain.Tag;
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
 * Tag标签控制器
 * @author EasonDongH
 * @date 2020/1/17 14:31
 */
@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/{tagId}")
    public String getArticleListByTid(@RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                      @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                      @PathVariable("tagId") Long tid, Model model) {
        // 获取该Tag信息
        Tag tag = this.tagService.getTagById(tid);
        if(tag == null) {
            return "index";
        }
        model.addAttribute("tag", tag);
        // 获取分页查询数据
        PageInfo<Article> pageInfo = this.articleService.pageArticleByTid(pageIndex, pageSize, tid);
        model.addAttribute("pageInfo", pageInfo);

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

        return "articleListByTag";
    }

}
