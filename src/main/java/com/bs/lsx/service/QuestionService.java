package com.bs.lsx.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bs.lsx.dao.QuestionMapper;
import com.bs.lsx.dao.QuestionTypeMapper;
import com.bs.lsx.entity.Question;
import com.bs.lsx.util.page.PageBean;
import com.bs.lsx.util.page.PageUtil;


@Service
public class QuestionService {
	private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);
	@Autowired
	private QuestionTypeMapper questionTypeMapper;
	
	@Autowired
	private QuestionMapper questionMapper;
	
	/**
	 * 
	 * @标题: 分页查询试题
	 * @创建人: lsx
	 * @创建时间: 2016年3月17日
	 * @return
	 */
	public PageBean QuestionPage(Integer pageNum, Integer pageSize, Question question){
		PageBean pageBean = new PageBean();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSizeBegin", (pageNum-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("vo", question);
		try {
            Integer total = questionMapper.getQuestionCount(map);
            List<Question> list = null;
            if (total > 0) {
                list = questionMapper.getQuestionPage(map);
            }
            @SuppressWarnings("deprecation")
            PageUtil puc = new PageUtil(list, pageNum, pageSize, total);
            pageBean = PageUtil.getPageBean(puc);
        } catch (Exception e) {
            logger.error("分页查询试题信息错误", e);
        }
        return pageBean;
	}
	
	/**
	 * 
	 * @标题: 根据试题id查找试题
	 * @创建人: lsx
	 * @创建时间: 2016年3月23日
	 * @return
	 */
	public Question getQuestionById(int id){
		Question question = null;
		try{
			question = questionMapper.selectByPrimaryKey(id);
		} catch(Exception e){
			logger.error("查找单个试题错误", e);
		}
		return question;
	}
	
	/**
	 * 
	 * @标题: 添加试题
	 * @创建人: lsx
	 * @创建时间: 2016年3月22日
	 * @return
	 */
	@Transactional
	public void addQuestion(Question question){
		try{
			question.setCreateTime(new Date());
			questionMapper.insertSelective(question);
		} catch(Exception e){
			logger.error("添加试题错误", e);
		}
	}
	
	/**
	 * 
	 * @标题: 根据试题id删除单个试题
	 * @创建人: lsx
	 * @创建时间: 2016年3月23日
	 * @return
	 */
	@Transactional
	public void deleteQuestion(int id){
		try{
			questionMapper.deleteByPrimaryKey(id);
		} catch(Exception e){
			logger.error("删除单个试题错误", e);
		}
	}
	
	/**
	 * 
	 * @标题: 修改单个试题
	 * @创建人: lsx
	 * @创建时间: 2016年3月23日
	 * @return
	 */
	@Transactional
	public void updateQuestion(Question question){
		try{
			questionMapper.updateByPrimaryKeySelective(question);
		} catch(Exception e){
			logger.error("修改单个试题错误", e);
		}
	}
	
	/**
	 * 
	 * @标题: 查询试题数量
	 * @创建人: lsx
	 * @创建时间: 2016年3月23日
	 * @return
	 */
	public int getCount(Map<String, Object> map){
		return questionMapper.getQuestionCount(map);
	}
	
	/**
	 * 
	 * @标题: 查询出所有试题
	 * @创建人: lsx
	 * @创建时间: 2016年3月23日
	 * @return
	 */
	public List<Question> findAllQuestion(){
		return questionMapper.findAllQuestion();
	}

}
