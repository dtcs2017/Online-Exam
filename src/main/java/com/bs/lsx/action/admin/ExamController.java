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

import com.bs.lsx.entity.Exam;
import com.bs.lsx.entity.ExamPaper;
import com.bs.lsx.entity.Group;
import com.bs.lsx.entity.QuestionType;
import com.bs.lsx.service.ExamPaperService;
import com.bs.lsx.service.ExamService;
import com.bs.lsx.service.GroupService;
import com.bs.lsx.util.page.PageBean;
import com.bs.lsx.util.verifySubmit.VerifySubmit;

@Controller
@RequestMapping("/admin/exam")
public class ExamController {
	@Autowired
	private ExamService examService;
	@Autowired
	private ExamPaperService examPaperService;
	@Autowired
	private GroupService groupService;

	private Model getExamModel(HttpServletRequest request,Integer pageSize, Integer pageNum, Model model,Exam exam){
		exam = exam==null? new Exam() : exam;
		pageNum = pageNum == null ? 1 : pageNum;
	    pageSize = pageSize == null ? 10 : pageSize;
	        
		PageBean pageBean  = examService.ExamPage(pageNum, pageSize, exam);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("exam",exam);
	    return model;
	}
	
	@RequestMapping("index")
	public void index( HttpServletRequest request,Integer pageSize, Integer pageNum, Model model,Exam exam){
		List<ExamPaper> examPaperList = examPaperService.findAllExamPaper();
		model.addAttribute("examPaperList", examPaperList);
		List<Group> groupList = groupService.findAllGroup();
		model.addAttribute("groupList", groupList);
		getExamModel(request, pageSize, pageNum, model, exam);
	}
	
	@RequestMapping("list")
	public void list( HttpServletRequest request,Integer pageSize, Integer pageNum, Model model,Exam exam){
		getExamModel(request, pageSize, pageNum, model, exam);
	}
	
	@RequestMapping("add")
	public void add(HttpServletRequest request, Model model){
		VerifySubmit.setToken(request);
	}
	
	@RequestMapping("doAdd")
	public
	@ResponseBody
	Map<String, Object> doAdd(HttpServletRequest request, Exam exam, String token){
		//boolean sessionFlag = VerifySubmit.compareToken(request, token);
		boolean sessionFlag = true;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 300);
		map.put("success", false);
		map.put("message", "保存失败");
		
		if(sessionFlag){
			try{
				//设置考试的创建时间
				exam.setCreateTime(new Date());
				//完成考试的发布创建
				examService.addExam(exam);
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
		int examId = Integer.parseInt(request.getParameter("id"));
		Exam exam = examService.getExamById(examId);
		List<ExamPaper> examPaperList = examPaperService.findAllExamPaper();
		model.addAttribute("examPaperList", examPaperList);
		List<Group> groupList = groupService.findAllGroup();
		model.addAttribute("groupList", groupList);
		model.addAttribute("exam", exam);
		VerifySubmit.setToken(request);
	}
	
	@RequestMapping("doUpdate")
	public
	@ResponseBody
	Map<String, Object> doUpdate(HttpServletRequest request, Exam exam, String token){
		//boolean sessionFlag = VerifySubmit.compareToken(request, token);
		boolean sessionFlag = true;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 300);
		map.put("success", false);
		map.put("message", "保存失败");
		
		if(sessionFlag){
			try{
				examService.updateExam(exam);
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
			examService.deleteExam(id);
			map.put("statusCode", 200);
			map.put("success", true);
			map.put("message", "删除成功");
		} catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}

}
