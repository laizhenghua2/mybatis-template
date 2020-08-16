package com.howie.service.impl;

import com.howie.dao.ProvinceDao;
import com.howie.domain.Province;
import com.howie.service.ProvinceService;
import com.howie.util.SqlSessionUtil;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao provinceDao = SqlSessionUtil.getSession().getMapper(ProvinceDao.class); // 帮我们创建实现类

    @Override
    public Province getById(String id) {
        return provinceDao.getById(id);
    }

    @Override
    public void save(Province province) {
        provinceDao.save(province);
    }

    @Override
    public List<Province> getAll() {
        return provinceDao.getAll();
    }
}
