package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.UserDto;
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

    public User registerUser(UserDto userDto) {

        final User user = new User();

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setAdmin(false);
        user.setEnabled(false);
        user.getRoleSet().add(roleRepo.getOne(1L));

        return userRepo.save(user);
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
