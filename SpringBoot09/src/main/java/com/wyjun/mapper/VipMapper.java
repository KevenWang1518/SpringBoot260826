package com.wyjun.mapper;

import com.wyjun.entity.Vip;

import java.util.List;

public interface VipMapper {

    //插入会员信息
    int insert(Vip vip);

    //根据id删除会员信息
    int deleteById(Long id);

    //更新会员信息（id不可更新）
    int update(Vip vip);

    //根据id查询会员信息
    Vip selectById(Long id);

    //获取所有会员信息
    List<Vip> selectAll();
}
