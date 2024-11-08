package br.com.caelum.clines.api.users;

import br.com.caelum.clines.shared.domain.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserViewMapperTest {

    private final String NAME = "jefferson";
    private final String EMAIL = "jefferson.bds@hotmail.com";
    private final String PASSWORD = "123456";

    private UserViewMapper mapper;

    @Test
    public void shouldConvertUserToUserView(){
        var user = new User(NAME, EMAIL, PASSWORD);
        mapper = new UserViewMapper();

        var userView = mapper.map(user);
        assertEquals(NAME, userView.getName());
        assertEquals(EMAIL, userView.getEmail());
    }
}
