package com.nopaldev.artesanos.core.services.dtos;

public class CompanyRegistrationDTO extends UserRegistrationDTO {
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
