package br.com.caelum.clines.api.users;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static br.com.caelum.clines.shared.util.StringNormalizer.normalize;
import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    List<UserView> list() {
        return service.findAll();
    }

    @GetMapping("{id}")
    UserView show(@PathVariable String id) {
        return service.showUserBy(normalize(id));
    }

    @PostMapping
    ResponseEntity<?> createBy(@RequestBody @Valid UserForm form) {
        var id = service.createUserBy(form);

        var uri = URI.create("/user/").resolve(String.valueOf(id));

        return created(uri).build();
    }
}
