package br.com.caelum.clines.api.users;

import br.com.caelum.clines.shared.domain.User;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    Collection<User> findAll();

    Optional<User> findByEmail(@NotBlank String email);

    User save(User user);

    Optional<User> findById(@Param("id") Long id);
}
