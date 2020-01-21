package com.easondongh.service.impl;

import com.easondongh.dao.ArticleDao;
import com.easondongh.dao.CommentDao;
import com.easondongh.domain.Comment;
import com.easondongh.service.CommentService;
import com.easondongh.util.IdGenerator;
import com.easondongh.util.LiteralPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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

    private IdGenerator idGenerator = new IdGenerator();

    @Override
    @Transactional
    public boolean addComment(Comment comment) {
        boolean result = false;
        comment.setId(idGenerator.next());
        Date date = new Date();
        comment.setCreateTime(date);
        comment.setUpdateTime(date);
        if(comment.getUserId() == null) {
            comment.setNickName("游客"+comment.getId());
        }
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

    @Override
    public List<Comment> getApplyLinkComments() {
        return this.commentDao.getCommentListByaid(LiteralPool.APPLY_LINK_ID);
    }

    @Override
    public boolean addApplyLinkComment(Comment comment) {
        comment.setId(idGenerator.next());
        comment.setAid(LiteralPool.APPLY_LINK_ID);
        comment.setCreateTime(new Date());
        return this.commentDao.addComment(comment) > 0;
    }
}
