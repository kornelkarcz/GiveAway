package pl.coderslab.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class MyUserDetails extends User implements UserDetails {

    public MyUserDetails(User user) {
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setEmail(user.getPassword());
        this.setPassword(user.getPassword());
        this.setEnabled(user.isEnabled());
        this.setAdmin(user.isAdmin());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoleSet().stream()
                .map(el -> new SimpleGrantedAuthority(el.getName()))
                .collect(Collectors.toList());
    }

    //Ustawiamy, że dla SS naszym username jest email
    @Override
    public String getUsername() {
        return super.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
