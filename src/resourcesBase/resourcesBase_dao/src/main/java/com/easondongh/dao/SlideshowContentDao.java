package com.easondongh.dao;

import com.easondongh.domain.SlideshowContent;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SlideshowContentDao {

    /**
     * 获取状态为status的所有SlideshowContent
     * @param status
     * @return
     */
    @Select("select * from slideshowContent where status = #{status}")
    List<SlideshowContent> listByStatus(int status);
}
