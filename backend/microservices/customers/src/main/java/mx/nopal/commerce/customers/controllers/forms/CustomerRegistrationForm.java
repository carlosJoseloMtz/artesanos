package mx.nopal.commerce.customers.controllers.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class CustomerRegistrationForm {
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Minimum password length is 8 characters")
    private String password;
    @NotBlank(message = "You have to validate your password")
    @Size(min = 8, message = "Minimum password length is 8 characters")
    private String repeatedPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }
}
