# Apresentação

Neste curso, vamos aprender a criar uma camada de segurança em aplicações web utilizando o Spring Security. Exploraremos a configuração de diferentes usuários, permitindo que eles façam login, logout e acessem informações específicas. Também abordaremos os tipos de ataques que podem ocorrer na web e como nos proteger deles, utilizando boas práticas de segurança.

O projeto prático será desenvolvido na Clínica VollMed, onde lidaremos com dados de médicos e consultas. Inicialmente, a aplicação não terá segurança, mas ao longo do curso, implementaremos essa camada. A primeira interação do usuário será através de uma página de login, onde ele poderá acessar a aplicação e, posteriormente, sair dela.

Para aproveitar melhor o curso, é recomendado ter conhecimentos prévios em Java e Spring Boot, além de realizar todas as atividades e consultar os materiais complementares. Vamos começar o desenvolvimento!

Preparando o ambiente: ferramentas e configuração do banco de dados: https://drive.google.com/file/d/1jIDPesQG1w4VBocpTVDs4JTqcXVT84x3/view?usp=drive_link


# Adicionando o Spring Security à aplicação

Nesta aula, aprendemos a adicionar uma camada de segurança à aplicação web da Clínica Médica VollMed utilizando o Spring Security. O projeto, que roda localmente em localhost:8080, permite que apenas atendentes da clínica acessem informações sensíveis, como dados médicos e consultas.

Iniciamos o processo acessando o site start.spring.io para adicionar a dependência do Spring Security ao nosso projeto Maven. Após incluir a dependência no arquivo pom.xml, recarregamos a aplicação. Com isso, ao tentar acessar a página inicial, fomos redirecionados para uma página de login padrão do Spring, onde um usuário chamado user é criado automaticamente, com uma senha gerada no log da aplicação.

Além disso, aprendemos que o Spring também fornece uma página de logout, permitindo que o usuário saia da aplicação de forma segura. É importante ressaltar que a senha gerada deve ser utilizada apenas em desenvolvimento, e que as configurações de segurança precisam ser personalizadas antes de levar a aplicação para produção.

Ao longo do curso, iremos trabalhar na personalização dessas configurações de segurança para a Clínica VollMed.

# Configurando diferentes usuários

configurar a proteção automática do Spring Security, focando na personalização dos perfis de usuário. Inicialmente, a aplicação utilizava um usuário padrão com uma senha gerada aleatoriamente, o que gerava problemas de gerenciamento, pois a senha mudava a cada reinício da aplicação.

Para resolver isso, criamos uma classe de configuração chamada ConfiguracoesSeguranca dentro de um novo pacote security. Utilizamos as anotações @Configuration e @EnableWebSecurity para indicar que essa classe gerencia as configurações de segurança. Em seguida, implementamos um método anotado com @Bean, chamado dadosUsuariosCadastrados, que retorna um UserDetailsService com dois usuários cadastrados em memória: João e Maria, cada um com seu respectivo e-mail e senha.

Para que o login funcionasse corretamente, adicionamos o prefixo {noop} às senhas, indicando que não estávamos utilizando um codificador de senhas neste momento. Após reiniciar a aplicação, conseguimos realizar o login com sucesso utilizando as credenciais configuradas.

Essa aula nos mostrou como personalizar a segurança da aplicação, criando nossos próprios usuários e configurando o Spring Security para gerenciá-los.

Para saber mais: renderização de páginas web com Thymeleaf: https://drive.google.com/file/d/1X_zHvliyO4UGYajz4e3LW3NCPKnK3EGI/view?usp=sharing

### Nessa aula, você aprendeu:

- Adicionar o Spring Security em uma aplicação web com Spring Boot, utilizando a dependência do Spring Security no pom.xml.

- Sobrescrever o comportamento padrão de segurança com uma classe de configuração. Para isso, criamos uma classe de configuração de segurança com @Configuration e @EnableWebSecurity, onde é possível personalizar nossa camada de segurança.

- Personalizar as configurações de segurança com múltiplos beans. Entendemos que, para trocar as configurações padrão do Spring, utilizamos os beans, onde dizemos ao framework que determinado objeto deverá ser gerenciado por ele.

- Criar usuários específicos para a aplicação. Fizemos isso sobrescrevendo o bean de UserDetailsService.

- Utilizar prefixo "{noop}" durante o desenvolvimento. Vimos que esse prefixo é muito útil quando não queremos configurar um PasswordEncoder para as senhas.

```bash

```

# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-spring-security-proteja-aplicacoes-web

![Nome imagem](link) ![Nome imagem 2](link)

