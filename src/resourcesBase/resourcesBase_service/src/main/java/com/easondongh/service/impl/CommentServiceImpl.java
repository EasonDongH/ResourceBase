package com.easondongh.service.impl;

import com.easondongh.dao.CommentDao;
import com.easondongh.domain.Comment;
import com.easondongh.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author EasonDongH
 * @date 2020/1/11 20:37
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public boolean addComment(Comment comment) {
        comment.setId(System.nanoTime());
        Date date = new Date();
        comment.setCreateTime(date);
        comment.setUpdateTime(date);
        return commentDao.addComment(comment) > 0;
    }

    @Override
    public List<Comment> getCommentListByaid(Long articleId) {
        List<Comment> list = commentDao.getCommentListByaid(articleId);
        for(Comment comment : list) {
            comment.setChildCommentCount((int)list.stream().filter(f->f.getPid() == comment.getId()).count());
        }
        return list;
    }
}
