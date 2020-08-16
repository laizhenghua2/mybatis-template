package com.howie.test;
        import com.howie.dao.ProvinceDao;
        import com.howie.domain.Province;
        import com.howie.util.SqlSessionUtil;
        import com.howie.vo.ProvinceAndCityVo;

        import java.util.List;
        import java.util.Map;
        import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        // 接口 = 接口实现类
        ProvinceDao provinceDao = SqlSessionUtil.getSession().getMapper(ProvinceDao.class); // 创建实现类
        // 测试多表查询
        // 案例1：查询省份名称和省份划分的城市
        /*List<Map<String,Object>> mapList = provinceDao.select1();
        for(Map<String,Object> map:mapList){
            Set<String> set = map.keySet();
            for(String key:set){
                System.out.println("省份：" + key);
                System.out.println("城市：" + map.get(key));
            }
        }*/

        // 案例2：查询所有省份和城市信息，加vo(view object)/(value object) 视图对象
        /*
        在实际项目开发中，如果需要为前端展现的数据，使用一个domain类型不足以表现出来这些数据
        这时我们可以考虑使用两种技术来实现，分别为
        使用map以及使用vo
            例如我们现在的需求(查询省份和城市所有信息)
            得到的结果，使用学生的domain或者班级的domain都不能够封装这些结果

            所以我们可以使用map去保存这些信息
            同时我们也可以使用vo类来保存这些信息，此时ov类需要我们自己创建出来，其属性由查询结果来决定
         */
        /*List<ProvinceAndCityVo> provinceAndCityList = provinceDao.select2();
        for(ProvinceAndCityVo pc:provinceAndCityList){
            System.out.println(pc);
        }*/

        // 案例3：查询省份名称带江字的省份信息和城市信息
        List<ProvinceAndCityVo> provinceAndCityVoList = provinceDao.select3("江");
        for(ProvinceAndCityVo vo:provinceAndCityVoList){
            System.out.println(vo);
        }
        /*
        总结：
        实际项目开发中，如果要为前端同时提供多组值，那么我们应该使用map还是vo呢？
        如果前端的需求的重复率不高，那么我们选择临时使用map就可以了
        如果前端对于需求的重复率较高，那么我们可以创建一个vo类来使用，非常方便
         */
    }
}