
# Preparando o ambiente

Código da migration para alteração da tabela de usuários

```bash
alter table usuarios
add column token varchar(64),
add column expiracao_token timestamp;

```

Código para o mapeamento da rota “/esqueci-minha-senha”

EsqueciMinhaSenhaController

```bash

@Controller
public class EsqueciMinhaSenhaController {
    public static final String FORMULARIO_RECUPERACAO_SENHA = "autenticacao/formulario-recuperacao-senha";
    private final UsuarioService service;

    public EsqueciMinhaSenhaController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("esqueci-minha-senha")
    public String carregarPaginaEsqueciMinhaSenha() {
        return FORMULARIO_RECUPERACAO_SENHA;
    }

    @PostMapping("esqueci-minha-senha")
    public String enviarTokenEmail(@ModelAttribute("email") String email, Model model){
        try {
            service.enviarToken(email);
            return "redirect:esqueci-minha-senha?verificar";
        } catch (RegraDeNegocioException e){
            model.addAttribute("erro", e.getMessage());
            return FORMULARIO_RECUPERACAO_SENHA;
        }
    }
}

```



formulario-recuperacao-senha.html

```bash

<!DOCTYPE html>
<html lang="pt"
      xmlns:th="https://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate="~{template.html}">
<head>
    <title>Voll.med - Recuperar Conta</title>
</head>

<body>
<div layout:fragment="conteudo">
    <main class="container">
        <div class="alert alert-success text-center text-uppercase" th:if="${param.verificar != null}">
            <p>
                <strong>Verifique seu email para redefinir sua senha!</strong>
            </p>
        </div>
        <section class="card form-card">
            <h2 class="title">Recuperação de conta</h2>

            <form th:action="@{/esqueci-minha-senha}" method="post">

                <div class="alert alert-danger text-center text-uppercase" th:if="${param.error != null}">
                    <p>
                        <strong>Dados inválidos!</strong>
                    </p>
                </div>

                <div class="form-group">
                    <label for="email" class="required">Digite o email cadastrado:</label>
                    <input id="email" name="email" type="text" class="form-control" placeholder="email@email.com" required="required">
                </div>

                <button class="btn btn-primary" title="Enviar link de recuperação">
                    Confirmar
                </button>
            </form>
        </section>
    </main>
</div>
</body>
</html>

```

Código para envio de e-mails


```bash

<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-mail</artifactId>
        </dependency>

```

classe que envie e-mails personalizados

```bash

@Service
public class EmailService {

    private final JavaMailSender enviadorEmail;
    private static final String EMAIL_ORIGEM = "vollmed@email.com";
    private static final String NOME_ENVIADOR = "Clínica Voll Med";

    public static final String URL_SITE = "http://localhost:8080"; //"voll.med.com.br"

    public EmailService(JavaMailSender enviadorEmail) {
        this.enviadorEmail = enviadorEmail;
    }
    @Async
    private void enviarEmail(String emailUsuario, String assunto, String conteudo) {
        MimeMessage message = enviadorEmail.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setFrom(EMAIL_ORIGEM, NOME_ENVIADOR);
            helper.setTo(emailUsuario);
            helper.setSubject(assunto);
            helper.setText(conteudo, true);
        } catch(MessagingException | UnsupportedEncodingException e){
            throw new RegraDeNegocioException("Erro ao enviar email");
        }

        enviadorEmail.send(message);
    }

    public void enviarEmailSenha(Usuario usuario) {
        String assunto = "Aqui está seu link para alterar a senha";
        String conteudo = gerarConteudoEmail("Olá [[name]],<br>"
                + "Por favor clique no link abaixo para alterar a senha:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">ALTERAR</a></h3>"
                + "Obrigado,<br>"
                + "Clínica Voll Med.", usuario.getNome(), URL_SITE + "/recuperar-conta?codigo=" + usuario.getToken());

        enviarEmail(usuario.getUsername(), assunto, conteudo);
    }

    private String gerarConteudoEmail(String template, String nome, String url) {
        return template.replace("[[name]]", nome).replace("[[URL]]", url);
    }
}

```


# Gerando o token do usuário

Nesta aula, aprendemos a implementar a funcionalidade de "esqueci minha senha" em uma aplicação Java utilizando Spring Security. O foco principal foi a criação de um método na classe UsuarioService chamado enviarToken(), que tem a responsabilidade de enviar um e-mail com um token para o usuário que esqueceu a senha.

Os principais passos abordados foram:

Busca do Usuário: Utilizamos o repositório de usuários para encontrar o usuário pelo e-mail fornecido. Se o usuário não for encontrado, uma exceção é lançada.

Geração do Token: Se o usuário for encontrado, geramos um token único utilizando a classe UUID e o convertemos para uma string.

Definição da Expiração do Token: O token gerado é atribuído ao usuário, e também definimos um tempo de expiração para esse token, que foi configurado para 15 minutos.

Atualização no Banco de Dados: Por fim, as alterações são salvas no banco de dados, atualizando as colunas de token e expiração do usuário.

Com isso, a funcionalidade de recuperação de senha está em andamento, e na sequência, iremos trabalhar nas rotas do Controller para mapear essa funcionalidade




# Criando um identificador para o usuário

