package mx.nopal.commerce.customers.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;

@Entity(name = "companies")
public class CompanyModel extends UserModel {
    @NotNull
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
