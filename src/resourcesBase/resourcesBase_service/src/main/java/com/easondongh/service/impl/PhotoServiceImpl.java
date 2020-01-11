package com.easondongh.service.impl;

import com.easondongh.dao.PhotoDao;
import com.easondongh.domain.Photo;
import com.easondongh.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoDao photoDao;

    @Override
    public Photo getById(Long id) {
        return this.photoDao.getById(id);
    }
}
