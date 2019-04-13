package pl.coderslab.service;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Role;
import pl.coderslab.model.User;
import pl.coderslab.repository.RoleRepo;
import pl.coderslab.repository.UserRepo;

import java.util.Arrays;
import java.util.HashSet;

@Service
@Data
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Role userRole = roleRepo.findByName("ROLE_USER");
        user.setRoleSet(new HashSet<Role>(Arrays.asList(userRole)));
        userRepo.save(user);
    }

    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Role userRole = roleRepo.findByName("ROLE_ADMIN");
        user.setRoleSet(new HashSet<Role>(Arrays.asList(userRole)));
        userRepo.save(user);
    }
}
