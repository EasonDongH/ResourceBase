package com.easondongh.dao;

import com.easondongh.domain.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author EasonDongH
 */
public interface UserDao {

    /**
     * 根据id获取user
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User getById(Long id);
}
