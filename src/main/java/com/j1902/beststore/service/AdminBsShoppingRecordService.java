package com.j1902.beststore.service;

import com.github.pagehelper.PageInfo;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-26 19:00
 */
public interface AdminBsShoppingRecordService {

    public int getCountOfAll();

    public PageInfo getAll(int pageNum, int pageSize);
}
