package com.easondongh.service.impl;

import com.easondongh.dao.NoticeDao;
import com.easondongh.domain.Notice;
import com.easondongh.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<Notice> listNotices() {
        return this.noticeDao.listNotices();
    }
}
