package com.kd.serwisAukcyjny.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    private final PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public WebSecurityConfig(DataSource dataSource, PasswordEncoder bCryptPasswordEncoder){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.dataSource = dataSource;
    }
    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/products/**").hasAnyAuthority("ROLE_USER")
                .antMatchers("/h2/**/").permitAll()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable().and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("name")
                .passwordParameter("password")
                .loginProcessingUrl("/login-process")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/").and()
                .logout().logoutSuccessUrl("/login");
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin@admin.pl")
                .password(bCryptPasswordEncoder.encode("admin12345"))
                .roles("ADMIN");
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.name, u.password,1 FROM user u WHERE u.name=?")
                .authoritiesByUsernameQuery("SELECT u.name, r.role_name, 1 " +
                        "FROM user u " +
                        "INNER JOIN user_role ur ON ur.user_id = u.id " +
                        "INNER JOIN role r ON r.id = ur.roles_id " +
                        "WHERE u.name=?")
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }
}
