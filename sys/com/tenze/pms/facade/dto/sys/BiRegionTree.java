package com.tenze.pms.facade.dto.sys;

import java.util.List;

public class BiRegionTree {
    private String p;
    private List<BiRegionTree> c;

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public List<BiRegionTree> getC() {
        return c;
    }

    public void setC(List<BiRegionTree> c) {
        this.c = c;
    }
}


