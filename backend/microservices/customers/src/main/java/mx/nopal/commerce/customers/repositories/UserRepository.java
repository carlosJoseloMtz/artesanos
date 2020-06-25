package mx.nopal.commerce.customers.repositories;

import mx.nopal.commerce.customers.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserRepository<USER extends UserModel> extends CrudRepository<USER, Long> {

    USER findByUsername(final String username);
}
