package com.easondongh.service.impl;

import com.easondongh.dao.TagDao;
import com.easondongh.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
