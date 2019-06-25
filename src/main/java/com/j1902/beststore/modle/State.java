package com.j1902.beststore.modle;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-25 11:52
 */
public class State {
    private boolean state = false;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "State{" +
                "state=" + state +
                '}';
    }
}
