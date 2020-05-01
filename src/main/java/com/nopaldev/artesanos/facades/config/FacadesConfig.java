package com.nopaldev.artesanos.facades.config;

import com.nopaldev.artesanos.core.models.commerce.ProductModel;
import com.nopaldev.artesanos.facades.converters.AbstractConverter;
import com.nopaldev.artesanos.facades.converters.Converter;
import com.nopaldev.artesanos.facades.converters.populators.BaseProductPopulator;
import com.nopaldev.artesanos.facades.dtos.ProductDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class FacadesConfig {

    @Bean(name = "baseProductConverter")
    public Converter<ProductModel, ProductDTO> baseProductConverter(final BaseProductPopulator baseProductPopulator) {
        return new AbstractConverter<>(ProductDTO.class, Arrays.asList(baseProductPopulator));
    }
}
