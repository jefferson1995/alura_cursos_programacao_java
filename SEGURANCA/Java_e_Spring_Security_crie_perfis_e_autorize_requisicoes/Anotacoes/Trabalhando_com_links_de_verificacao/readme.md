# Preparando o ambiente: códigos para finalizar ''Esqueci minha senha''

Código para o mapeamento da rota “/recuperar-conta”



```bash

@GetMapping("/recuperar-conta")
    public String carregarPaginaAlterarSenhaEsquecida(@RequestParam(name = "codigo", required = false) String codigo, Model model) {
        if(codigo != null)
            model.addAttribute("codigo", codigo);
        return FORMULARIO_RECUPERACAO_CONTA;
    }

    @PostMapping("/recuperar-conta")
    public String carregarPaginaAlterarSenhaEsquecida(@RequestParam(name = "codigo") String codigo, Model model, DadosRecuperacaoConta dados) {
        try {
            service.recuperarConta(codigo, dados);
            return "redirect:login";
        } catch (RegraDeNegocioException e){
            model.addAttribute("error", e.getMessage());
            return FORMULARIO_RECUPERACAO_CONTA;
        }
    }


```

formulario-recuperacao-conta.html


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

            <form th:action="@{/recuperar-conta}" method="post" th:object="${dados}">
                <input type="hidden" name="codigo" th:value="${param.codigo}">

                <div class="alert alert-danger text-center text-uppercase" th:if="${param.error != null}">
                    <p>
                        <strong>Dados inválidos!</strong>
                    </p>
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

Código para criar um link para o “Esqueci minha senha”


```bash

 <div>
                    <a th:href="@{/esqueci-minha-senha}">Esqueci minha senha</a>
                </div>

```

A div deve ser adicionada ao arquivo login.html, que ficará modificado da seguinte forma:

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

<!--                <div class="form-group">-->
<!--                    <label for="remember-me" class="required">Lembrar de mim:</label>-->
<!--                    <input id="remember-me" name="remember-me" type="checkbox" class="form-control">-->
<!--                </div>-->

                <div>
                    <a th:href="@{/esqueci-minha-senha}">Esqueci minha senha</a>
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

# Obtendo o token da requisição


trabalhar com links de verificação para a recuperação de conta, focando na criação de rotas para o processo de alteração de senha. O objetivo é permitir que o usuário receba um e-mail com um link que contém um código específico para acessar um formulário onde poderá inserir uma nova senha.

Primeiro, discutimos a necessidade de criar rotas GET e POST para o recuperar conta. O @GetMapping é responsável por exibir o formulário, enquanto o @PostMapping processa a nova senha. O código deve ser passado na URL para que possamos verificar se é realmente do usuário.

Em seguida, criamos um novo arquivo HTML para o formulário de recuperação e definimos a classe DadosRecuperacaoConta, que representa os dados do formulário, com os campos para a nova senha e confirmação. Por fim, ajustamos o código no controller para refletir essas mudanças e preparamos o caminho para implementar o método recuperarConta() na service.

Esses passos são fundamentais para finalizar a funcionalidade de recuperação de senha na aplicação.

Para saber mais: salvando dados alterados na sessão: 



# Redefinindo a senha


Nesta aula, aprendemos a implementar a funcionalidade de recuperação de senha em uma aplicação Java utilizando Spring Security. O foco foi na criação do método recuperarConta() na classe UsuarioService, que busca um usuário através de um token único.

Os principais passos abordados foram:

Criação do Método: Implementamos o método recuperarConta(String codigo, DadosRecuperacaoConta dados) que busca o usuário pelo token utilizando o repositório UsuarioRepository.

Verificação do Token: Se o usuário não for encontrado, uma exceção RegraDeNegocioException é lançada, indicando que o link é inválido. Também verificamos se o token expirou, lançando outra exceção se necessário.

Validação da Nova Senha: Verificamos se a nova senha é igual à confirmação. Se não forem iguais, uma exceção é lançada.

Criptografia da Senha: A nova senha é criptografada e atribuída ao usuário, que também tem seu token e a expiração do token definidos como null.

Salvamento das Alterações: As alterações são salvas no banco de dados.

Atualização da Interface: Por fim, adicionamos um link para a página "Esqueci minha senha" no formulário de login, permitindo que os usuários acessem facilmente essa funcionalidade.

Com isso, finalizamos a implementação da lógica de recuperação de senha, garantindo que o fluxo funcione corretamente.

Para saber mais: utilizando senhas com segurança: https://drive.google.com/file/d/1CzoKGnLM7Q-4_Z3lo7siCEmdY8JBqCOb/view?usp=drive_link

# Desafio: permitindo o registro de pacientes: https://drive.google.com/file/d/1NvjoLTCai7fHlIEjF4rpWun8uTZ8GCX4/view?usp=drive_link


# Referências

https://drive.google.com/file/d/1ZceNuL12X01ShCw3oiz1yJNFTzfNK_22/view?usp=drive_link

# Nessa aula, você aprendeu:

- Recuperar o usuário a partir do token gerado para ele, permitindo a redefinição de senha. Vimos que o token é a única coisa que identifica o usuário no momento em que ele quer redefinir a senha. Por esse motivo, esse token deve ser verificado antes de efetivar a troca de senha.

- Resetar os campos relacionados ao token do usuário. Entendemos que é importante deixar o token e seu prazo de expiração como nulos, evitando que esses dados sejam reutilizados depois e atrapalhem a lógica de redefinição de senha.

- Utilizar senhas com segurança. Aprendemos a gerenciar nossas senhas de forma segura, garantindo que nossos dados estejam protegidos nos sites que acessamos.




# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-spring-security-crie-perfis-autorize-requisicoes
![Nome imagem](link) ![Nome imagem 2](link)

