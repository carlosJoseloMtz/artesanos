package com.nopaldev.artesanos.core.respositories;

import com.nopaldev.artesanos.core.models.users.CustomerModel;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerModel, Long> {
}
