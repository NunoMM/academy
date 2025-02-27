package com.ctw.workstation;

import java.util.UUID;

public abstract class CommonData {

    private String id;
    private String name;

    public CommonData(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
