package com.nopaldev.artesanos.core.models.commerce;

import com.nopaldev.artesanos.core.models.BaseModel;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class WarehouseModel extends BaseModel {
    private String code;
    @OneToOne
    private AddressModel addressModel;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AddressModel getAddressModel() {
        return addressModel;
    }

    public void setAddressModel(AddressModel addressModel) {
        this.addressModel = addressModel;
    }
}
