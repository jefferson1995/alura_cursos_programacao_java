# Criando a tabela de usuários

link preparar ambiente: https://drive.google.com/file/d/1xWscNy4JS_e2Ev7MhUHvwL0FKJgCJ5Cv/view?usp=drive_link

link resumo aula: https://drive.google.com/file/d/1Ru1cdCjqEZNwhGH1hG88R6ZoGkmcbj8g/view?usp=drive_link

# Configurando a busca de usuários

Nesta aula, aprendemos sobre como persistir usuários no banco de dados e configurar a busca de usuários utilizando o Spring Security.

Primeiro, inserimos dois usuários, João e Maria, na tabela usuários do MySQL. Em seguida, criamos uma interface chamada UsuarioRepository, que estende JpaRepository, para facilitar a interação com a tabela. Implementamos um método de busca chamado findByEmailIgnoreCase, que permite encontrar um usuário pelo e-mail, ignorando maiúsculas e minúsculas.

Depois, integramos essa busca ao Spring Security criando a classe UsuarioService, que implementa a interface UserDetailsService. Nela, configuramos o método loadUserByUsername() para buscar o usuário usando o repositório. Para tornar a busca mais segura, alteramos o método no repositório para retornar um Optional<Usuario>, permitindo o uso de uma exceção personalizada caso o usuário não seja encontrado.

Por fim, discutimos a necessidade de ajustar a configuração do Spring Security para utilizar as informações do banco de dados em vez de dados em memória.

# Alterando a validação dos usuários

a persistência de usuários no banco de dados e como alterar a validação dos usuários em uma aplicação Spring Security.

Primeiro, revisamos a classe ConfiguracoesSeguranca, onde identificamos que o UserDetailsService estava salvando os usuários em memória, o que não era mais desejado. Para resolver isso, decidimos remover o método dadosUsuariosCadastrados().

Em seguida, focamos na classe UsuarioService, que foi anotada com @Service. Isso transformou a classe em um @Bean, permitindo que o Spring gerenciasse essa classe como um UserDetailsService.

Após essas modificações, ao executar a aplicação e tentar fazer login com um usuário, encontramos uma exceção relacionada à falta de um PasswordEncoder. A mensagem de erro indicava que a senha não estava codificada e sugeria o uso do prefixo noop, mas isso não é a melhor prática.

Por fim, a aula nos preparou para entender como funciona o PasswordEncoder e como configurá-lo na classe de segurança para garantir a proteção adequada das senhas dos usuários.


# Utilizando um codificador de senha

aprendemos sobre a importância de proteger as senhas dos usuários em uma aplicação web utilizando o Spring Security.

Iniciamos entendendo que armazenar senhas em texto simples no banco de dados representa uma vulnerabilidade, pois, em caso de vazamento, as senhas podem ser facilmente acessadas. Para resolver isso, utilizamos a criptografia de senhas, e uma das formas mais comuns é o Bcrypt.

Vimos como gerar um hash da senha usando o site bcrypt.online e como atualizar a tabela de usuários no banco de dados com a senha criptografada. Após isso, discutimos como implementar um PasswordEncoder na classe ConfiguracoesSeguranca, que é responsável por codificar as senhas durante o processo de login.

Por fim, testamos o login na aplicação, confirmando que o PasswordEncoder funcionou corretamente, permitindo que os usuários se autenticarem sem precisar inserir a senha criptografada.

A aula concluiu com a promessa de evoluir a parte visual da aplicação na próxima etapa, integrando o Thymeleaf com o Spring Security. Se precisar de mais detalhes ou tiver dúvidas, estou aqui para ajudar!

Para saber mais: explicitando as configurações de segurança: https://drive.google.com/file/d/1ZRpWzktkmzbUvGO-lJ_T8e4CDBDKC20V/view?usp=drive_link

Para saber mais: como o BCrypt funciona por baixo dos panos?: https://drive.google.com/file/d/1J0a2IuuneETcsXqUhtSkU38Ecj-anX04/view?usp=drive_link



### Nessa aula, você aprendeu:

- Que é melhor armazenarmos os dados de usuários em um banco de dados. Dessa forma, o gerenciamento e a escalabilidade se tornam mais fáceis.

- A implementar corretamente as interfaces fornecidas pelo Spring Security. Criamos nossas próprias implementações de UserDetails e UserDetailsService, indicando para o Spring como ele deveria trabalhar.

- A utilizar injeção de dependência no UsuarioService para acessar o repositório. Usamos a anotação @Service para transformar a classe em um bean.

- A necessidade de configurar um PasswordEncoder para criptografar senhas. Criptografamos as senhas dos usuários no banco e adicionamos o BCryptPasswordEncoder para lidar com as senha criptografadas.

```bash

```

# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-spring-security-proteja-aplicacoes-web

![Nome imagem](link) ![Nome imagem 2](link)

