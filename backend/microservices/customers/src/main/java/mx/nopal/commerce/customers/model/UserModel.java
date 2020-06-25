package mx.nopal.commerce.customers.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UserModel extends BaseModel {

    @NotNull
    @Column(name = "username", unique = true)
    private String username;
    @NotNull
    private String password;
    @Column(columnDefinition = "tinyint(1) default 1")
    private boolean enabled = true;
    @NotNull
    private String passwordAlgorithm;

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPasswordAlgorithm() {
        return passwordAlgorithm;
    }

    public void setPasswordAlgorithm(String passwordAlgorithm) {
        this.passwordAlgorithm = passwordAlgorithm;
    }
}
