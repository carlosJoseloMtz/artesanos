package mx.nopal.commerce.customers.controllers.forms;

import javax.validation.constraints.NotBlank;

public class CompanyRegistrationForm extends CustomerRegistrationForm {

    @NotBlank(message = "Company name is required")
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
