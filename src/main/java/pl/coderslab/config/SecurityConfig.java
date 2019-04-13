package pl.coderslab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import pl.coderslab.service.MyUserDetailService;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;
    private final MyUserDetailService userDetailService;

    public SecurityConfig(MyUserDetailService userDetailService,
                          DataSource dataSource) {
        this.userDetailService = userDetailService;
        this.dataSource = dataSource;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/", "/login", "/perform_login", "/logout", "/perform_logout", "/register")
                .permitAll();

        http.authorizeRequests()
                .antMatchers("/user_info").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

        http.authorizeRequests()
                .antMatchers("/admin").access("hasRole('ROLE_ADMIN')");

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        http.authorizeRequests().and()
                .formLogin()
                .loginProcessingUrl("/perform_login")
                .loginPage("/login")
//                .defaultSuccessUrl("/user_info")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                //TODO dałem tu email i nadal nie dziala
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logout_success");


        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;

    }
}
