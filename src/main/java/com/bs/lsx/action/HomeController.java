package com.bs.lsx.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.lsx.entity.Exam;
import com.bs.lsx.entity.ExamPaper;
import com.bs.lsx.entity.Group;
import com.bs.lsx.entity.Question;
import com.bs.lsx.entity.User;
import com.bs.lsx.entity.common.AnswerSheet;
import com.bs.lsx.entity.common.Message;
import com.bs.lsx.service.ExamPaperService;
import com.bs.lsx.service.ExamService;
import com.bs.lsx.service.GroupService;
import com.bs.lsx.service.QuestionService;
import com.bs.lsx.service.UserService;
import com.bs.lsx.util.JsonUtils;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ExamService examService;
	
	@Autowired
	private ExamPaperService examPaperService;
	
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public void login(){
		
	}
	
	//使用@RequestMapping注解指定请求的地址，并将页面传来的数据自动绑定到user
	@RequestMapping("/checklogin")
	public String checklogin(HttpServletRequest request, User user){
		//根据用户名，密码获取用户实体，传入的参数为user
		User u = userService.getUserByUsernameAndPwd(user);
		//判断查询的用户实体是否为空
		if(u!=null){
			//不为空时存储session，以便登陆后使用
			HttpSession session = request.getSession(false);
			session.setAttribute("user", u);
			//验证成功后跳转到首页
			return "redirect:home";
		}
		//验证不成功跳转到登陆页
		return "redirect:login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:login";
	}
	
	@RequestMapping("/home")
	public void home(){
		
	}
	
	@RequestMapping("/register")
	public void register(){
		
	}
	
	@RequestMapping("/usercenter")
	public void usercenter(HttpServletRequest request, Model model){
		HttpSession session = request.getSession(false);
		User u = (User) session.getAttribute("user");
		model.addAttribute("user", u);
	}
	
	@RequestMapping(value="/user-reg",produces="application/json;charset=UTF-8")
	public
	@ResponseBody Map<String, Object> doReg(@RequestBody User user){
		System.out.println("----------------------"+user.getUsername());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", false);
		map.put("message", "注册失败");
		try {
			userService.addUser(user);
			map.put("success", true);
			map.put("message", "注册成功");
		} catch (Exception e) {
			
		}
		return map;
	}
	
	@RequestMapping("/exam")
	public void exam(HttpServletRequest request, Model model){
		//声明一个考试列表
		List<Exam> examList = new ArrayList<Exam>();
		//创建一个用户组对象
		Group group = new Group();
		//根据session获取当前登陆的学生实体信息
		HttpSession session = request.getSession(false);
		User u = (User) session.getAttribute("user");
		//根据用户id获取用户组列表
		group.setUserId(u.getId());
		List<Group> groupList = groupService.getGroupList(group);
		//遍历用户组列表
		for(int i=0; i<groupList.size(); i++){
			//声明一个考试对象
			Exam exam = new Exam();
			//根据用户组id查询出考试列表项
			exam.setGroupId(groupList.get(i).getId());
			List<Exam> examItem = examService.getExamList(exam);
			//遍历考试列表项放入考试列表
			for(int j=0; j<examItem.size(); j++){
				Exam exam2 = examItem.get(j);
				examList.add(exam2);
			}
		}
		//将考试列表examList存入examList变量，供页使用
		model.addAttribute("examList", examList);
	}
	
	@RequestMapping(value = "/examing/{examId}", method = RequestMethod.GET)
	//将页面传值过来的考试id绑定到examId参数上
	public String examing(Model model, HttpServletRequest request, @PathVariable("examId") int examId){
		//声明试卷作答时长
		int duration = 0;
		//根据考试id获取考试实体
		Exam exam = examService.getExamById(examId);
		//根据试卷id获取试卷实体
		ExamPaper examPaper = examPaperService.getExamPaperById(exam.getExamPaperid());
		//获取试卷的内容
		String content = examPaper.getContent();
		List<Object> questionList = null;
		try {
			//将json格式的试卷内容转换成试题列表
			questionList = JsonUtils.jsonToList(content, Question.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//获取试卷作答时长
		duration = examPaper.getDuration();
		//获取考试开始时间
		Date startTime = exam.getStartTime();
		//将需要的信息存入属性变量中，供页面使用
		model.addAttribute("startTime", startTime);
		model.addAttribute("duration", duration*60);
		model.addAttribute("examPaperId", examPaper.getId());
		model.addAttribute("examId", exam.getId());
		model.addAttribute("questionList", questionList);
		return "examing";
	}
	
	@RequestMapping(value = "/exam-submit", method = RequestMethod.POST)
	public @ResponseBody Message finishiExam(@RequestBody AnswerSheet answerSheet){
		Message message = new Message();
		ObjectMapper om= new ObjectMapper();
		return message;
	}
	
	@RequestMapping(value = "/finished-submit", method = RequestMethod.GET)
	public String finishedSubmitPage(Model model){
		return "finished";
	}
	
	@RequestMapping(value = "/practice-list", method = RequestMethod.GET)
	public String practiceListPage(Model model, HttpServletRequest request){
		int count = 0;
		//使用mao进行条件查询，这里传入一个空的map即为查处所有记录
		count = questionService.getCount(new HashMap<String, Object>());
		model.addAttribute("count", count);
		return "practice";
	}
	
	@RequestMapping(value = "/practice-improve", method = RequestMethod.GET)
	public String practiceImprove(Model model, HttpServletRequest request){
		//获取试题列表信息，包括试题的名称，内容，选项，正确答案，解析，分值等内容
		List<Question> questionList = questionService.findAllQuestion();
		model.addAttribute("questionList", questionList);
		return "practice-improve-qh";
	}

}
