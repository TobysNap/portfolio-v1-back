package com.devTN.portfolio.repository;

import com.devTN.portfolio.model.Usuario;
import com.devTN.portfolio.model.UsuarioCred;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioCredRepository extends JpaRepository<UsuarioCred, Long> {
        Optional<UsuarioCred> findOneByEmail(String email);

        boolean existsByEmail(String email);
}
