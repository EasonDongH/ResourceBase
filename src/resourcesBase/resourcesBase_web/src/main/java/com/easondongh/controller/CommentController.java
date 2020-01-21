package com.easondongh.controller;

import com.easondongh.domain.Comment;
import com.easondongh.domain.ResultInfo;
import com.easondongh.domain.User;
import com.easondongh.service.ArticleService;
import com.easondongh.service.CommentService;
import com.easondongh.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author EasonDongH
 * @date 2020/1/11 20:48
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    /**
     * session中存放当前登录者的Key
     */
    private static final String LOGIN_USER = "current_user";

    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addComment(Comment comment, HttpServletRequest request) throws JsonProcessingException {
        HttpSession session = request.getSession();
        Object obj = session.getAttribute(LOGIN_USER);
        if(obj != null) {
            User curUser = (User)obj;
            if(curUser != null) {
                comment.setUserId(curUser.getId());
                comment.setNickName(curUser.getNickName());
            }
        }
        ResultInfo resultInfo = new ResultInfo();
        if(commentService.addComment(comment)) {
            resultInfo.setFlag(true);
            resultInfo.setData("评论成功");
        } else {
            resultInfo.setFlag(false);
            resultInfo.setData("评论失败");
        }
        return JsonUtil.javaBeanToJson(resultInfo);
    }
}
