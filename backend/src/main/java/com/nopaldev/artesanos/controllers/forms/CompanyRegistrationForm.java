package com.nopaldev.artesanos.controllers.forms;

import javax.validation.constraints.NotBlank;

public class CompanyRegistrationForm extends CustomerRegistrationForm {

    @NotBlank(message = "Company name is required")
    private String companyName;
    // TODO: should we ask for RFC? probably not :v

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
