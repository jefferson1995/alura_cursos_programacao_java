package com.jefferson.aula_java_infra.service.impl;

import com.jefferson.aula_java_infra.model.UserModel;
import com.jefferson.aula_java_infra.repository.UserRepository;
import com.jefferson.aula_java_infra.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
