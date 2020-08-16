package com.howie.test;
import com.howie.domain.Province;
import com.howie.service.ProvinceService;
import com.howie.service.impl.ProvinceServiceImpl;
import com.howie.util.ServiceFactory;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        // 这里得到代理类(经济人)
        ProvinceService provinceService = (ProvinceService) ServiceFactory.getService(new ProvinceServiceImpl());

        // 测试业务1
        Province province = provinceService.getById("1");
        System.out.println(province);

        // 测试业务2
        /*Province province = new Province(10,"云南","滇","昆明");
        provinceService.save(province);*/

        // 查询所有记录
        /*List<Province> provinceList = provinceService.getAll();
        for(Province p:provinceList){
            System.out.println(p);
        }*/
    }
}
