package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.model.User;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = "select * from users where isAdmin = false", nativeQuery = true)
    List<User> findAllNormalUsers();
}
