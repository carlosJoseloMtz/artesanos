package com.nopaldev.artesanos.core.models.commerce;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "carts")
public class CartModel extends AbstractOrderModel {
    @OneToMany
    private List<CartEntryModel> entries;

    public List<CartEntryModel> getEntries() {
        return entries;
    }

    public void setEntries(List<CartEntryModel> entries) {
        this.entries = entries;
    }
}
