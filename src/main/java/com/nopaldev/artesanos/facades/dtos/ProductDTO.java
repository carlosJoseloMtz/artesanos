package com.nopaldev.artesanos.facades.dtos;

import java.util.List;

public class ProductDTO {
    private String code;
    private String name;
    private String description;
    private PriceDTO price;
    private List<ImageDTO> imageGallery;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public PriceDTO getPrice() {
        return price;
    }

    public void setPrice(PriceDTO price) {
        this.price = price;
    }

    public List<ImageDTO> getImageGallery() {
        return imageGallery;
    }

    public void setImageGallery(List<ImageDTO> imageGallery) {
        this.imageGallery = imageGallery;
    }
}
