package com.nopaldev.artesanos.core.models.commerce;

import com.nopaldev.artesanos.core.models.BaseModel;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "stocks")
public class StockModel extends BaseModel {
    private long quantity;
    @OneToOne
    private WarehouseModel warehouse;

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public WarehouseModel getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseModel warehouse) {
        this.warehouse = warehouse;
    }
}
