package mx.nopal.commerce.customers.services;

import mx.nopal.commerce.customers.model.UserModel;

public interface UserService<USER extends UserModel> {
    USER getUserForUsername(final String username);
}
