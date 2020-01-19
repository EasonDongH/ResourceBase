package com.easondongh.service.impl;

import com.easondongh.dao.ArticleDao;
import com.easondongh.dao.CommentDao;
import com.easondongh.domain.Comment;
import com.easondongh.service.CommentService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author EasonDongH
 * @date 2020/1/11 20:37
 */
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ArticleDao articleDao;

    @Override
    @Transactional
    public boolean addComment(Comment comment) {
        boolean result = false;
        comment.setId(System.nanoTime());
        Date date = new Date();
        comment.setCreateTime(date);
        comment.setUpdateTime(date);
        try {
            if(commentDao.addComment(comment) > 0){
                result = this.articleDao.incrementArticleCommentCountById(comment.getAid()) > 0;
            }
        } catch (Exception ex) {
            log.error("addComment", ex);
        }
        return result;
    }

    @Override
    public List<Comment> getCommentListByaid(Long articleId) {
        List<Comment> list = commentDao.getCommentListByaid(articleId);
        for(Comment comment : list) {
            comment.setChildCommentCount((int)list.stream().filter(f->f.getPid().equals(comment.getId())).count());
        }
        return list;
    }
}
