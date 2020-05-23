package com.nopaldev.artesanos.core.models.users;

import com.nopaldev.artesanos.core.models.BaseModel;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.util.Date;

@MappedSuperclass
public class UserModel extends BaseModel {

    private boolean enabled;

    private String validationToken;

    private Date lastTimeGeneratedToken;

    @NotNull
    @Column(name = "username", unique = true)
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    public Date getLastTimeGeneratedToken() {
        return lastTimeGeneratedToken;
    }

    public void setLastTimeGeneratedToken(Date lastTimeGeneratedToken) {
        this.lastTimeGeneratedToken = lastTimeGeneratedToken;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getValidationToken() {
        return validationToken;
    }

    public void setValidationToken(String validationToken) {
        this.validationToken = validationToken;
    }

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
