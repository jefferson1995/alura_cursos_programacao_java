package com.jefferson.aula_java_infra.service.impl;

import com.jefferson.aula_java_infra.dtos.UserNameDTO;
import com.jefferson.aula_java_infra.model.UserModel;
import com.jefferson.aula_java_infra.repository.UserRepository;
import com.jefferson.aula_java_infra.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override

    public Page<UserModel> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    @Cacheable(value = "users")
    public Optional<UserModel> findByUserId(UUID userId) {
        return userRepository.findByUserId(userId);
    }

}
