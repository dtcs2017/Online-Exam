package com.bs.lsx.dao;

import java.util.List;
import java.util.Map;

import com.bs.lsx.entity.Exam;

public interface ExamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);
    
    /** 查询出考试列表 */
    List<Exam> getExamList(Map<String, Object> map);
    
    /**查询出考试数量*/
    int getExamCount(Map<String, Object> map);
    
    /**分页查询考试*/
    List<Exam> getExamPage(Map<String, Object> map);
}