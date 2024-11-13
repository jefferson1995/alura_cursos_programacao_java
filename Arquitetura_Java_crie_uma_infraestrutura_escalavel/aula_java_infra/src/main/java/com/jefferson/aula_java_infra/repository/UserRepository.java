package com.jefferson.aula_java_infra.repository;

import com.jefferson.aula_java_infra.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}
