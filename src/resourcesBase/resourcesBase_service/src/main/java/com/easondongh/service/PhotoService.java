package com.easondongh.service;

import com.easondongh.domain.Photo;

public interface PhotoService {

    /**
     * 根据id获取photo对象
     * @param id
     * @return
     */
    Photo getById(Integer id);
}
