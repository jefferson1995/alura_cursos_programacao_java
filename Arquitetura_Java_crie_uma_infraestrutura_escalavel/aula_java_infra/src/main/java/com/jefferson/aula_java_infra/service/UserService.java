package com.jefferson.aula_java_infra.service;

import com.jefferson.aula_java_infra.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<UserModel> findAll(Pageable pageable);
}
