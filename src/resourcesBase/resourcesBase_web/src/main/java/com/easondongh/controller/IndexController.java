package com.easondongh.controller;

import com.easondongh.domain.Article;
import com.easondongh.domain.Notice;
import com.easondongh.domain.Options;
import com.easondongh.service.ArticleService;
import com.easondongh.service.NoticeService;
import com.easondongh.service.OptionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private OptionsService optionsService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/")
    public String index(Model model){
        // 注意通知
        List<Notice> noticeList = this.noticeService.listNotices();
        model.addAttribute("noticeList", noticeList);
        // 文章内容
        List<Article> articleList = this.articleService.listAll();
        model.addAttribute("articleList",articleList);

        return "index";
    }


}
