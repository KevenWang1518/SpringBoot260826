package com.wyjun.mapper;

import com.wyjun.entity.User;

/**
* @author Administrator
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2026-10-09 20:15:13
* @Entity com.wyjun.entity.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
