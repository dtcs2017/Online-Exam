package com.bs.lsx.dao;

import java.util.List;
import java.util.Map;

import com.bs.lsx.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**根据用户名密码查询用户*/
    User getUserByUsernameAndPwd(User user);
    
    /** 查询出用户数量 */
    int getUserCount(Map<String, Object> map);
    
    /** 分页查询用户 */
    List<User> getUserPage(Map<String, Object> map);
    
}