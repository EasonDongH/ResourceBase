package com.easondongh.service.impl;

import com.easondongh.dao.OptionsDao;
import com.easondongh.domain.Options;
import com.easondongh.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionsServiceImpl implements OptionsService {

    @Autowired
    private OptionsDao optionsDao;

    @Override
    public Options getOne() {
        return this.optionsDao.getOne();
    }
}