aprendemos a implementar a funcionalidade de "Esqueci minha senha" em uma aplicação. O objetivo é permitir que usuários que esqueceram suas senhas possam redefini-las de forma prática, sem a necessidade de contato com a equipe de atendimento.

Para isso, criamos uma rota que permite ao usuário inserir seu e-mail e, caso ele esteja cadastrado, um link exclusivo de redefinição de senha será enviado. Esse link deve ser público, mas também exclusivo para o usuário que está tentando redefinir a senha, por isso utilizamos um token gerado de forma segura, em vez de IDs previsíveis.

Além disso, definimos um prazo de expiração para o link, evitando que ele possa ser utilizado a qualquer momento. Para implementar essas funcionalidades, adicionamos dois novos campos à classe Usuario: um para o token e outro para o tempo de expiração, utilizando LocalDateTime.

Por fim, realizamos uma migration para adicionar essas novas colunas na tabela de usuários no banco de dados e verificamos se as alterações foram aplicadas corretamente. Essa aula nos preparou para a próxima etapa, que será a geração do token e o tratamento da expiração quando o usuário clicar na opção de redefinição de senha.


# Para saber mais: como funciona o UUID: https://drive.google.com/file/d/1ETQt9ABjrFG4iCQXJiiqNjOlwdUFjwI-/view?usp=drive_link

# Mapeando a rota de recuperação de senha

implementar a funcionalidade de "Esqueci minha senha" em uma aplicação Java com Spring Security. O processo começou com a criação de um controlador chamado EsqueciMinhaSenhaController, onde mapeamos duas rotas: uma para exibir o formulário de recuperação de senha (@GetMapping) e outra para processar o envio do e-mail (@PostMapping).

Em seguida, criamos um formulário HTML para que o usuário possa inserir seu e-mail cadastrado. Este formulário foi posicionado na pasta correta dentro do projeto. Também configuramos a URL de "Esqueci minha senha" para ser pública, permitindo que qualquer usuário acesse sem estar logado, o que foi feito na classe de configurações de segurança.

Após implementar essas partes, testamos a funcionalidade acessando a URL no navegador e verificamos se o token foi adicionado ao banco de dados para o usuário que solicitou a recuperação de senha. Por fim, a aula nos preparou para a próxima etapa, que envolve a configuração do envio de e-mails para que o token seja enviado ao usuário.

# Preparando o ambiente: configurando seu e-mail: https://drive.google.com/file/d/19bX9NZuwUwyCymOialokHeiJr7Chx1xn/view?usp=drive_link

Vamos trabalhar na aplicação em si: para o envio de e-mails, precisaremos de uma biblioteca específica. Adicionaremos uma nova dependência no arquivo pom.xml, a java.mail, após o thymeleaf.extras. Recarregaremos as dependências utilizando o Maven através do botão no canto superior direito. Após isso, as dependências serão baixadas.

```bash

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mail</artifactId>
</dependency>


```

# Enviando links por e-mail

Nesta aula, aprendemos a implementar a funcionalidade de "esqueci minha senha" em uma aplicação Java utilizando Spring Security. O foco principal foi no envio de e-mails para recuperação de senha.

Primeiro, revisamos as configurações necessárias no arquivo application.properties, onde inserimos o e-mail e a senha para o envio de e-mails. Em seguida, adicionamos a dependência spring-boot-starter-mail no arquivo pom.xml para habilitar o envio de e-mails.

Criamos uma classe chamada EmailService no pacote "email", que utiliza o JavaMailSender para enviar e-mails personalizados. Essa classe contém métodos como enviarEmail() e enviarEmailSenha(), que gerenciam o envio de e-mails com o conteúdo apropriado, incluindo um link para redefinição de senha.

Na classe UsuarioService, injetamos o EmailService e chamamos o método enviarEmailSenha(usuario) após salvar o usuário com o token gerado. Para testar a funcionalidade, criamos uma usuária e enviamos um e-mail de recuperação de senha, que foi recebido com sucesso.

Por fim, a aula preparou o terreno para a próxima etapa, que será a implementação da funcionalidade que permitirá ao usuário alterar a senha usando o código gerado.

# Mão na massa: Enviando senha aleatória por e-mail: https://drive.google.com/file/d/1MkR3uwsedGkCSUloP1kPeaCW1JVJ6xiT/view?usp=drive_link


### Nessa aula, você aprendeu:

- Implementar a lógica inicial do “Esqueci minha senha”. Entendemos que é necessário um token para identificar o usuário que deseja redefinir a senha. Também é importante que esse token tenha um prazo de expiração.

- Configurar um controller utilizando diferentes parâmetros. Nos aprofundamos em como o controller dialoga com as páginas web, utilizando o Thymeleaf. Ao criar novas rotas, praticamos o uso de parâmetros, a exibição de erros e outros recursos.

- Configurar e testar o envio de e-mails utilizando Spring Mail. Realizamos todas as configurações no ambiente e na aplicação para enviar e-mails. Criamos textos personalizados para enviar para o usuário que esqueceu a senha. Entendendo essa parte, podemos incluir o envio de e-mails em outras partes do site.


```bash


```

# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-spring-security-crie-perfis-autorize-requisicoes
![Nome imagem](link) ![Nome imagem 2](link)

