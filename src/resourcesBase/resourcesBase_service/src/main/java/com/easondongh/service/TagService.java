package com.easondongh.service;

import com.easondongh.domain.Tag;

import java.util.List;

/**
 * @author EasonDongH
 * @date 2020/1/17 13:30
 */
public interface TagService {

    /**
     * 统计标签数量
     * @return
     */
    Integer countTag();

    /**
     * 根据唯一id获取Tag
     * @param id
     * @return
     */
    Tag getTagById(Long id);

    /**
     * 获取所有的tag
     * @return
     */
    List<Tag> listAll();
}
