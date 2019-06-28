package com.j1902.beststore.modle;

import com.j1902.beststore.pojo.BsOrderForm;

import java.util.List;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-28 16:27
 */
public class UpdateOrderFormInfo {
    private List<Integer> ids;
    private List<BsOrderForm> bsOrderForms;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<BsOrderForm> getBsOrderForms() {
        return bsOrderForms;
    }

    public void setBsOrderForms(List<BsOrderForm> bsOrderForms) {
        this.bsOrderForms = bsOrderForms;
    }

    @Override
    public String toString() {
        return "UpdateOrderFormInfo{" +
                "ids=" + ids +
                ", bsOrderForms=" + bsOrderForms +
                '}';
    }
}
