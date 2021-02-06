package com.zain.jo.linkedin.network_app.security.service;

import com.zain.jo.linkedin.network_app.domain.Editor;
import com.zain.jo.linkedin.network_app.security.repository.EditorRepository;
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
public class EditorService implements UserDetailsService {

    private final EditorRepository editorRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username == null || "".equals(username)){
            throw new UsernameNotFoundException("empty or invalud user");
        }

        Optional<Editor> editor = editorRepository.findByUsername(username);

        if(editor.isPresent()){
            log.info("created under editor service: " + editor.get());
            return editor.get();
        }

        throw new UsernameNotFoundException("empty or invalud user");
    }

}
