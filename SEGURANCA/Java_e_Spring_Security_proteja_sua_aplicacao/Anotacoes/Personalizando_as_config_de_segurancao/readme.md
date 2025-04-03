# Preparando o ambiente: códigos e links da documentação

link: https://drive.google.com/file/d/17dnJsoJlL7VwrOn5kSOecWJ33gBpIueE/view?usp=drive_link

## login code

```bash

<!DOCTYPE html>
<html lang="pt-br"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate="~{template.html}">
<head>
    <title>Login</title>
</head>

<body>
<div layout:fragment="conteudo">
    <main class="container">
        <section class="card form-card">
            <h2 class="title">Login</h2>

            <form method="post" action="#" th:action="@{/login}">
                <div class="alert alert-danger text-center text-uppercase" th:if="${param.error != null}">
                    <p>
                        <strong>Dados inválidos!</strong>
                    </p>
                </div>

                <div class="alert alert-danger text-center text-uppercase" th:if="${param.logout != null}">
                    <p>
                        <strong>Você saiu da aplicação!</strong>
                    </p>
                </div>

                <div class="form-group">
                    <label for="username" class="required">Email:</label>
                    <input id="username" name="username" type="email" class="form-control" required="required">
                </div>

                <div class="form-group">
                    <label for="password" class="required">Senha:</label>
                    <input id="password" name="password" type="password" class="form-control" required="required">
                </div>

                <button class="btn btn-primary" title="Entrar">
                    Entrar
                </button>
            </form>
        </section>
    </main>
</div>
</body>
</html>

```

## Documentação e código da autorização de requisições HTTP

``` bash

.authorizeHttpRequests(req -> {
                    req.requestMatchers("/css/**", "/js/**", "/assets/**").permitAll();
                    req.anyRequest().authenticated();
                })

```

## Documentação e código do logout

``` bash

<form class="navbar-form" th:action="@{/logout}" method="post">
                <button class="btn-link">SAIR</button>
            </form>

```

# Criando uma página de login
Saber mais: https://drive.google.com/file/d/1g0gnQDZedtIVZXRaLq-SxNoJVoxWA0vg/view?usp=drive_link

# Utilizando os filtros do Spring Security
Saber mais: https://drive.google.com/file/d/1MZYN9zXy0Cv8dffu4JccxMmUHveXBiSQ/view?usp=drive_link

# Configurando o logout
Saber mais: https://drive.google.com/file/d/1aSSMLNZWFWdt7ZZ-FWc1VIkYW9WoYRhy/view?usp=drive_link

# Para saber mais: conhecendo os filtros da SecurityFilterChain

link: https://drive.google.com/file/d/1AVX2jiVco0lT8HMI6NSQjtbXU4SO090o/view?usp=drive_link

# Nessa aula, você aprendeu:

- A importância de criar páginas de login e logout personalizadas para manter a consistência visual do aplicativo. Isso está muito relacionado à experiência do usuário: é interessante uma consistência no visual das páginas e no idioma utilizado por elas.

- Como alterar as configurações padrão de filtro do Spring Security. Fizemos isso criando um bean do tipo SecurityFilterChain, o que permite que tenhamos nossa própria cadeia de filtros.

- Configurações relacionadas às requisições HTTP. Ao utilizarmos nosso próprio filtro, precisamos adicionar a configuração das requisições, inserindo arquivos front-end, para evitar que o aplicativo quebre.

- Como o Spring Security lida com logout. Vimos que o LogoutFilter requer uma rota POST para /logout para fazer todas as limpezas necessárias.

# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-spring-security-proteja-aplicacoes-web

![Nome imagem](link) ![Nome imagem 2](link)

