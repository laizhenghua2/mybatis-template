package com.howie.dao;
import com.howie.domain.Province;
import com.howie.vo.ProvinceAndCityVo;

import java.util.List;
import java.util.Map;

public interface ProvinceDao {
    /*
    注意这里的方法名：必须和标签的id属性相同
     */
    public Province getById(String id);
    public void save(Province province);

    List<Province> getAll();

    List<Map<String, Object>> select1();

    List<ProvinceAndCityVo> select2();

    List<ProvinceAndCityVo> select3(String s);
}
