package com.easondongh.controller;

import com.easondongh.domain.Article;
import com.easondongh.domain.Category;
import com.easondongh.service.ArticleService;
import com.easondongh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/{categoryId}")
    public String getArticleListByCid(@PathVariable("categoryId") Integer cid, Model model){
        List<Article> articleList = this.articleService.getArticleListByCid(cid);
        model.addAttribute("articleList", articleList);
        Category category = this.categoryService.getCategoryById(cid);
        model.addAttribute("category", category);
        List<Category> parentNodes = this.categoryService.getParentNodeById(category);
        model.addAttribute("parentNodes", parentNodes);
        return "articleListByCategory";
    }
}
