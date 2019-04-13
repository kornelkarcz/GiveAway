package pl.coderslab.config.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomDaoAuthenticationProvider extends DaoAuthenticationProvider {

    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        super.additionalAuthenticationChecks(userDetails, authentication);
        CurrentUser currentUser = (CurrentUser) userDetails;
        if (!currentUser.getUser().isEnabled()) {
            throw new UserDisabledException("User is disables");
        }
    }

    public static class UserDisabledException extends AuthenticationException {
        public UserDisabledException(String message) {
            super(message);
        }
    }
}
