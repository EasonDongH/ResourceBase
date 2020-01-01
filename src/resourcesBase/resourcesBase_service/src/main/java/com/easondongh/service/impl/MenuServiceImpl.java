package com.easondongh.service.impl;

import com.easondongh.dao.MenuDao;
import com.easondongh.domain.Menu;
import com.easondongh.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> listMenuWithDescOrder() {
        return this.menuDao.listMenuWithDescOrder();
    }
}
