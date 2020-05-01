package com.nopaldev.artesanos.core.models.commerce;

import com.nopaldev.artesanos.core.models.BaseModel;

import javax.persistence.Entity;

@Entity
public class TaxModel extends BaseModel {
    private String code;
    private String name;
    private Double percentage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}
