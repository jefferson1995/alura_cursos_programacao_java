# Deixando a API stateless:

trabalhar com APIs, especialmente em um contexto de segurança com o Spring Security, precisamos entender que as APIs são diferentes das aplicações web tradicionais. Enquanto as aplicações web utilizam sessões e cookies, como o JSESSIONID, as APIs devem ser stateless, ou seja, não mantêm estado entre as requisições.

Para tornar a API stateless, configuramos o Spring Security para não criar sessões. Isso é feito através da definição de um bean chamado filtrosSeguranca() na classe ConfiguracoesSeguranca. Utilizamos o HttpSecurity para especificar que não queremos sessões, definindo a política de criação de sessões como SessionCreationPolicy.STATELESS.

Além disso, desativamos a proteção CSRF, que é desnecessária em um contexto de API onde as requisições são feitas via Postman ou código. Por fim, construímos o método com .build() e executamos o projeto, observando que agora a API permite requisições sem autenticação, o que nos leva à necessidade de criar um filtro próprio para gerenciar a autenticação dos usuários.

Essa aula é fundamental para entender como configurar a segurança de uma API REST de forma adequada, garantindo que ela opere de maneira eficiente e segura.


# Configurando o login da API

configurar o login de uma API utilizando o Spring Security, focando na criação de uma aplicação stateless. Inicialmente, discutimos como o Spring Security gerenciava sessões e formulários de login, mas ao torná-la stateless, removemos essas configurações padrão.

Para implementar a autenticação, criamos um controller chamado AutenticacaoController, onde definimos uma rota para o login. Utilizamos uma record chamada DadosLogin para receber o e-mail e a senha do usuário, garantindo que esses dados não sejam nulos com a anotação @NotBlank.

Em seguida, autenticamos o usuário utilizando o UsernamePasswordAuthenticationToken, que encapsula as credenciais. Para que o Spring possa autenticar o usuário, precisamos definir um AuthenticationManager na classe ConfiguracoesSeguranca, que é injetado no nosso controller.

Por fim, utilizamos o authenticationManager para autenticar as credenciais e retornamos um ResponseEntity com as informações do usuário autenticado. Se a autenticação falhar, retornamos um objeto nulo. Essa configuração é fundamental para garantir a segurança das APIs REST que estamos desenvolvendo.


# Conectando o login a outras urls

Claro! Nesta aula, aprendemos sobre a autenticação de APIs e como conectar o login a outras URLs. Começamos testando a autenticação que criamos, utilizando o Postman para enviar uma requisição POST para a URL /login com um corpo em formato JSON contendo o email e a senha do usuário.

Inicialmente, encontramos um erro 500 Internal Server Error devido à falta de mapeamento da rota de login no nosso controller. Após adicionar a anotação @PostMapping("/login") e o parâmetro @RequestBody no método efetuarLogin(), conseguimos autenticar o usuário corretamente, recebendo um objeto do tipo Authentication com os dados do usuário.

Em seguida, discutimos a necessidade de trafegar informações de autenticação de forma segura, utilizando tokens, já que nossa API é stateless. Para isso, decidimos implementar o JWT (JSON Web Token), que encapsula os dados do usuário logado em um token que será enviado em cada requisição.

Por fim, abordamos a adição da biblioteca Auth0 para trabalhar com JWT em nossa aplicação, que nos permitirá gerar e decodificar tokens. Essa biblioteca foi adicionada ao arquivo pom.xml para que possamos implementar a geração do token e testar suas funcionalidades.

Se precisar de mais detalhes sobre algum ponto específico, é só avisar!


# Gerando o token JWT

aprendemos sobre a geração de JSON Web Tokens (JWT) para autenticação em APIs utilizando a biblioteca Auth0. O foco foi na criação de uma classe chamada TokenService, que será responsável por gerar o token.

Primeiro, discutimos a importância do JWT e como ele pode encapsular informações do usuário, como o nome de usuário e um prazo de expiração para aumentar a segurança. Utilizamos o algoritmo HMAC256 para a criação do token, que requer uma chave secreta.

A classe TokenService foi implementada com um método gerarToken(Usuario usuario), que cria o token utilizando o método JWT.create(), definindo o issuer, o subject e a data de expiração. Também foi criado um método privado expiracao(Integer minutos) para calcular a data de expiração do token.

Por fim, integramos o TokenService na classe AutenticacaoController, onde, após a autenticação do usuário, geramos e devolvemos o token JWT no método efetuarLogin().

Essa aula foi fundamental para entender como proteger nossas APIs REST com autenticação baseada em tokens. Se precisar de mais detalhes ou tiver dúvidas sobre algum ponto específico, estou aqui para ajudar!

# Para saber mais: Token JWT:

Conhecemos um pouco sobre o Token JWT ao longo do vídeo. Caso queira se aprofundar mais, temos um Alura+ sobre o tema: O que é Json Web Token (JWT)? https://cursos.alura.com.br/extra/alura-mais/o-que-e-json-web-token-jwt--c203. Nele, o instrutor detalha os campos do JWT com mais profundidade.

Você também pode analisar a documentação da biblioteca JWT https://jwt.io/ para mais informações.



### Nessa aula, você aprendeu:

- Deixar suas requisições stateless. Entendemos que, em APIs REST, não carregamos o estado de uma requisição para outra. Por isso, não é necessário trabalhar com sessões. Configuramos, então, nossa classe de configuração de segurança para não criar mais sessões, também ignorando a proteção CSRF, já que esse ataque não acontece quando trabalhamos em APIs.

- Efetuar requisições do tipo Basic no Postman. Entendemos como enviar os dados de autenticação no Postman via formulário, considerando parâmetros como CSRF.

- Implementar nosso próprio login. Como definimos a nossa própria cadeia de filtros para deixar a aplicação stateless, o login padrão do Spring Security parou de funcionar. Dessa forma, precisamos definir o nossa própria rota de login, acessada pelos clientes da API.

- Validar informações dos usuários manualmente. No nosso login personalizado, precisamos olhar para os dados enviados na requisição e verificar se estavam corretos. Fizemos isso com a ajuda das classes UsernamePasswordAuthenticationToken e AuthenticationManager.

- Tokens JWT são uma estratégia para autenticação em APIs. Para nos auxiliar a construir aplicações realmente sem estado, entendemos que as informações precisavam trafegar entre as requisições. Tornamos isso possível utilizando tokens JWT.

- Utilizar tokens JWT. Entendemos a estrutura de tokens JWT e como implementá-la nas nossas aplicações, com a ajuda de uma biblioteca externa. Aprendemos a gerar tokens JWT utilizando, especificamente, o email do usuário.


```bash

```

# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-spring-security-proteja-aplicacoes-web

![Nome imagem](link) ![Nome imagem 2](link)

