package com.bs.lsx.dao;

import com.bs.lsx.entity.PracticePaper;
import com.bs.lsx.entity.PracticePaperWithBLOBs;

public interface PracticePaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PracticePaperWithBLOBs record);

    int insertSelective(PracticePaperWithBLOBs record);

    PracticePaperWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PracticePaperWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PracticePaperWithBLOBs record);

    int updateByPrimaryKey(PracticePaper record);
}