package com.bs.lsx.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bs.lsx.entity.User;
import com.bs.lsx.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	public void login(){
		
	}
	
	@RequestMapping("checklogin")
	public String checklogin(User user, HttpServletRequest request){
		List<User> userList = userService.getUserListByAuth("ROLE_ADMIN");
		System.out.println(userList.get(0).getUsername()+userList.get(0).getPassword()+"===========");
		if(userList.size()>0){
			if(user.getUsername().equals(userList.get(0).getUsername()) && user.getPassword().equals(userList.get(0).getPassword())){
				HttpSession session = request.getSession(false);
				session.setAttribute("user", userList.get(0));
				return "redirect:index";
			}
		}
		return "redirect:login";
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:login";
	}
	
	@RequestMapping("index")
	public void index(){
		
	}
	
	/*private Model getRoleModel(HttpServletRequest reqeust, Integer pageSize, Integer pageNum, Model modal){
		
	}*/

}
