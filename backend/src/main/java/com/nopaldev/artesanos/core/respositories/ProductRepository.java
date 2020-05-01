package com.nopaldev.artesanos.core.respositories;

import com.nopaldev.artesanos.core.models.commerce.ProductModel;
import com.nopaldev.artesanos.core.models.users.CraftsmanModel;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface ProductRepository extends CrudRepository<ProductModel, Long> {

    ProductModel findProductModelByCode(@NotNull final String code);

    List<ProductModel> findProductModelsByCraftsman(@NotNull final CraftsmanModel craftsman);
}
