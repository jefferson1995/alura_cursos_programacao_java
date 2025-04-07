# Apresentação:

Nesta aula do curso "Java e Spring Security: proteja suas APIs REST", a instrutora Iasmin Araújo dá as boas-vindas e apresenta os objetivos do curso, que incluem a criação de uma camada de segurança usando Spring Security em APIs REST. Ela destaca a importância de ter concluído os cursos anteriores da formação de segurança em Java, além de ter conhecimento sobre banco de dados.

Os principais tópicos abordados incluem:

Diferenças na segurança entre aplicações web e APIs.
Uso da biblioteca JWT para gerar tokens de acesso e o funcionamento dos refresh tokens.
Configuração de diferentes estilos de relacionamento entre usuários e perfis, incluindo hierarquia.
Tratamento correto de erros HTTP relacionados à segurança, como os códigos 401 e 403.
O projeto prático será desenvolvido em uma API chamada "fórum Hub", que é baseada no fórum da Alura. Iasmin também incentiva os alunos a utilizarem o fórum do curso e o Discord para esclarecer dúvidas e interagir com a comunidade.


# Preparando o ambiente: ferramentas e configurações: https://drive.google.com/file/d/1ecAby2YfTrI1cXk3p631oTV8_9yXFAk5/view?usp=drive_link

# Criando uma camada de proteção na aplicação

Java e Spring Security: proteja suas APIs REST", aprendemos a adicionar uma camada de proteção na aplicação do Fórum Hub, que permite que usuários postem dúvidas de programação.

Começamos entendendo como a aplicação funciona, realizando requisições via API usando o Postman, ao invés de uma aplicação web. Aprendemos a criar tópicos com informações como título, mensagem, autor e cursoId, e a verificar se o tópico foi criado corretamente através do status HTTP.

Identificamos um problema de segurança: a possibilidade de cadastrar tópicos em nome de outros usuários. Para resolver isso, introduzimos o Spring Security, que nos permitirá autenticar usuários e garantir que os tópicos sejam registrados com o nome do usuário logado.

Aprendemos a adicionar a dependência do Spring Security no arquivo pom.xml e a reiniciar a aplicação para aplicar as mudanças. Após a configuração, testamos uma requisição e recebemos um status HTTP 401 Unauthorized, indicando que a proteção está funcionando.

Essa aula nos preparou para as próximas etapas, onde configuraremos os usuários e suas permissões na aplicação. Se precisar de mais detalhes ou tiver dúvidas, estou aqui para ajudar!


# Para saber mais: conhecendo a aplicação do Fórum Hub: https://drive.google.com/file/d/1PMTitAjwU67Xz0wbkae3280uqMqaOqa1/view?usp=drive_link

# Definindo usuários personalizados

adicionar usuários personalizados à nossa aplicação utilizando o Spring Security. Inicialmente, observamos que o Spring gera um usuário padrão e uma senha aleatória, que são utilizados apenas em momentos de desenvolvimento. Para personalizar a autenticação, criamos uma classe Usuario, que representa os usuários do nosso fórum e implementa a interface UserDetails.

A classe Usuario foi configurada com atributos como nomeCompleto, email, senha, nomeUsuario, biografia e miniBiografia. Também implementamos os métodos necessários para que o Spring entenda como realizar o login, sobrescrevendo getPassword() e getUsername().

Em seguida, criamos uma migration para armazenar os dados dos usuários no banco de dados, definindo a tabela usuarios com os atributos correspondentes. Para gerenciar a autenticação, implementamos a classe UsuarioService, que utiliza o UsuarioRepository para buscar os usuários pelo email.

Por fim, discutimos a necessidade de criptografar as senhas dos usuários antes de armazená-las no banco de dados, preparando-nos para a próxima etapa do desenvolvimento.

# Para saber mais: os métodos da interface UserDetails: https://drive.google.com/file/d/1kTcDej_NIfxwurOHqaJRjFTUjexa7zfp/view?usp=drive_link

# Criptografando as senhas dos usuários

importância da criptografia das senhas dos usuários em uma aplicação. Vimos que as senhas não devem ser armazenadas em texto puro para evitar problemas de segurança em caso de vazamento de dados. Para isso, utilizamos o BCryptPasswordEncoder para criptografar as senhas antes de armazená-las no banco de dados.

Criamos uma classe de configuração de segurança chamada ConfiguracoesSeguranca, onde utilizamos as anotações @Configuration e @EnableWebSecurity para informar ao Spring que estamos lidando com configurações de segurança. Dentro dessa classe, definimos um método que retorna um PasswordEncoder, que será responsável pela criptografia das senhas.

Após configurar a criptografia, inserimos um usuário no banco de dados com a senha já criptografada e testamos o login na aplicação. Ao acessar a página de login, conseguimos autenticar o usuário com sucesso, confirmando que as configurações estavam corretas.

Por fim, revisamos a criação da classe Usuario, que implementa UserDetails, e a classe UsuarioService, que implementa UserDetailsService, ambas essenciais para o gerenciamento de usuários na aplicação.

Para saber mais: autenticação Basic no Postman: https://drive.google.com/file/d/1APgNz_G8zPEFHSwbkC6RNNJtyfve4DXh/view?usp=drive_link



### Nessa aula, você aprendeu:

- Trabalhar com configurações diferentes do padrão estabelecido pelo Spring Security. Vimos que o Spring Security tem várias configurações padrão, que são definidas assim que adicionamos a dependência na aplicação. Essas configurações podem ser alteradas ao definirmos beans de configuração.

- Configurar usuários do Spring Security na aplicação Revisamos as configurações necessárias para adicionar usuários a uma aplicação. Esses usuários passam a ser “conhecidos” pelo Spring Security quando implementamos as interfaces UserDetails e UserDetailsService. Dessa forma, no momento do login, o Spring conseguirá buscar dados de usuários no banco.

- Criptografar as senhas de usuários. Relembramos a importância de armazenar senhas criptografadas no banco de dados e como “informar” para o Spring que estamos trabalhando com criptografia. Para isso, criamos um bean do tipo PasswordEncoder.

- Utilizar vários métodos de UserDetails. Entendemos métodos de implementação opcional da interface do Spring Security e vimos qual o fluxo utilizado para chamar esses métodos automaticamente.

```bash

```

# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-spring-security-proteja-aplicacoes-web

![Nome imagem](link) ![Nome imagem 2](link)

