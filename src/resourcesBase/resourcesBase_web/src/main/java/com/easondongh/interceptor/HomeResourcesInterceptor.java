package com.easondongh.interceptor;

import com.easondongh.domain.Category;
import com.easondongh.domain.Menu;
import com.easondongh.domain.Options;
import com.easondongh.service.CategoryService;
import com.easondongh.service.MenuService;
import com.easondongh.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class HomeResourcesInterceptor implements HandlerInterceptor {

    @Autowired
    private OptionsService optionsService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private CategoryService categoryService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 博客基本信息显示
        Options options = optionsService.getOne();
        request.setAttribute("options", options);
        // 顶部菜单信息
        List<Menu> menuList = menuService.listMenuWithDescOrder();
        request.setAttribute("menuList", menuList);
        // 分类列表
        List<Category> categoryList =  categoryService.listWithDescOrder();
        request.setAttribute("categoryList", categoryList);

        return true;
    }
}
