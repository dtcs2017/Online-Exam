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

import com.bs.lsx.dao.ExamMapper;
import com.bs.lsx.entity.Exam;
import com.bs.lsx.util.page.PageBean;
import com.bs.lsx.util.page.PageUtil;


@Service
public class ExamService {
	
	private static final Logger logger = LoggerFactory.getLogger(ExamService.class);
	@Autowired
	private ExamMapper examMapper;
	
	
	/**
	 * 
	 * @标题: 分页查询考试
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	public PageBean ExamPage(Integer pageNum, Integer pageSize, Exam exam){
		PageBean pageBean = new PageBean();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSizeBegin", (pageNum-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("vo", exam);
		try {
            Integer total = examMapper.getExamCount(map);
            List<Exam> list = null;
            if (total > 0) {
                list = examMapper.getExamPage(map);
            }
            @SuppressWarnings("deprecation")
            PageUtil puc = new PageUtil(list, pageNum, pageSize, total);
            pageBean = PageUtil.getPageBean(puc);
        } catch (Exception e) {
            logger.error("分页查询考试信息错误", e);
        }
        return pageBean;
	}
	
	/**
	 * 
	 * @标题: 查询出考试列表
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	public List<Exam> getExamList(Exam exam){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vo", exam);
		return examMapper.getExamList(map);
	}
	
	/**
	 * 
	 * @标题: 根据考试id查找考试
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	public Exam getExamById(int id){
		Exam exam = null;
		try{
			exam = examMapper.selectByPrimaryKey(id);
		} catch(Exception e){
			logger.error("查找单个考试错误", e);
		}
		return exam;
	}
	
	/**
	 * 
	 * @标题: 添加考试
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	@Transactional
	public void addExam(Exam exam){
		try{
			exam.setCreateTime(new Date());
			examMapper.insertSelective(exam);
		} catch(Exception e){
			logger.error("添加考试错误", e);
		}
	}
	
	/**
	 * 
	 * @标题: 根据考试id删除单个考试
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	@Transactional
	public void deleteExam(int id){
		try{
			examMapper.deleteByPrimaryKey(id);
		} catch(Exception e){
			logger.error("删除单个考试错误", e);
		}
	}
	
	/**
	 * 
	 * @标题: 修改单个考试
	 * @创建人: lsx
	 * @创建时间: 2016年4月20日
	 * @return
	 */
	@Transactional
	public void updateExam(Exam exam){
		try{
			examMapper.updateByPrimaryKeySelective(exam);
		} catch(Exception e){
			logger.error("修改单个考试错误", e);
		}
	}


}
