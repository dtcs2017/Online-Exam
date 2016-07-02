package com.bs.lsx.action.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;








import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.lsx.entity.Question;
import com.bs.lsx.entity.QuestionType;
import com.bs.lsx.service.QuestionService;
import com.bs.lsx.service.QuestionTypeService;
import com.bs.lsx.util.page.PageBean;
import com.bs.lsx.util.verifySubmit.VerifySubmit;


@Controller
@RequestMapping("/admin/question")
public class QuestionController {
	@Autowired
	private QuestionTypeService questionTypeService;
	@Autowired
	private QuestionService questionService;
	
	private Model getQuestionModel(HttpServletRequest request,Integer pageSize, Integer pageNum, Model model,Question question){
		question = question==null? new Question() : question;
		pageNum = pageNum == null ? 1 : pageNum;
	    pageSize = pageSize == null ? 10 : pageSize;
	        
		//model.addAttribute("tabid", 401);
		PageBean pageBean  = questionService.QuestionPage(pageNum, pageSize, question);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("question",question);
	    return model;
	}
	
	@RequestMapping("index")
	public void index( HttpServletRequest request,Integer pageSize, Integer pageNum, Model model,Question question){
		List<QuestionType> questionTypeList = questionTypeService.findAllQuestionType();
		model.addAttribute("questionTypeList", questionTypeList);
		getQuestionModel(request, pageSize, pageNum, model, question);
	}
	
	@RequestMapping("list")
	public void list( HttpServletRequest request,Integer pageSize, Integer pageNum, Model model,Question question){
		getQuestionModel(request, pageSize, pageNum, model, question);
	}
	
	@RequestMapping("add")
	public void add(HttpServletRequest request, Model model){
		List<QuestionType> questionTypeList = questionTypeService.findAllQuestionType();
		model.addAttribute("questionTypeList", questionTypeList);
		VerifySubmit.setToken(request);
	}
	
	@RequestMapping("doAdd")
	public
	@ResponseBody
	Map<String, Object> doAdd(HttpServletRequest request, Question question, String token){
		//boolean sessionFlag = VerifySubmit.compareToken(request, token);
		boolean sessionFlag = true;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 300);
		map.put("success", false);
		map.put("message", "保存失败");
		
		if(sessionFlag){
			try{
				//设置创建时间
				question.setCreateTime(new Date());
				//添加试题
				questionService.addQuestion(question);
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
		int questionId = Integer.parseInt(request.getParameter("id"));
		List<QuestionType> questionTypeList = questionTypeService.findAllQuestionType();
		model.addAttribute("questionTypeList", questionTypeList);
		Question question = questionService.getQuestionById(questionId);
		model.addAttribute("question", question);
		VerifySubmit.setToken(request);
	}
	
	@RequestMapping("doUpdate")
	public
	@ResponseBody
	Map<String, Object> doUpdate(HttpServletRequest request, Question question, String token){
		//boolean sessionFlag = VerifySubmit.compareToken(request, token);
		boolean sessionFlag = true;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 300);
		map.put("success", false);
		map.put("message", "保存失败");
		
		if(sessionFlag){
			try{
				questionService.updateQuestion(question);
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
			questionService.deleteQuestion(id);
			map.put("statusCode", 200);
			map.put("success", true);
			map.put("message", "删除成功");
		} catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
}
