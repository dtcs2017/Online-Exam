package com.bs.lsx.dao;

import com.bs.lsx.entity.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    //根据角色名得到角色id
    int getRoleIdByAuth(String auth);
}