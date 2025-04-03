# Conhecendo os cookies

Link: https://drive.google.com/file/d/1KraFxiazJxwygfVD70cRPHP3NA2HeWnf/view?usp=drive_link

Para saber mais: tipos e política de uso de cookies: https://drive.google.com/file/d/1rDw0M29gis-b3MoUb3wNt_FRgU0cNrYM/view?usp=drive_link

# Salvando dados do usuário em sessões

Link: https://drive.google.com/file/d/1Ig0z3ABIEOq1AVPfOhLlYOuVTdYryTxO/view?usp=drive_link

Para saber mais: conhecendo o SecurityContextLogoutHandler: https://drive.google.com/file/d/1pjIM4IbdGtAg8PBPMYG_ToL1Fdlf216g/view?usp=drive_link


# Preparando o ambiente: código da checkbox

No próximo vídeo, utilizamos uma checkbox para configurar o RememberMe na aplicação. Copie e cole o código abaixo caso queira configurar essa checkbox na sua página de login.

```bash

                <div class="form-group">
                    <label for="remember-me" class="required">Lembrar de mim:</label>
                    <input id="remember-me" name="remember-me" type="checkbox" class="form-control">
                </div>

```

# Implementando o RememberMe

Nesta aula, aprendemos sobre como gerenciar sessões em aplicações web utilizando o Spring Security, focando na implementação do recurso "Remember Me" (Lembre-se de mim).

Duração da Sessão: A sessão padrão dura 30 minutos, mas pode ser configurada no application.properties para durar mais tempo. No entanto, o JSESSIONID é perdido ao fechar o navegador.

Funcionalidade "Remember Me": Para contornar a perda do JSESSIONID, podemos implementar um cookie permanente que mantém a sessão ativa mesmo após o fechamento do navegador. Esse cookie é gerado quando o usuário marca a opção "Lembrar de mim" no formulário de login.

Implementação: No arquivo ConfiguracaoSeguranca.java, adicionamos o filtro rememberMe() após o logout, configurando uma chave para o cookie. Também foi adicionado um campo no formulário de login para que o usuário possa optar por ser lembrado.

Testes: Após configurar o "Remember Me", realizamos testes para verificar se o cookie é gerado corretamente e se a sessão permanece ativa mesmo após o logout e a exclusão do JSESSIONID.

Configurações Adicionais: Aprendemos a usar o método alwaysRemember(true) para que o sistema sempre lembre do usuário, além de como alterar a duração do cookie utilizando tokenValiditySeconds().


# Entendendo a proteção contra CSRF

Link: https://drive.google.com/file/d/1H4-X2hohMvCxgLu0-UkqArtfFdBTRmju/view?usp=drive_link

Para saber mais: Spring Security e gerenciamento de tokens CSRF: https://drive.google.com/file/d/1YSn_aGLiQzTFMBtQBBiFAcTXgnRy5FUK/view?usp=drive_link


05. Integrando o Thymeleaf ao Spring Security
### Nessa aula, você aprendeu:

- O fluxo entre login e logout. Quando fazemos login, criamos uma sessão, e quando fazemos logout, precisamos limpá-la.

- A trabalhar com sessões e cookies. Vimos que as informações precisam ser guardadas tanto do lado do navegador, com os cookies, quanto do lado do servidor, com a sessão. A aplicação sempre verifica o JSESSIONID enviado pelo navegador para permitir ou não que um usuário acesse as páginas do site.

- O que é o ataque hijacking e como se proteger dele. Os cookies de sessão são gigantescos, evitando que uma pessoa consiga descobri-los aleatoriamente.

- Como implementar a funcionalidade "Remember Me" no Spring Security. Podemos criar um filtro adicional, que cuidará da criação de um cookie chamado Remember Me no navegador. Esse cookie pode ter a duração que acharmos mais apropriada.

- A proteção contra CSRF e a geração de tokens de segurança. Compreendemos como funciona o ataque CSRF e como nos protegemos dele, utilizando os tokens de segurança. Também aprendemos como customizar o CsrfRepository no Spring Security, a fim de trocar a forma como os tokens são gerenciados.

```bash

```

# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-spring-security-proteja-aplicacoes-web

![Nome imagem](link) ![Nome imagem 2](link)

