package com.jefferson.aula_java_infra.service;

import com.jefferson.aula_java_infra.dtos.UserNameDTO;
import com.jefferson.aula_java_infra.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Page<UserModel> findAll(Pageable pageable);

    Optional<UserModel> findByUserId(UUID userId);
}
