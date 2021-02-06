package com.zain.jo.linkedin.network_app.security.service;

import com.zain.jo.linkedin.network_app.domain.User;
import com.zain.jo.linkedin.network_app.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username == null || "".equals(username)){
            throw new UsernameNotFoundException("empty or invalud user");
        }

        Optional<User> user = userRepository.findByUsername(username);

        if(user.isPresent()){
            log.info("cretaed under User service : " + user.get());
            return user.get();
        }

        throw new UsernameNotFoundException("empty or invalud user");
    }
}
