package com.bs.lsx.dao;

import java.util.List;
import java.util.Map;

import com.bs.lsx.entity.Question;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
    
    /**查询出试题数量*/
    int getQuestionCount(Map<String, Object> map);
    
    /**分页查询试题*/
    List<Question> getQuestionPage(Map<String, Object> map);
    
    /**查询出所有试题*/
    List<Question> findAllQuestion();
    
    /**仅查询出试题详情*/
    //String selectQuestionDetailById(Long id);
}