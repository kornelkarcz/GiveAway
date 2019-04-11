package pl.coderslab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//TODO Dodać PasswordMatchera
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String matchingPassword;
    private Boolean enabled;
    private Boolean isAdmin;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
