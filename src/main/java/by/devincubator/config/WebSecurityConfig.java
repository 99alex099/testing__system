package by.devincubator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Qualifier("userServiceImpl")
    @Autowired
    private UserDetailsService userService;
    private CustomSuccessHandler customSuccessHandler;

    @Autowired
    public void setCustomSuccessHandler(CustomSuccessHandler customSuccessHandler) {
        this.customSuccessHandler = customSuccessHandler;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
///////////////////////////////////////////

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()

                .antMatchers("/choose_topic").access("hasRole('USER')")
                .antMatchers("/select_topic").access("hasRole('USER')")

                .antMatchers("/choose_test").access("hasRole('USER')")
                .antMatchers("/select_test").access("hasRole('USER')")

                .antMatchers("/testing").access("hasRole('USER')")
                .antMatchers("/start_test").access("hasRole('USER')")


                .antMatchers("/goTest")
                .access("hasRole('USER')")

                .antMatchers("/profile/**")
                .access("hasRole('USER')")

                .antMatchers("/my_statistic")
                .access("hasRole('USER')")

                .and().formLogin().loginPage("/login")
                .loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password").and()
                .csrf().disable().exceptionHandling().accessDeniedPage("/not_access");

    }

}
