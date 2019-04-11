package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.model.User;
import pl.coderslab.repository.RoleRepo;
import pl.coderslab.repository.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        userRepo.save(user);
    }

//    public User findById(Long id) {
//        return userRepo.findOne(id);
//    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public List<User> findAllOrdinaryUsers() {
        return userRepo.findAllNormalUsers();
    }
}
