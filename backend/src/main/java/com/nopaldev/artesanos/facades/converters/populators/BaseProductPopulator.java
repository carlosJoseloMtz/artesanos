package com.nopaldev.artesanos.facades.converters.populators;

import com.nopaldev.artesanos.core.models.commerce.ProductModel;
import com.nopaldev.artesanos.facades.dtos.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class BaseProductPopulator implements Populator<ProductModel, ProductDTO> {

    @Override
    public void populate(final ProductModel model, final ProductDTO dto) {
        dto.setCode(model.getCode());
        dto.setName(model.getName());
        dto.setDescription(model.getDescription());
        // TODO: set the craftsman info
    }
}
