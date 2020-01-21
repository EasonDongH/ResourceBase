package com.easondongh.service.impl;

import com.easondongh.dao.CommentDao;
import com.easondongh.dao.LinkDao;
import com.easondongh.domain.Comment;
import com.easondongh.domain.Link;
import com.easondongh.service.CommentService;
import com.easondongh.service.LinkService;
import com.easondongh.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 *
 * @author EasonDongH
 * @date 2020/1/20 10:10
 */
@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkDao linkDao;
    @Autowired
    private CommentService commentService;

    private IdGenerator idGenerator = new IdGenerator();

    @Override
    @Transactional
    public boolean addLink(Link link) {
        boolean result = false;
        link.setId(idGenerator.next());
        if(link.getUserId() == null) {
            link.setUserId(0L);
        }
        if(this.linkDao.addLink(link) > 0) {
            Comment comment = new Comment();
            comment.setUserId(link.getUserId());
            comment.setContent(link.toString());
            result =  commentService.addApplyLinkComment(comment);
        }
        return result;
    }
}
