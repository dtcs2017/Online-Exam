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

import com.bs.lsx.dao.ExamPaperMapper;
import com.bs.lsx.entity.ExamPaper;
import com.bs.lsx.util.page.PageBean;
import com.bs.lsx.util.page.PageUtil;

@Service
public class ExamPaperService {
	private static final Logger logger = LoggerFactory.getLogger(ExamPaperService.class);
	@Autowired
	private ExamPaperMapper examPaperMapper;
	
	
	/**
	 * 
	 * @标题: 分页查询试卷
	 * @创建人: lsx
	 * @创建时间: 2016年4月19日
	 * @return
	 */
	public PageBean ExamPaperPage(Integer pageNum, Integer pageSize, ExamPaper examPaper){
		PageBean pageBean = new PageBean();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSizeBegin", (pageNum-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("vo", examPaper);
		try {
            Integer total = examPaperMapper.getExamPaperCount(map);
            List<ExamPaper> list = null;
            if (total > 0) {
                list = examPaperMapper.getExamPaperPage(map);
            }
            @SuppressWarnings("deprecation")
            PageUtil puc = new PageUtil(list, pageNum, pageSize, total);
            pageBean = PageUtil.getPageBean(puc);
        } catch (Exception e) {
            logger.error("分页查询试卷信息错误", e);
        }
        return pageBean;
	}
	
	/**
	 * 
	 * @标题: 根据试卷id查找试卷
	 * @创建人: lsx
	 * @创建时间: 2016年4月19日
	 * @return
	 */
	public ExamPaper getExamPaperById(int id){
		ExamPaper examPaper = null;
		try{
			examPaper = examPaperMapper.selectByPrimaryKey(id);
		} catch(Exception e){
			logger.error("查找单个试卷错误", e);
		}
		return examPaper;
	}
	
	/**
	 * 
	 * @标题: 添加试卷
	 * @创建人: lsx
	 * @创建时间: 2016年4月19日
	 * @return
	 */
	@Transactional
	public void addExamPaper(ExamPaper examPaper){
		try{
			examPaper.setCreateTime(new Date());
			examPaperMapper.insertSelective(examPaper);
		} catch(Exception e){
			logger.error("添加试卷错误", e);
		}
	}
	
	/**
	 * 
	 * @标题: 修改单个试卷
	 * @创建人: lsx
	 * @创建时间: 2016年4月19日
	 * @return
	 */
	@Transactional
	public void updateExamPaper(ExamPaper examPaper){
		try{
			examPaperMapper.updateByPrimaryKeySelective(examPaper);
		} catch(Exception e){
			logger.error("修改单个试卷错误", e);
		}
	}
	
	/**
	 * 
	 * @标题: 获取试卷最后一条id
	 * @创建人: lsx
	 * @创建时间: 2016年4月22日
	 * @return
	 */
	public int getExamPaperId(){
		return examPaperMapper.getExamPaperId();
	}
	
	/**
	 * 
	 * @标题: 根据id删除试卷
	 * @创建人: lsx
	 * @创建时间: 2016年4月22日
	 * @return
	 */
	public int delExamPaper(int id){
		return examPaperMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 
	 * @标题: 查询出所有试卷
	 * @创建人: lsx
	 * @创建时间: 2016年4月22日
	 * @return
	 */
	public List<ExamPaper> findAllExamPaper(){
		List<ExamPaper> examPaperList = null;
		try{
			examPaperList = examPaperMapper.selectAllExamPaper();
		} catch(Exception e){
			logger.error("查询试卷错误", e);
		}
		return examPaperList;
	}

}
