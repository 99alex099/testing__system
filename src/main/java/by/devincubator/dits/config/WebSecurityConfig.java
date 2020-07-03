package by.devincubator.dits.config;

import by.devincubator.dits.services.general.implementations.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler customSuccessHandler() {
        return new CustomSuccessHandler();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);

        http.authorizeRequests()
                .antMatchers("/registration").not().fullyAuthenticated()
                .antMatchers("/statisticsOptions", "/testStatistics", "/questionStatistics",
                        "/usersStatistics", "/creationOptions", "/createTest", "/createUser", "/approveUser")
                .access("hasRole('ADMIN')")


                //users
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

                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("login")
                .passwordParameter("password")
                .successHandler(customSuccessHandler())

                .and()
                .logout()
                .logoutSuccessUrl("/login")

                .and()
                .addFilterBefore(filter, CsrfFilter.class);


//        .loginProcessingUrl("/login").usernameParameter("ssoId").passwordParameter("password").and()
//                .csrf().disable().exceptionHandling().accessDeniedPage("/not_access");

    }

}
