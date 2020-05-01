package com.nopaldev.artesanos.core.models.users;

import com.nopaldev.artesanos.core.models.BaseModel;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UserModel extends BaseModel {

    private String username;

    private String password;

    private String name;

    private String lastName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
