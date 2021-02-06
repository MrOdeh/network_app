package com.zain.jo.linkedin.network_app.config;

import com.zain.jo.linkedin.network_app.config.filter.DataAttacher;
import com.zain.jo.linkedin.network_app.security.service.EditorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@RequiredArgsConstructor
public class EditorWebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final EditorService editorService;
    @Lazy
    private final PasswordEncoder passwordEncoder;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http // all other requests handled here
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.editorService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public FilterRegistrationBean<DataAttacher> perfFilter() {
        FilterRegistrationBean<DataAttacher> registration = new FilterRegistrationBean<>();
        registration.setFilter(new DataAttacher());
        registration.addUrlPatterns("/*");
        return registration;
    }
}