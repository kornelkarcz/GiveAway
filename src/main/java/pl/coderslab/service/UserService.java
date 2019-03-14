package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepo;

import java.util.List;

@Component
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void registerUser(User user) {
        userRepo.save(user);
    }

    public User findById(Long id) {
        return userRepo.findOne(id);
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public List<User> findAllOrdinaryUsers() {
        return userRepo.findAllNormalUsers();
    }
}
