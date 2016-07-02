package com.bs.lsx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.lsx.dao.GroupMapper;
import com.bs.lsx.entity.Group;

@Service
public class GroupService {
	private static final Logger logger = LoggerFactory.getLogger(GroupService.class);
	@Autowired
	private GroupMapper groupMapper;
	
	/**
	 * 
	 * @标题: 查询出所有用户组
	 * @创建人: lsx
	 * @创建时间: 2016年4月22日
	 * @return
	 */
	public List<Group> findAllGroup(){
		List<Group> groupList = null;
		try{
			groupList = groupMapper.selectAllGroup();
		} catch(Exception e){
			logger.error("查询用户组错误", e);
		}
		return groupList;
	}
	
	/**
	 * 
	 * @标题: 查询出用户组列表
	 * @创建人: lsx
	 * @创建时间: 2016年4月22日
	 * @return
	 */
	public List<Group> getGroupList(Group group){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vo", group);
		return groupMapper.getGroupList(map);
	}
	
}
