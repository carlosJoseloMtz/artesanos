package com.nopaldev.artesanos.facades.dtos;

import javax.validation.constraints.NotBlank;

public class SellerRegisterDTO extends RegisterDTO {
    @NotBlank
    private String companyName;
    // TODO: should we ask for RFC? probably not :v

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
