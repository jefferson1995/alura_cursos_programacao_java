package com.jefferson.aula_java_infra.controllers;

import com.jefferson.aula_java_infra.dtos.UserDTO;
import com.jefferson.aula_java_infra.dtos.UserNameDTO;
import com.jefferson.aula_java_infra.model.UserModel;
import com.jefferson.aula_java_infra.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> getAllUsers(@PageableDefault(page = 0, size = 10, sort = "userId", direction = Sort.Direction.ASC)
                                                         Pageable pageable) {
        Page<UserModel> userModelPage = userService.findAll(pageable);
        if (userModelPage.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Page<UserDTO> userDTOPage = userModelPage.map(UserDTO::new);
        return ResponseEntity.status(HttpStatus.OK).body(userDTOPage);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserNameDTO> getUser(@PathVariable(value = "userId") UUID userId) {
        Optional<UserModel> userModelOptional = userService.findByUserId(userId);
        if (userModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        UserModel userModel = userModelOptional.get();
        UserNameDTO userNameDTO = new UserNameDTO(userModel.getUsername());
        return ResponseEntity.status(HttpStatus.OK).body(userNameDTO);
    }

}
