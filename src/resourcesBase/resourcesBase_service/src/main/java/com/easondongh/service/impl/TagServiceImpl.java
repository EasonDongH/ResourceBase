package com.easondongh.service.impl;

import com.easondongh.dao.TagDao;
import com.easondongh.domain.Tag;
import com.easondongh.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author EasonDongH
 * @date 2020/1/17 13:31
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public Integer countTag() {
        return this.tagDao.countTag();
    }

    @Override
    public Tag getTagById(Long id) {
        return this.tagDao.getTagById(id);
    }

    @Override
    public List<Tag> listAll() {
        return tagDao.getList();
    }
}
