package com.nopaldev.artesanos.core.models.users;

import javax.persistence.Entity;

@Entity
public class CraftsmanModel extends UserModel {
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
