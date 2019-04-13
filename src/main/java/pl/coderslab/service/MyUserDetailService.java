package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.model.MyUserDetails;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepo;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(email);
        }
        return new MyUserDetails(user);
    }

}
