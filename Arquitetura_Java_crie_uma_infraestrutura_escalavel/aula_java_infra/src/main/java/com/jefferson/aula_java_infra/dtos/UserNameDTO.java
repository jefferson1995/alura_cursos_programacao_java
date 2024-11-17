package com.jefferson.aula_java_infra.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jefferson.aula_java_infra.model.UserModel;
import lombok.Data;

import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserNameDTO {

    private UUID userId;
    private String username;
    private String email;

    public UserNameDTO(String username) {
        this.username = username;
    }
}
