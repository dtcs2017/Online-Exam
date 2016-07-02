package com.bs.lsx.action.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.lsx.entity.ExamPaper;
import com.bs.lsx.entity.Question;
import com.bs.lsx.entity.QuestionType;
import com.bs.lsx.service.ExamPaperService;
import com.bs.lsx.service.QuestionService;
import com.bs.lsx.service.QuestionTypeService;
import com.bs.lsx.util.JsonUtils;
import com.bs.lsx.util.page.PageBean;
import com.bs.lsx.util.verifySubmit.VerifySubmit;

@Controller
@RequestMapping("/admin/exampaper")
public class ExamPaperController {
	private static final Logger logger = LoggerFactory.getLogger(ExamPaperController.class);
	@Autowired
	private ExamPaperService examPaperService;
	
	@Autowired 
	private QuestionService questionService;
	
	@Autowired
	private QuestionTypeService questionTypeService;
	
	private Model getExamPaperModel(HttpServletRequest request,Integer pageSize, Integer pageNum, Model model, ExamPaper examPaper){
		examPaper = examPaper==null? new ExamPaper() : examPaper;
		pageNum = pageNum == null ? 1 : pageNum;
	    pageSize = pageSize == null ? 10 : pageSize;
	        
		PageBean pageBean  = examPaperService.ExamPaperPage(pageNum, pageSize, examPaper);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("examPaper",examPaper);
	    return model;
	}
	
	private Model getQuestionModel(HttpServletRequest request,Integer pageSize, Integer pageNum, Model model,Question question){
		question = question==null? new Question() : question;
		pageNum = pageNum == null ? 1 : pageNum;
	    pageSize = pageSize == null ? 10 : pageSize;
	        
		PageBean pageBean  = questionService.QuestionPage(pageNum, pageSize, question);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("question",question);
	    return model;
	}
	
	@RequestMapping("index")
	public void index( HttpServletRequest request,Integer pageSize, Integer pageNum, Model model,ExamPaper examPaper){
		getExamPaperModel(request, pageSize, pageNum, model, examPaper);
	}
	
	@RequestMapping("list")
	public void list( HttpServletRequest request,Integer pageSize, Integer pageNum, Model model,ExamPaper examPaper){
		getExamPaperModel(request, pageSize, pageNum, model, examPaper);
	}
	
	@RequestMapping("questionlist")
	public
	@ResponseBody
	PageBean questionlist(HttpServletRequest request,Integer pageSize, Integer pageNum, Model model,Question question){
		question = question==null? new Question() : question;
		pageNum = pageNum == null ? 1 : pageNum;
	    pageSize = pageSize == null ? 10 : pageSize;
	        
		PageBean pageBean  = questionService.QuestionPage(pageNum, pageSize, question);
		
		return pageBean;
	}
	
	@RequestMapping("update")
	public void add(HttpServletRequest request, Model model, Integer pageSize, Integer pageNum, Question question, ExamPaper examPaper){
		VerifySubmit.setToken(request);
		List<QuestionType> questionTypeList = questionTypeService.findAllQuestionType();
		model.addAttribute("questionTypeList", questionTypeList);
		if(examPaper.getId() != null){
			model.addAttribute("id", examPaper.getId());
		} else{
			model.addAttribute("id", examPaperService.getExamPaperId());
		}
		
		getQuestionModel(request, pageSize, pageNum, model, question);
	}
	
	@RequestMapping("doUpdate")
	public
	@ResponseBody
	Map<String, Object> doUpdate(HttpServletRequest request, ExamPaper examPaper, String token){
		//boolean sessionFlag = VerifySubmit.compareToken(request, token);
		boolean sessionFlag = true;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 300);
		map.put("success", false);
		map.put("message", "保存失败");
		if(sessionFlag){
			try{
				//获取选择的试题id字符串保存到id数组
				String ids[] = examPaper.getContent().split(",");
				//声明试题数组
				Question questions[] = new Question[ids.length];
				int i = 0;
				//遍历试题id数组
				for(String id : ids){
					int questionid = Integer.parseInt(id);
					//根据试题id找出试题实体放入试题数组
					questions[i] = questionService.getQuestionById(questionid);
					i++;
				}
				//将试题数组转换成json字符串
				String content = JsonUtils.array2json(questions);
				//保存试题
				examPaper.setContent(content);
				examPaperService.updateExamPaper(examPaper);
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
	
	
	@RequestMapping("doAdd")
	public
	@ResponseBody
	Map<String, Object> doAdd( HttpServletRequest request, ExamPaper examPaper, String token){
		boolean sessionFlag = true;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("statusCode", 300);
		map.put("success", false);
		map.put("message", "保存失败");
		
		if(sessionFlag){
			try{
				examPaper.setCreateTime(new Date());
				examPaperService.addExamPaper(examPaper);
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
	
	@RequestMapping("doDelete")
	public 
	@ResponseBody
	Map<String, Object> doDelete(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("statusCode", 300);
		map.put("success", false);
		map.put("message", "删除失败");
		
		try{
			examPaperService.delExamPaper(id);
			map.put("statusCode", 200);
			map.put("success", true);
			map.put("message", "删除成功");
		} catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	

}
