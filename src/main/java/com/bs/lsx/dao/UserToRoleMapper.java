package com.bs.lsx.dao;

import java.util.List;

import com.bs.lsx.entity.UserToRole;

public interface UserToRoleMapper {
    int insert(UserToRole record);

    int insertSelective(UserToRole record);
    
    //根据roleid获取user2role列表
    List<UserToRole> getRoleIdByUId(int roleid);
}