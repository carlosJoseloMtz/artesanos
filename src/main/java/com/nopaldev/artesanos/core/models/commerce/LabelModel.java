package com.nopaldev.artesanos.core.models.commerce;

import com.nopaldev.artesanos.core.models.BaseModel;

import javax.persistence.Entity;

@Entity
public class LabelModel extends BaseModel {
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
