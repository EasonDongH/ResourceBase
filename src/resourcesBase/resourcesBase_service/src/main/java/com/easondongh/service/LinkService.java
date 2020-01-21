package com.easondongh.service;

import com.easondongh.domain.Link;

/**
 * @author EasonDongH
 * @date 2020/1/20 10:09
 */
public interface LinkService {

    /**
     * 添加友链
     * @param link
     * @return
     */
    boolean addLink(Link link);
}
