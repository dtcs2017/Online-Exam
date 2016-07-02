package com.bs.lsx.action.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;

import com.bs.lsx.entity.Group;
import com.bs.lsx.entity.User;
import com.bs.lsx.service.UserService;
import com.bs.lsx.util.page.PageBean;

@Controller
@RequestMapping("/admin/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	private Model getUserModel(HttpServletRequest request,Integer pageSize, Integer pageNum, Model model,User user){
		user = user==null? new User() : user;
		pageNum = pageNum == null ? 1 : pageNum;
	    pageSize = pageSize == null ? 10 : pageSize;
	        
		PageBean pageBean  = userService.UserPage(pageNum, pageSize, user);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("user",user);
	    return model;
	}
	
	private Model getGroupModel(HttpServletRequest request,Integer pageSize, Integer pageNum, Model model,Group group){
		group = group==null? new Group() : group;
		pageNum = pageNum == null ? 1 : pageNum;
	    pageSize = pageSize == null ? 10 : pageSize;
	        
		PageBean pageBean  = userService.GroupPage(pageNum, pageSize, group);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("group",group);
	    return model;
	}
	
	@RequestMapping("index")
	public void index( HttpServletRequest request,Integer pageSize, Integer pageNum, Model model,User user){
		getUserModel(request, pageSize, pageNum, model, user);
	}
	
	@RequestMapping("list")
	public void list( HttpServletRequest request,Integer pageSize, Integer pageNum, Model model,User user){
		getUserModel(request, pageSize, pageNum, model, user);
	}
	
	@RequestMapping("userlist")
	public
	@ResponseBody
	PageBean userlist(HttpServletRequest request,Integer pageSize, Integer pageNum, Model model,User user){
		user = user==null? new User() : user;
		pageNum = pageNum == null ? 1 : pageNum;
	    pageSize = pageSize == null ? 10 : pageSize;
	        
		PageBean pageBean  = userService.UserPage(pageNum, pageSize, user);
		
		return pageBean;
	}
	
	@RequestMapping("add")
	public void add(HttpServletRequest request, Model model){
		
	}
	
	@RequestMapping("doAdd")
	public
	@ResponseBody
	Map<String, Object> doAdd(HttpServletRequest request, User user, String token){
		boolean sessionFlag = true;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 300);
		map.put("success", false);
		map.put("message", "保存失败");
		
		if(sessionFlag){
			try{
				user.setRegtime(new Date());
				userService.addUser(user);
				map.put("statusCode", 200);
				map.put("success", true);
				map.put("message", "保存成功");
			} catch(Exception e){
				e.printStackTrace();
			}
		} else{
			map.put("statsuCode", 300);
			map.put("success", false);
			map.put("message", "请不要重复提交");
		}
		
		return map;
	}
	
	@RequestMapping("update")
	public void update(HttpServletRequest request, Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userService.getUserById(userId);
		model.addAttribute("user", user);
	}
	
	@RequestMapping("doUpdate")
	public
	@ResponseBody
	Map<String, Object> doUpdate(HttpServletRequest request, User user, String token){
		boolean sessionFlag = true;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 300);
		map.put("success", false);
		map.put("message", "保存失败");
		
		if(sessionFlag){
			try{
				userService.updateUser(user);
				map.put("statusCode", 200);
				map.put("success", true);
				map.put("message", "保存成功");
			} catch(Exception e){
				e.printStackTrace();
			}
		} else{
			map.put("statusCode", 300);
			map.put("success", false);
			map.put("message", "请不要重复提交");
		}
		return map;
	}
	
	@RequestMapping("doDelete")
	public
	@ResponseBody
	Map<String, Object> doDelete(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 300);
		map.put("success", false);
		map.put("message", "删除失败");
		try{
			userService.deleteUser(id);
			map.put("statusCode", 200);
			map.put("success", true);
			map.put("message", "删除成功");
		} catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("group")
	public void group( HttpServletRequest request,Integer pageSize, Integer pageNum, Model model,Group group){
		getGroupModel(request, pageSize, pageNum, model, group);
	}
	
	@RequestMapping("groupadd")
	public void groupadd(HttpServletRequest request, Model model){
		
	}
	
	@RequestMapping("groupdoAdd")
	public
	@ResponseBody
	Map<String, Object> groupdoAdd(HttpServletRequest request, Group group, String token){
		boolean sessionFlag = true;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 300);
		map.put("success", false);
		map.put("message", "保存失败");
		
		if(sessionFlag){
			try{
				
				userService.addGroup(group);
				map.put("statusCode", 200);
				map.put("success", true);
				map.put("message", "保存成功");
			} catch(Exception e){
				e.printStackTrace();
			}
		} else{
			map.put("statsuCode", 300);
			map.put("success", false);
			map.put("message", "请不要重复提交");
		}
		
		return map;
	}
	
	@RequestMapping("groupupdate")
	public void groupupdate(HttpServletRequest request, Model model, Group group){
		//int groupId = Integer.parseInt(request.getParameter("id"));
		//Group group = userService.getGroupById(groupId);
		
		model.addAttribute("group", group);
	}
	
	@RequestMapping("groupdoUpdate")
	public
	@ResponseBody
	Map<String, Object> groupdoUpdate(HttpServletRequest request, Group group, String token, String userids){
		boolean sessionFlag = true;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 300);
		map.put("success", false);
		map.put("message", "保存失败");
		
		if(sessionFlag){
			try{
				//将获取的字符串用户Id存入userIds数组
				String userIds[] = userids.split(","); 
				//遍历userIds，批量添加用户到用户组
				for(String userid : userIds){
					//声明一个用户组对象
					Group group1 = new Group();
					//将用户组名,用户id设置到用户组对象
					group1.setGroupName(group.getGroupName());
					group1.setUserId(Integer.parseInt(userid));
					//添加用户组
					userService.addGroup(group1);
				}
				//userService.updateGroup(group);
				map.put("statusCode", 200);
				map.put("success", true);
				map.put("message", "保存成功");
			} catch(Exception e){
				e.printStackTrace();
			}
		} else{
			map.put("statusCode", 300);
			map.put("success", false);
			map.put("message", "请不要重复提交");
		}
		return map;
	}
	
	@RequestMapping("groupdoDelete")
	public
	@ResponseBody
	Map<String, Object> groupdoDelete(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 300);
		map.put("success", false);
		map.put("message", "删除失败");
		try{
			userService.deleteGroup(id);
			map.put("statusCode", 200);
			map.put("success", true);
			map.put("message", "删除成功");
		} catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}

}
