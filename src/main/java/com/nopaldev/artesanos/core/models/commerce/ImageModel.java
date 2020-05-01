package com.nopaldev.artesanos.core.models.commerce;

import com.nopaldev.artesanos.core.models.BaseModel;

import javax.persistence.Entity;

@Entity
public class ImageModel extends BaseModel {
    private String resource;
    private String baseUrl;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
