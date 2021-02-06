package com.zain.jo.linkedin.network_app.security.repository;

import com.zain.jo.linkedin.network_app.domain.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Long> {
    Optional<Editor> findByUsername(String username);
}
