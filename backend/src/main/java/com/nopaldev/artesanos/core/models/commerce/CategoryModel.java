package com.nopaldev.artesanos.core.models.commerce;

import com.nopaldev.artesanos.core.models.BaseModel;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity(name = "categories")
public class CategoryModel extends BaseModel {
    private String code;
    private String name;

    @ManyToMany
    private List<CategoryModel> superCategories;
    @ManyToMany
    private List<CategoryModel> subCategories;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryModel> getSuperCategories() {
        return superCategories;
    }

    public void setSuperCategories(List<CategoryModel> superCategories) {
        this.superCategories = superCategories;
    }

    public List<CategoryModel> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<CategoryModel> subCategories) {
        this.subCategories = subCategories;
    }
}
