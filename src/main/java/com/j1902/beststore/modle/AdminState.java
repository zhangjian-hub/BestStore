package com.j1902.beststore.modle;

import com.j1902.beststore.pojo.BsItem;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-23 11:05
 */
public class AdminState {
    private BsItem item;
    private boolean state = false;

    public BsItem getItem() {
        return item;
    }

    public void setItem(BsItem item) {
        this.item = item;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "AdminState{" +
                "item=" + item +
                ", state=" + state +
                '}';
    }
}
