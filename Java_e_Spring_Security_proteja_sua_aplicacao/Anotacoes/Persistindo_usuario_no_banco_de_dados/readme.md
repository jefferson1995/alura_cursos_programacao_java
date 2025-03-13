# Preparando o ambiente: dependência, dialeto e código utilizados em vídeo

Para facilitar nosso desenvolvimento e ritmo, inserimos alguns códigos prontos na nossa aplicação ao longo dos vídeos desta aula. Assim, disponibilizamos abaixo todos os códigos utilizados nos próximos vídeos para que você possa acompanhar junto com a instrutora.

Quando quiser copiar o código, volte a esta atividade para consultá-los! :)

Dependência do Thymeleaf Extras e dialeto para uso no arquivo HTML
Para adicionar o pacote thymeleaf-extras-springsecurity6 ao projeto, você pode inserir a seguinte dependência do Thymeleaf Extras utilizada no vídeo “Ajustando permissões de visualização”:

```bash

<dependency>
    <groupId>org.thymeleaf.extras</groupId>
    <artifactId>thymeleaf-extras-springsecurity6</artifactId>
</dependency>

```

Agora, para inserir o dialeto a ser importado no arquivo HTML utilizado neste vídeo, copie o seguinte código:

```bash

xmlns:sec="http://www.thymeleaf.org/extras/spring-security"

```

Código do “Olá, usuário”
Para exibir o nome do usuário após o login, ação implementada no vídeo “Visualizando o nome do usuário”, utilize o código a seguir:

```bash

<ul class="nav-right">
                <li class="dropdown">
                    <a href="#">OLÁ, USUÁRIO <i class="arrow-down"></i></a>
                    <ul class="dropdown-menu">
                        <li>
                            <form class="navbar-form" th:action="@{/logout}" method="post">
                                <button class="btn-link">SAIR</button>
                            </form>
                        </li>
                    </ul>
                </li>
      </ul>

```

# Ajustando permissões de visualização

Nesta aula, aprendemos a integrar o Thymeleaf com o Spring Security para ajustar as permissões de visualização na nossa aplicação web. O foco foi ocultar o menu de navegação para usuários não autenticados, evitando que eles fossem redirecionados para a página de login ao tentarem acessar áreas restritas.

Para isso, adicionamos a dependência thymeleaf-extras-springsecurity6 no arquivo pom.xml, que permite a utilização de funcionalidades do Spring Security no Thymeleaf. Em seguida, no arquivo template.html, utilizamos a tag sec:authorize="isAuthenticated" para exibir o menu apenas para usuários autenticados. Também foi necessário importar o namespace correto do Thymeleaf.

Após compilar e reiniciar a aplicação, verificamos que o menu só aparece quando o usuário está logado, melhorando a experiência do usuário e a segurança da aplicação.

Por fim, a aula nos preparou para adicionar novas funcionalidades no front-end.


# Visualizando o nome do usuário

Nesta aula, aprendemos a integrar o Thymeleaf ao Spring Security para exibir uma saudação personalizada ao usuário logado em nossa aplicação web. Começamos ajustando o menu de usuário no arquivo _menu.html, onde adicionamos a opção "Olá, usuário" e um botão para sair.

Para personalizar a saudação, substituímos "usuário" por uma tag span que utiliza o dialeto do Thymeleaf com Spring Security, especificamente a expressão sec:authentication="principal.nome", que busca o nome do usuário autenticado.

No entanto, encontramos um erro ao tentar acessar principal.nome, pois a classe Usuario não possuía um método getNome. Para resolver isso, implementamos o método getNome na classe Usuario, permitindo que o Spring Security reconhecesse essa propriedade.

Após as correções, ao logar na aplicação, a saudação foi exibida corretamente, mostrando o nome do usuário. A aula também destacou a possibilidade de adicionar mais funcionalidades, como exibir uma foto de perfil e explorar a criação de perfis e autorização no futuro.


saber mais: https://drive.google.com/file/d/1Y4Atksmi2Ttfz8fE7dC1ks9e6t2oroFk/view?usp=drive_link


alterando layout do menu: https://drive.google.com/file/d/1SVJfP-7A7PuNHHaT5guOdvD9ohovsC8U/view?usp=drive_link


Referências: https://drive.google.com/file/d/1GNRah1GqbauzTmhN_nEWr_04WSeHfhXQ/view?usp=drive_link





### Nessa aula, você aprendeu:

- Integrar Thymeleaf e Spring Security. Isso foi feito adicionando a dependência thymeleaf-extras-springsecurity6 no pom.xml e usando o dialeto de segurança do Thymeleaf em arquivos HTML.

- Usar a tag sec:authorize="isAuthenticated()" para controlar a visualização de elementos no template HTML.

- Personalizar a exibição do nome do usuário autenticado no menu com Thymeleaf e Spring Security. Essa personalização é feita com a tag sec:authentication=”principal.nome”.

- Criar métodos de acesso no UserDetails para a correta integração com Spring Security. Entendemos que o principal da tag se refere ao usuário logado com o Spring Security, que é definido por um UserDetails. Logo, para utilizar as propriedades do principal, temos que ter essa propriedade no usuário, e ela deve ser acessível (por exemplo, devemos ter um getNome()).


```bash

```

# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-spring-security-proteja-aplicacoes-web

![Nome imagem](link) ![Nome imagem 2](link)

