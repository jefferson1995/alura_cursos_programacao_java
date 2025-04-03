
# Preparando o ambiente: códigos da consulta JPQL e do front-end

Código para a consulta JPQL para filtrar as consultas de usuários

```bash

@Query("SELECT c FROM Consulta c " +
            "WHERE (c.medico.id = :id OR c.paciente.id = :id)" +
            " ORDER BY c.data")

```
Código do formulário de alteração de senha


```bash

<!DOCTYPE html>
<html lang="pt"
      xmlns:th="https://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate="~{template.html}">
<head>
    <title>Voll.med - Alterar senha</title>
</head>

<body>
<div layout:fragment="conteudo">
    <main class="container">
        <section class="card form-card">
            <h2 class="title">Alterar senha</h2>

            <form th:action="@{/alterar-senha}" method="post" th:object="${dados}">

                <div class="alert alert-danger text-center text-uppercase" th:if="${param.error != null}">
                    <p>
                        <strong>Dados inválidos!</strong>
                    </p>
                </div>

                <div class="form-group">
                    <label for="senhaAtual" class="required">Senha atual:</label>
                    <input id="senhaAtual" name="senhaAtual" type="password" class="form-control" placeholder="Senha atual" required="required">
                </div>

                <div class="form-group">
                    <label for="novaSenha" class="required">Nova senha:</label>
                    <input id="novaSenha" name="novaSenha" type="password" class="form-control" placeholder="Nova senha" required="required">
                </div>

                <div class="form-group">
                    <label for="novaSenhaConfirmacao" class="required">Confirme a nova senha:</label>
                    <input id="novaSenhaConfirmacao" name="novaSenhaConfirmacao" type="password" class="form-control" placeholder="Confirme a nova senha" required="required">
                </div>

                <button class="btn btn-primary" title="Entrar">
                    Salvar
                </button>
            </form>
        </section>
    </main>
</div>
</body>
</html>

```


Código para criar um link de alteração de senha


```bash

<div class="navbar-form">
                                <a class="btn-link" href="#" th:href="@{/alterar-senha}">Alterar senha</a>
                            </div>

```

A div deve ser adicionada ao arquivo menu.html, que ficará modificado da seguinte forma:


```bash

<header class="header" xmlns:th="http://thymeleaf.org" th:fragment="menu"
        xmlns:sec="http://www.thymeleaf.org/extras/spring-security" >
    <div class="container header-container">
        <a href="../index.html" th:href="@{/}" class="logo">
            <img src="../../static/assets/logo.png" th:src="@{/assets/logo.png}" alt="Logo Voll">
        </a>

        <nav class="main-nav">
            <ul sec:authorize="isAuthenticated()" class="nav-left">
                <li class="dropdown">
                    <a href="#">CADASTROS <i class="arrow-down"></i></a>
                    <ul class="dropdown-menu">
                        <li sec:authorize="!hasRole('MEDICO')">
                            <a href="../medico/listagem-medicos.html" th:href="@{/medicos}">Médicos</a>
                        </li>

                        <li sec:authorize="hasRole('ATENDENTE')">
                            <a href="../paciente/listagem-pacientes.html" th:href="@{/pacientes}">Pacientes</a>
                        </li>

                        <li>
                            <a href="../consulta/listagem-consultas.html" th:href="@{/consultas}">Consultas</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <ul sec:authorize="isAuthenticated()" class="nav-right">
                <li class="dropdown">
                    <a href="#">Olá, <span sec:authentication="principal.nome"></span> <i class="arrow-down"></i></a>
                    <ul class="dropdown-menu">
                        <li>
                            <div class="navbar-form">
                                <a class="btn-link" href="#" th:href="@{/alterar-senha}">Alterar senha</a>
                            </div>
                            <form class="navbar-form" th:action="@{/logout}" method="post">
                                <button class="btn-link">SAIR</button>
                            </form>
                        </li>
                    </ul>
                </li>
            </ul>
            <div class="navbar-form" sec:authorize="!isAuthenticated()">
                <a class="btn-link" href="#" th:href="@{/login}">Login</a>
            </div>
        </nav>
    </div>
</header>

```


# Modificando a visualização de consultas

restringir a visualização de consultas em uma aplicação, garantindo que médicos e pacientes vejam apenas suas próprias consultas. Para isso, utilizamos o @AuthenticationPrincipal para identificar o usuário logado e adaptamos o método listar() na classe ConsultaService.

Se o usuário logado for um atendente, todas as consultas são retornadas. Caso contrário, criamos um método específico no repositório, chamado buscaPersonalizadaConsultas(), que utiliza JPQL para buscar apenas as consultas relacionadas ao ID do usuário logado, seja médico ou paciente.

Além disso, ajustamos o ConsultaController para passar o usuário logado como parâmetro e garantir que a paginação funcione corretamente. Após as configurações, testamos a aplicação e confirmamos que as consultas exibidas são personalizadas de acordo com o usuário autenticado.

Com isso, conseguimos implementar uma visualização de consultas totalmente personalizada, respeitando as permissões de cada perfil de usuário.



# Trabalhando com perfis no front-end

restringir visualizações e a alterar senhas no front-end utilizando o Thymeleaf e o módulo sec para trabalhar com perfis de usuários. O foco foi em melhorar a usabilidade da aplicação, evitando que usuários com perfis inadequados acessem determinadas rotas e funcionalidades.

