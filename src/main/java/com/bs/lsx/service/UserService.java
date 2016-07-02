package com.bs.lsx.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.lsx.dao.GroupMapper;
import com.bs.lsx.dao.RoleMapper;
import com.bs.lsx.dao.UserMapper;
import com.bs.lsx.dao.UserToRoleMapper;
import com.bs.lsx.entity.Group;
import com.bs.lsx.entity.User;
import com.bs.lsx.entity.UserToRole;
import com.bs.lsx.util.page.PageBean;
import com.bs.lsx.util.page.PageUtil;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private GroupMapper groupMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserToRoleMapper u2rMapper;
	
	/**
	 * 
	 * @标题: 分页查询用户
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	public PageBean UserPage(Integer pageNum, Integer pageSize, User user){
		PageBean pageBean = new PageBean();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSizeBegin", (pageNum-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("vo", user);
		try {
            Integer total = userMapper.getUserCount(map);
            List<User> list = null;
            if (total > 0) {
                list = userMapper.getUserPage(map);
            }
            @SuppressWarnings("deprecation")
            PageUtil puc = new PageUtil(list, pageNum, pageSize, total);
            pageBean = PageUtil.getPageBean(puc);
        } catch (Exception e) {
            logger.error("分页查询用户信息错误", e);
        }
        return pageBean;
	}
	
	/**
	 * 
	 * @标题: 根据用户id查找用户
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	public User getUserById(int id){
		User user = null;
		try{
			user = userMapper.selectByPrimaryKey(id);
		} catch(Exception e){
			logger.error("查找单个用户错误", e);
		}
		return user;
	}
	
	/**
	 * 
	 * @标题: 添加用户
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	@Transactional
	public void addUser(User user){
		try{
			user.setRegtime(new Date());
			userMapper.insertSelective(user);
		} catch(Exception e){
			logger.error("添加用户错误", e);
		}
	}
	
	/**
	 * 
	 * @标题: 根据用户id删除单个用户
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	@Transactional
	public void deleteUser(int id){
		try{
			userMapper.deleteByPrimaryKey(id);
		} catch(Exception e){
			logger.error("删除单个用户错误", e);
		}
	}
	
	/**
	 * 
	 * @标题: 修改单个用户
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	@Transactional
	public void updateUser(User user){
		try{
			userMapper.updateByPrimaryKeySelective(user);
		} catch(Exception e){
			logger.error("修改单个用户错误", e);
		}
	}
	
	/**
	 * 
	 * @标题: 分页查询用户组
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	public PageBean GroupPage(Integer pageNum, Integer pageSize, Group group){
		PageBean pageBean = new PageBean();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSizeBegin", (pageNum-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("vo", group);
		try {
            Integer total = groupMapper.getGroupCount(map);
            List<Group> list = null;
            if (total > 0) {
                list = groupMapper.getGroupPage(map);
            }
            @SuppressWarnings("deprecation")
            PageUtil puc = new PageUtil(list, pageNum, pageSize, total);
            pageBean = PageUtil.getPageBean(puc);
        } catch (Exception e) {
            logger.error("分页查询用户组信息错误", e);
        }
        return pageBean;
	}
	
	/**
	 * 
	 * @标题: 根据用户id查找用户组
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	public Group getGroupById(int id){
		Group group = null;
		try{
			group = groupMapper.selectByPrimaryKey(id);
		} catch(Exception e){
			logger.error("查找单个用户组错误", e);
		}
		return group;
	}
	
	/**
	 * 
	 * @标题: 添加用户组
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	@Transactional
	public void addGroup(Group group){
		try{
			groupMapper.insertSelective(group);
		} catch(Exception e){
			logger.error("添加用户组错误", e);
		}
	}
	
	/**
	 * 
	 * @标题: 根据用户组id删除单个用户组
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	@Transactional
	public void deleteGroup(int id){
		try{
			groupMapper.deleteByPrimaryKey(id);
		} catch(Exception e){
			logger.error("删除单个用户组错误", e);
		}
	}
	
	/**
	 * 
	 * @标题: 修改单个用户组
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	@Transactional
	public void updateGroup(Group group){
		try{
			groupMapper.updateByPrimaryKeySelective(group);
		} catch(Exception e){
			logger.error("修改单个用户组错误", e);
		}
	}
	
	/**
	 * 
	 * @标题: 角色名获取用户
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	public List<User> getUserListByAuth(String auth){
		int roleid = roleMapper.getRoleIdByAuth(auth);
		List<UserToRole> u2rList = u2rMapper.getRoleIdByUId(roleid);
		List<User> userList = new ArrayList<User>();
		for(int i=0; i<u2rList.size(); i++){
			User u = userMapper.selectByPrimaryKey(u2rList.get(i).getUserId());
			userList.add(u);
		}
		return userList;
	}
	
	/**
	 * 
	 * @标题: 根据用户名密码查询用户
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
    public User getUserByUsernameAndPwd(User user){
    	return userMapper.getUserByUsernameAndPwd(user);
    }


}
