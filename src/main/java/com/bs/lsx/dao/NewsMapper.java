package com.bs.lsx.dao;

import com.bs.lsx.entity.News;

public interface NewsMapper {
    int insert(News record);

    int insertSelective(News record);
}