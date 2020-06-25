package mx.nopal.commerce.customers.services.impl;

import mx.nopal.commerce.customers.model.UserModel;
import mx.nopal.commerce.customers.repositories.UserRepository;
import mx.nopal.commerce.customers.services.UserService;

public class DefaultUserService<USER extends UserModel> implements UserService<USER> {
    private final UserRepository<USER> userRepository;

    public DefaultUserService(final UserRepository<USER> userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public USER getUserForUsername(final String username) {
        return getUserRepository().findByUsername(username);
    }

    public UserRepository<USER> getUserRepository() {
        return userRepository;
    }
}
