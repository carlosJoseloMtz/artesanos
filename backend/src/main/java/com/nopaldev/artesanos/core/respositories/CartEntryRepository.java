package com.nopaldev.artesanos.core.respositories;

import com.nopaldev.artesanos.core.models.commerce.CartEntryModel;
import org.springframework.data.repository.CrudRepository;

public interface CartEntryRepository extends CrudRepository<CartEntryModel, Long> {
}
