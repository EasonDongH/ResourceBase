package com.easondongh.service;

import com.easondongh.domain.Notice;

import java.util.List;

public interface NoticeService {

    /**
     * 按noticeOrder倒序排序
     * @return
     */
    List<Notice> listNotices();
}
