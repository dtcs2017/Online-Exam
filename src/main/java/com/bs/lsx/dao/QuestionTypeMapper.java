package com.bs.lsx.dao;

import java.util.List;

import com.bs.lsx.entity.QuestionType;

public interface QuestionTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionType record);

    int insertSelective(QuestionType record);

    QuestionType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionType record);

    int updateByPrimaryKey(QuestionType record);
    
    /**查询出试题类型放入List集合 */
    List<QuestionType> selectAllQuestionType();
}