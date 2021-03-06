package com.zain.jo.linkedin.network_app.security.repository;

import com.zain.jo.linkedin.network_app.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
