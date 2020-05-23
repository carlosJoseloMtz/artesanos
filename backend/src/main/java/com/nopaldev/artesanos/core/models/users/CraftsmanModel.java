package com.nopaldev.artesanos.core.models.users;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity(name = "companies")
public class CraftsmanModel extends UserModel {

    @NotNull
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
