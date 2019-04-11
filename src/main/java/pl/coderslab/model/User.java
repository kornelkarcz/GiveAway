package pl.coderslab.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@ToString
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 3, max = 30, message = "Invalid first name size")
    private String firstName;

    @Size(min = 2, max = 50, message = "Invalid last name size")
    private String lastName;

    private String email;

    private String password;
    private boolean isAdmin;
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Role> roleSet = new HashSet<>();

}
