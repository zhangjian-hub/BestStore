package com.j1902.beststore.service;

import com.github.pagehelper.PageInfo;
import com.j1902.beststore.pojo.BsOrderForm;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-27 8:37
 */


public interface AdminBsOrderFormService {
    public PageInfo getAllOrderForms(int pageNum, int pageSize);

    public boolean addOrderForms(BsOrderForm orderForm);

    public void setOrderFormState(BsOrderForm orderForm);

    public void removeItem(Integer id);
}
