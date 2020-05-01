package com.nopaldev.artesanos.core.models.commerce;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class OrderModel extends AbstractOrderModel {
    @OneToMany
    private List<OrderModel> entries;

    public List<OrderModel> getEntries() {
        return entries;
    }

    public void setEntries(List<OrderModel> entries) {
        this.entries = entries;
    }
}
