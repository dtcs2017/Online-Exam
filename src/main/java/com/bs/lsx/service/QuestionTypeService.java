package com.bs.lsx.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.lsx.dao.QuestionTypeMapper;
import com.bs.lsx.entity.QuestionType;

@Service
public class QuestionTypeService {
	private static final Logger logger = LoggerFactory.getLogger(QuestionTypeService.class);
	@Autowired
	private QuestionTypeMapper questionTypeMapper;
	
	public List<QuestionType> findAllQuestionType(){
		List<QuestionType> questionTypeList = null;
		try{
			questionTypeList = questionTypeMapper.selectAllQuestionType();
		} catch(Exception e){
			logger.error("查询试题类型错误", e);
		}
		return questionTypeList;
	}

}
