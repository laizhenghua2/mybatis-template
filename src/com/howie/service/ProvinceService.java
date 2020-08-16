package com.howie.service;
import com.howie.domain.Province;
import java.util.List;

public interface ProvinceService {
    public Province getById(String id);
    public void save(Province province);

    List<Province> getAll();
}
