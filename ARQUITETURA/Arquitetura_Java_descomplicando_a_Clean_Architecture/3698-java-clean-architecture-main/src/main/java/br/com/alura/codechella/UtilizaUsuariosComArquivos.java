package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.io.IOException;
import java.time.LocalDate;

public class UtilizaUsuariosComArquivos {

    public static void main(String[] args) {

        RepositorioDeUsuarioEmArquivo repositorio = new RepositorioDeUsuarioEmArquivo();

        repositorio.cadastrar(new Usuario("429.882.448-98", "teste", LocalDate.parse("2000-10-15"), "teste@gmail.com"));
        repositorio.cadastrar(new Usuario("429.882.448-98", "teste2", LocalDate.parse("2000-10-15"), "teste@gmail.com"));
        repositorio.cadastrar(new Usuario("429.882.448-98", "teste3", LocalDate.parse("2000-10-15"), "teste@gmail.com"));
        repositorio.cadastrar(new Usuario("429.882.448-98", "teste4", LocalDate.parse("2000-10-15"), "teste@gmail.com"));

       // System.out.printf(String.valueOf(repositorio.listarTodos()));

        try {
            repositorio.gravaEmArquivo("usuarios.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
