package com.wyjun;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wyjun.entity.Car;
import com.wyjun.mapper.CarMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class MySpringBootApplicationTests {

    @Autowired
    private CarMapper carMapper;

    //查询出汽车品牌中带有 '宝' 的，厂商指导价大于20万的，要求查询 id、car_num、brand、guide_price 字段。
    //如果写SQL语句应该这样写：select id,car_num,brand,guide_price from t_car where brand like '%宝%' and guide_price > 20;
    //这种方式是通过代码来生成SQL语句。不需要人工编写CarMapper.xml文件。
    @Test
    void testQueryWrapper() {
        // 1. 创建条件构造器对象。
        QueryWrapper<Car> wrapper = new QueryWrapper<>();
        // 2. 链式追加条件，采用链式调用的方式构建查询条件。
        wrapper.select("id", "car_num", "brand", "guide_price")  //字段名是硬编码的，扩展性差，维护成本高
                .like("brand", "宝")  //底层会自动生成brand like'%宝%'
                .gt("guide_price", new BigDecimal("20.0"));//链式调用添加的条件都是并且的关系“AND”
                //.or(); //如果是or的关系要调用or()方法。
        // 3. 执行查询语句
        List<Car> cars = carMapper.selectList(wrapper);
        cars.forEach(System.out::println);
    }
    //Car(id=2, carNum=京A66666, brand=宝马730, guidePrice=37.0, produceTime=null, carType=null)
    //Car(id=12, carNum=京A66666, brand=宝马525, guidePrice=34.2, produceTime=null, carType=null)
    //Car(id=13, carNum=京A66666, brand=宝马760, guidePrice=30.79, produceTime=null, carType=null)

    //注意：这种mybatis方式和上面mybatis plus方式不一样，是在CarMapper.xml中自定义方法的形式实现的。
    //这种方式是人工手动编写SQL。需要人工编写CarMapper.xml文件。
    @Test
    void testQueryWrapper2() {
        List<Car> cars = carMapper.selectByCondition("宝", new BigDecimal("20.0"));
        cars.forEach(System.out::println);
    }
    //Car(id=2, carNum=京A66666, brand=宝马730, guidePrice=37.0, produceTime=2025-10-12, carType=新能源)
    //Car(id=12, carNum=京A66666, brand=宝马525, guidePrice=34.2, produceTime=2023-10-11, carType=旧能源)
    //Car(id=13, carNum=京A66666, brand=宝马760, guidePrice=30.79, produceTime=2025-10-11, carType=新能源)
}
