package com.easondongh.controller;

import com.easondongh.domain.Article;
import com.easondongh.domain.Notice;
import com.easondongh.domain.Options;
import com.easondongh.service.ArticleService;
import com.easondongh.service.CategoryService;
import com.easondongh.service.NoticeService;
import com.easondongh.service.OptionsService;

import com.easondongh.util.SiteInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private OptionsService optionsService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String index(Model model) throws ParseException {
        // 注意通知
        List<Notice> noticeList = this.noticeService.listNotices();
        model.addAttribute("noticeList", noticeList);
        // 文章内容
        List<Article> articleList = this.articleService.listAll();
        model.addAttribute("articleList",articleList);
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
        siteBasicStatistics[4] = 0;
        // 运行天数
        siteBasicStatistics[5] = SiteInfoHelper.getSiteRunDays();
        model.addAttribute("siteBasicStatistics", siteBasicStatistics);

        // 获取热门评论文章
        List<Article> mostCommentArticleList = this.articleService.getMostCommentArticleList();
        model.addAttribute("mostCommentArticleList", mostCommentArticleList);

        return "index";
    }


}
