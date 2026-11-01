package com.wyjun;

import com.wyjun.entity.Car;
import com.wyjun.mapper.CarMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MySpringBootApplicationTests {

    @Autowired
    private CarMapper carMapper;

    @Test
    void testInsert(){
        Car car = new Car();
        car.setCarNum("999");
        car.setBrand("小米su7");
        car.setGuidePrice(30.00);
        car.setProduceTime("2025-10-11");
        car.setCarType("电车");
        int count = carMapper.insert(car);
        System.out.println("插入" + count + "条记录");
    }

    @Test
    void testDeleteById(){
        int count = carMapper.deleteById(7L);
        System.out.println("删除了" + count + "条记录");
    }

    @Test
    void testUpdateById(){
        Car car = new Car();
        car.setId(8L);
        car.setBrand("小米utl");
        int count = carMapper.updateById(car);
        System.out.println("更新了" + count + "条记录");
    }

    @Test
    void testSelectById(){
        Car car = carMapper.selectById(8L);
        System.out.println(car);
    }

    @Test
    void testSelectAll(){
        List<Car> cars = carMapper.selectList(null);
        cars.forEach(System.out::println);
    }
}
