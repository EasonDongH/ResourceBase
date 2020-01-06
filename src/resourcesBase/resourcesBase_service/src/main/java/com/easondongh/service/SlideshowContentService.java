package com.easondongh.service;

import com.easondongh.domain.SlideshowContent;

import java.util.List;

public interface SlideshowContentService {

    /**
     * 获取状态为status的所有SlideshowContent
     * @param status
     * @return
     */
    List<SlideshowContent> listByStatus(int status);
}
