package com.nopaldev.artesanos.core.respositories;

import com.nopaldev.artesanos.core.models.users.CraftsmanModel;
import org.springframework.data.repository.CrudRepository;

public interface CraftsmanRepository extends CrudRepository<CraftsmanModel, Long> {
}
