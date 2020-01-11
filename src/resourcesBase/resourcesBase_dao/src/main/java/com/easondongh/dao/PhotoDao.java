package com.easondongh.dao;

import com.easondongh.domain.Photo;
import org.apache.ibatis.annotations.Select;

/**
 * @author EasonDongH
 */
public interface PhotoDao {

    /**
     * 根据id获取photo对象
     * @param id
     * @return
     */
    @Select("select * from photo where id = #{id}")
    Photo getById(Long id);
}
