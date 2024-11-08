package br.com.caelum.clines.api.users;

import br.com.caelum.clines.shared.domain.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserFormMapperTest {

    private final String NAME = "jefferson";
    private final String EMAIL = "jefferson.bds@hotmail.com";
    private final String PASSWORD = "123456";

    private UserFormMapper mapper;

    @Test
    public void shouldConvertUserToUserView(){
        var userForm = new UserForm(NAME, EMAIL, PASSWORD);
        mapper = new UserFormMapper();

        var user = mapper.map(userForm);
        assertEquals(NAME, user.getName());
        assertEquals(EMAIL, user.getEmail());

    }
}
