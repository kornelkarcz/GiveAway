package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepo;

import java.util.List;

@@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

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
