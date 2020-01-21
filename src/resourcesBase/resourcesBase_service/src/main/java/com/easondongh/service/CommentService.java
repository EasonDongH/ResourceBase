package com.easondongh.service;

import com.easondongh.domain.Comment;

import java.util.List;

/**
 * @author EasonDongH
 */
public interface CommentService {

    /**
     * 新增评论
     * @param comment
     * @return
     */
    boolean addComment(Comment comment);

    /**
     * 根据文章id获取评论列表（status!=0）
     * @param articleId
     * @return
     */
    List<Comment> getCommentListByaid(Long articleId);

    /**
     * 获取申请友链界面的评论列表
     * @return
     */
    List<Comment> getApplyLinkComments();

    /**
     * 添加申请友链界面的评论
     * @param comment
     * @return
     */
    boolean addApplyLinkComment(Comment comment);
}
