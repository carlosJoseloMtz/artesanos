package com.nopaldev.artesanos.core.models.commerce;

import com.nopaldev.artesanos.core.models.BaseModel;
import com.nopaldev.artesanos.core.models.users.CraftsmanModel;

import javax.persistence.*;
import java.util.List;

@Entity(name = "products")
public class ProductModel extends BaseModel {
    @Column(unique = true)
    private String code;
    private String name;

    private String description;

    @ManyToOne
    private CraftsmanModel craftsman;

    @ManyToMany
    private List<CategoryModel> categories;

    @OneToMany
    private List<StockModel> stocks;

    @ManyToMany
    private List<LabelModel> labels;

    @OneToMany
    private List<ImageModel> images;

    public List<StockModel> getStocks() {
        return stocks;
    }

    public void setStocks(List<StockModel> stocks) {
        this.stocks = stocks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ImageModel> getImages() {
        return images;
    }

    public void setImages(List<ImageModel> images) {
        this.images = images;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<CategoryModel> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryModel> categories) {
        this.categories = categories;
    }

    public List<LabelModel> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelModel> labels) {
        this.labels = labels;
    }

    public CraftsmanModel getCraftsman() {
        return craftsman;
    }

    public void setCraftsman(CraftsmanModel craftsman) {
        this.craftsman = craftsman;
    }
}
