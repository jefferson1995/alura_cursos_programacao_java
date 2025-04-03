package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {

    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("40584426899", "teste", LocalDate.parse("1995-01-02"), "email@email.com");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("", "teste", LocalDate.parse("1995-01-02"), "email@email.com");
        });
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario(){
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento("teste","405.844.268-99", LocalDate.parse("1995-01-02"));
        Assertions.assertEquals("teste", usuario.getNome());

        usuario = fabrica.incluiEndereco("06604210", 40, "casa");

        Assertions.assertEquals("06604210", usuario.getEndereco().getCep());
    }

    @Test
    public void naoDeveCadastrarUsuarioComMenosDe18anos() {

        // Crio uma data de nascimento que subtrai 17 anos da data atual
        LocalDate dataNascimento = LocalDate.now().minusYears(17);  // Um usuário com 17 anos

        // Crio uma exceção e atribuo a ela o resultado do teste de idade mínima, pois o correto é que a exceção seja lançada.
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("123.456.789-00", "Fulano", dataNascimento, "fulano@example.com");
        });

        // Confiro se a mensagem da exceção é a mensagem que eu esperava, referente à idade inferior
        Assertions.assertEquals("Usuário deve ter pelo menos 18 anos de idade!", exception.getMessage());
    }


}
