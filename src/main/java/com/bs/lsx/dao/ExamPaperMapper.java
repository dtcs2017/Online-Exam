package com.bs.lsx.dao;

import java.util.List;
import java.util.Map;

import com.bs.lsx.entity.ExamPaper;

public interface ExamPaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamPaper record);

    int insertSelective(ExamPaper record);

    ExamPaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamPaper record);

    int updateByPrimaryKey(ExamPaper record);

    /**查询试卷数量*/
    int getExamPaperCount(Map<String, Object> map);
    
    /**分页查询试卷*/
    List<ExamPaper> getExamPaperPage(Map<String, Object> map);
    
    /**获取试卷最后一条id*/
    int getExamPaperId();
    
    /**查询出试卷放入List集合 */
    List<ExamPaper> selectAllExamPaper();
}