package com.jefferson.aula_java_infra.repository;

import com.jefferson.aula_java_infra.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByUserId(UUID userId);
}
