package com.nopaldev.artesanos.core.models.commerce;

import com.nopaldev.artesanos.core.models.BaseModel;
import com.nopaldev.artesanos.core.models.users.CustomerModel;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public class AbstractOrderModel extends BaseModel {
    private String code;
    private Double subtotal;
    private Double total;
    private Double totalTaxes;
    @ManyToMany
    private List<TaxModel> appliedTaxes;
    @ManyToOne
    private CustomerModel customer;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotalTaxes() {
        return totalTaxes;
    }

    public void setTotalTaxes(Double totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public List<TaxModel> getAppliedTaxes() {
        return appliedTaxes;
    }

    public void setAppliedTaxes(List<TaxModel> appliedTaxes) {
        this.appliedTaxes = appliedTaxes;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }
}
