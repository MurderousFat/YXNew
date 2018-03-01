package com.tenze.pms.facade.dto.sys;

import java.util.List;

public class HisEntity {



    private String id;
    private String parentNode;
    private String name;
    private List<HisEntity> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentNode() {
        return parentNode;
    }

    public void setParentNode(String parentNode) {
        this.parentNode = parentNode;
    }

    public List<HisEntity> getItems() {
        return items;
    }

    public void setItems(List<HisEntity> items) {
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
