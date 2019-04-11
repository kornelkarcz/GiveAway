package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
