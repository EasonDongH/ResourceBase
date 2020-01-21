package com.easondongh.controller;

import com.easondongh.domain.*;
import com.easondongh.service.*;
import com.easondongh.util.JsonUtil;
import com.easondongh.util.LiteralPool;
import com.easondongh.util.SiteInfoHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 统计与展示网站相关信息
 * @author EasonDongH
 * @date 2020/1/20 8:36
 */
@Controller
@RequestMapping("/site")
public class SiteController {

    private static final String LOGIN_USER = "current_user";

    @Autowired
    private ArticleService articleService;
    @Autowired
    private LinkService linkService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagService tagService;

    private User getLoginUser(HttpServletRequest request){
        User user = null;
        HttpSession session = request.getSession();
        Object obj = session.getAttribute(LOGIN_USER);
        if(obj != null) {
            user = (User) obj;
        }
        return user;
    }

    /**
     * 获取申请友链界面
     * @return
     */
    @RequestMapping("/applyLink")
    public String applyLink(Model model){
        Article article = this.articleService.getArticleById(LiteralPool.APPLY_LINK_ID);
        if(article != null) {
            article.setArticleViewCount(article.getArticleViewCount() + 1);
            model.addAttribute("article", article);
            List<Comment> commentList = this.commentService.getApplyLinkComments();
            model.addAttribute("commentList", commentList);
            this.articleService.updateArticleViewCountById(LiteralPool.APPLY_LINK_ID, article.getArticleViewCount());
        }
        return "applyLink";
    }

    /**
     * 申请友链
     * @return
     */
    @RequestMapping(value = "/applyLinkSubmit", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String applyLinkForm(Link link, HttpServletRequest request) throws JsonProcessingException {
        User loginUser = getLoginUser(request);
        if(loginUser != null) {
            link.setUserId(loginUser.getId());
        }
        ResultInfo resultInfo = new ResultInfo();
        if(this.linkService.addLink(link)) {
            resultInfo.setFlag(true);
            resultInfo.setData("申请成功，请耐心等待审核！");
        } else {
            resultInfo.setFlag(false);
            resultInfo.setData("申请失败，请重试或联系管理员！");
        }
        return JsonUtil.javaBeanToJson(resultInfo);
    }

    @RequestMapping("/siteMap")
    public String siteMap(Model model) {
        List<Article> articleList = this.articleService.listIdAndTitle();
        model.addAttribute("articleList", articleList);
        List<Category> categoryList = this.categoryService.listWithDescOrder();
        model.addAttribute("categoryList", categoryList);
        List<Tag> tagList = this.tagService.listAll();
        model.addAttribute("tagList", tagList);
        return "siteMap";
    }

    @RequestMapping("/message")
    public String message(){
        return "message";
    }

    @RequestMapping("/articleArchive")
    public String articleArchive(Model model) {
        Set<String> info = new HashSet<>();
        info.add("id"); info.add("articleTitle"); info.add("articleCreateTime");
        List<Article> articleList = this.articleService.listPartInfo(info);
        ArticleGroup articleGroup = new ArticleGroup(articleList);
        model.addAttribute("articleGroup", articleGroup);
        return "articleArchive";
    }

    @RequestMapping("/aboutSite")
    public String aboutSite(Model model){
        Article article = this.articleService.getArticleById(LiteralPool.About_Site_Article_Id);
        model.addAttribute("article", article);
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
        siteBasicStatistics[4] = this.tagService.countTag();;
        // 运行天数
        siteBasicStatistics[5] = SiteInfoHelper.getSiteRunDays();
        model.addAttribute("siteBasicStatistics", siteBasicStatistics);
        return "aboutSite";
    }
}
