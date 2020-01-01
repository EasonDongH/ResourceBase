package com.easondongh.dao;

import com.easondongh.domain.Options;
import org.apache.ibatis.annotations.Select;

public interface OptionsDao {

    /**
     * 获取查询到的首个options
     * @return
     */
    @Select("select * from options limit 1")
    Options getOne();
}
