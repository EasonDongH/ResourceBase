package com.easondongh.service.impl;

import com.easondongh.dao.SlideshowContentDao;
import com.easondongh.domain.SlideshowContent;
import com.easondongh.service.SlideshowContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlideshowContentServiceImpl implements SlideshowContentService {

    @Autowired
    private SlideshowContentDao slideshowContentDao;

    @Override
    public List<SlideshowContent> listByStatus(int status) {
        return this.slideshowContentDao.listByStatus(status);
    }
}