Primeiro, analisamos o menu de cadastros, onde ajustamos a exibição da opção de médicos para que aparecesse apenas para atendentes ou pacientes, enquanto médicos não poderiam acessá-la. Utilizamos a tag sec:authorize para implementar essa lógica, aplicando !hasRole('MEDICO') para ocultar a opção de médicos.

Em seguida, configuramos as permissões nos arquivos listagem-medicos.html e listagem-consultas.html, garantindo que apenas atendentes pudessem visualizar e interagir com botões de adicionar e atualizar médicos, enquanto médicos teriam acesso restrito apenas a suas próprias consultas.

Por fim, testamos a aplicação para verificar se as configurações estavam corretas, garantindo uma visualização personalizada e uma melhor experiência do usuário. A aula enfatizou a importância de ajustar o front-end para refletir as permissões de cada perfil de usuário.

# Alterando a senha no banco de dados

aprendemos a implementar a funcionalidade de alteração de senha em nossa aplicação, focando na segurança do processo. Começamos verificando que, ao fazer login com as credenciais de usuários, como a médica Joana e a paciente Bruna, não havia proteção suficiente para evitar que informações sensíveis, como CPF e CRM, fossem expostas.

Para resolver isso, criamos um formulário de alteração de senha no front-end, que inclui campos para a senha atual, nova senha e confirmação da nova senha. A validação é crucial, pois precisamos garantir que o usuário logado está realmente tentando alterar sua senha.

Em seguida, desenvolvemos um DTO chamado DadosAlteracaoSenha, que contém os campos necessários e utilizamos a anotação @NotBlank para garantir que nenhum campo fique vazio.

Na classe UsuarioService, implementamos o método alterarSenha(), que verifica se a senha atual informada corresponde à senha do usuário logado e se a nova senha é igual à confirmação. Utilizamos o encriptador para comparar as senhas de forma segura. Se as validações falharem, lançamos exceções apropriadas.

Por fim, adicionamos um método na classe Usuario para alterar a senha e salvamos as alterações no repositório. A próxima etapa será criar as rotas no Controller para mapear a funcionalidade de alteração de senha.


# Criando uma rota para alterar a senha

aprendemos a criar uma rota para alterar a senha de usuários em uma aplicação utilizando Java e Spring Security. Começamos mapeando o método de alteração de senhas na classe UsuarioService e, em seguida, implementamos um @GetMapping e um @PostMapping no LoginController.

Primeiro, duplicamos o @GetMapping para exibir a página de alteração de senha, renomeando métodos para torná-los mais representativos. A rota para essa página foi definida como alterar-senha, e ao carregá-la, retornamos a página do formulário de alteração de senha.

Depois, criamos o @PostMapping para lidar com a alteração de senha, utilizando o método alterarSenha() e garantindo a validação dos dados com a anotação @NotBlank. Implementamos o tratamento de erros com BindingResult e Model, redirecionando o usuário conforme a situação.

Adicionamos também um link para a página de alteração de senha no menu da aplicação. Ao testar a aplicação, verificamos que a funcionalidade de alteração de senha estava funcionando corretamente, permitindo que o usuário alterasse sua senha e realizasse o login com a nova senha.

Por fim, discutimos a importância da segurança das senhas, mencionando estratégias para melhorar a segurança, como a geração de senhas aleatórias e a obrigatoriedade de alteração de senha no primeiro acesso.


# Para saber mais: obrigando o usuário a redefinir a senha: https://drive.google.com/file/d/1JuOBpVYkm6_1tNqVkx8SXpGVPcd8dJrc/view?usp=drive_link

#  Mão na massa: gerando uma senha aleatória: https://drive.google.com/file/d/19LnP2NQCZz94dha7gaIHUrFDQyZqBK9f/view?usp=drive_link






### Nessa aula, você aprendeu:

- Criar visualizações personalizadas para cada usuário logado. Vimos que, para uma exibição das consultas específicas de médico ou paciente, precisávamos fazer uma consulta no banco, com base nos dados do usuário da sessão. Para pegar esses dados, utilizamos @AuthenticationPrincipal.

- Configurar permissões de visualização no HTML utilizando Thymeleaf. Usamos o módulo sec do Thymeleaf para ter um front-end que combinasse com o backend: se a pessoa não pode acessar determinado conteúdo do site, ela não irá visualizar botões ou links que direcionam para esse conteúdo.

- Desenvolver um formulário de alteração de senha e sua lógica de verificação. Entendemos que o formulário deve ter 3 campos: a senha atual, a nova senha e uma confirmação da nova senha. Utilizamos o método matches do PasswordEncoder para verificar se a senha digitada correspondia à senha do banco de dados, além de verificar se a nova senha e sua confirmação eram correspondentes.

- Utilizar várias estratégias para forçar o usuário a alterar a senha. Vimos que, apenas criando uma rota para alterar a senha, pode ser que o usuário escolha não modificá-la. Assim, os dados dele ainda estarão vulneráveis. Conhecemos algumas estratégias para obrigar esse usuário a alterar a senha, melhorando a segurança da aplicação.


```bash


```

# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-spring-security-crie-perfis-autorize-requisicoes
![Nome imagem](link) ![Nome imagem 2](link)

