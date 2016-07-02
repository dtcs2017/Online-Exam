package com.bs.lsx.dao;

import java.util.List;
import java.util.Map;

import com.bs.lsx.entity.Group;

public interface GroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
    
    /**查询出用户组列表*/
    List<Group> getGroupList(Map<String, Object> map);
    
    /**查询出用户组数量*/
    int getGroupCount(Map<String, Object> map);
    
    /**分页查询用户组*/
    List<Group> getGroupPage(Map<String, Object> map);
    
    /**查询出用户组放入List集合 */
    List<Group> selectAllGroup();
    
}