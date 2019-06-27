package com.j1902.beststore.service;

import com.github.pagehelper.PageInfo;
import com.j1902.beststore.pojo.BsOrderForm;
import org.springframework.stereotype.Service;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-27 8:37
 */

@Service
public interface AdminBsOrderFormService {
    public PageInfo getAllOrderForms(int pageNum, int pageSize);

    public boolean addOrderForms(BsOrderForm orderForm);
}
