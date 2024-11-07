package br.com.caelum.clines.api.users;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
@Getter
@AllArgsConstructor
public class UserView {

    private String name;
    private String email;
}
