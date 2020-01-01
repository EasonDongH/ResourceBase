package com.easondongh.dao;

import com.easondongh.domain.Notice;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NoticeDao {

    /**
     * 按noticeOrder倒序排序
     * @return
     */
    @Select("select * from notice order by noticeOrder desc")
    List<Notice> listNotices();
}
