package com.bs.lsx.dao;

import com.bs.lsx.entity.MenuItem;

public interface MenuItemMapper {
    int insert(MenuItem record);

    int insertSelective(MenuItem record);
}