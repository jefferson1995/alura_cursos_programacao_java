
# Apresentação 

curso de Segurança em Java, ministrada por Iasmin Araújo, o foco é a autorização e a criação de diferentes perfis de usuários na aplicação da Clínica Vollmed. Após ter abordado a autenticação, agora será possível transformar as entidades da aplicação em usuários, como médicos e pacientes, que poderão acessar a plataforma com login.

Serão criados diferentes perfis de acesso, onde atendentes terão mais privilégios em comparação a médicos e pacientes. A aula também introduz o uso do Spring Security para gerenciar essas autorizações e o Thymeleaf para criar visualizações específicas para cada perfil.

Além disso, os alunos aprenderão a implementar funcionalidades como a alteração de senha e a recuperação de senha, além de como enviar e-mails para os usuários com base nos dados armazenados. É importante que os alunos tenham conhecimentos prévios em Java, Spring Boot e banco de dados para acompanhar o curso de forma eficaz.

A aula incentiva a prática através de exercícios e materiais complementares, destacando a importância dos "mão-na-massa" para consolidar o aprendizado.


# Transformando médicos em usuários

continuamos o desenvolvimento do projeto da clínica Vollmed, focando na transformação de médicos e pacientes em usuários do sistema. Iniciamos relembrando o funcionamento da aplicação, onde já tínhamos usuários cadastrados e a possibilidade de listar e cadastrar pacientes.

O objetivo principal foi integrar médicos e pacientes como usuários, reaproveitando os dados de nome e e-mail dos médicos para criar usuários. Para isso, trabalhamos na classe MedicoService, onde ao cadastrar um médico, também criamos um usuário correspondente.

Implementamos a classe UsuarioService para gerenciar a criação de usuários. Ao salvar um médico, chamamos o método salvarUsuario, que recebe nome, e-mail e CRM (usado como senha inicial). Também foi necessário criar a classe Usuario, que contém os atributos e construtores necessários.

Além disso, abordamos a importância de criptografar a senha antes de salvá-la no banco de dados, utilizando o passwordEncoder do Spring Security. Por fim, testamos o fluxo para garantir que a integração entre médicos, pacientes e usuários estava funcionando corretamente.

# Sincronizando IDs de usuários

criar diferentes tipos de usuários e a sincronizar a exclusão de médicos e usuários no sistema. Inicialmente, testamos o cadastro de um médico fictício, verificando se ele também era cadastrado como usuário. No entanto, ao excluir um médico, o usuário correspondente não era removido, o que não era o comportamento desejado.

Para resolver esse problema, decidimos compartilhar o ID do médico e do usuário, facilitando a exclusão. Alteramos a ordem de salvamento, salvando primeiro o usuário e depois o médico, passando o ID do usuário para o médico. Também fizemos ajustes no método salvarUsuario para que ele retornasse o ID do usuário salvo e atualizamos a classe Medico para aceitar esse ID no construtor.

Por fim, discutimos a necessidade de ajustar o banco de dados, já que o ID não será mais autoincrementável, e nos preparamos para testar a exclusão para garantir que tudo funcionasse corretamente.

# Preparando o ambiente: código da migration de médicos: https://drive.google.com/file/d/1fNoQu5mZh4_EZ2CKrBznzV-RPOqtx7Vk/view?usp=drive_link

```bash


ALTER TABLE consultas DROP FOREIGN KEY fk_consultas_medico_id;

ALTER TABLE medicos MODIFY id BIGINT NOT NULL;

ALTER TABLE consultas
ADD CONSTRAINT fk_consultas_medico_id
FOREIGN KEY (medico_id) REFERENCES medicos(id);

```

# Para saber mais: estratégias para salvar usuários: https://drive.google.com/file/d/11V0N29_VXA10pxubIE4yYmEBbBjtN7Hg/view?usp=drive_link


### Nessa aula, você aprendeu:

- Transformar entidades da aplicação em usuários. Entendemos que uma das formas de fazer isso é salvando tanto a entidade quanto o usuário ao mesmo tempo, aproveitando os dados necessários.

- Otimizar consultas no banco de dados. Para evitar o uso de várias junções no banco de dados no momento em que precisamos de uma informação da entidade a partir do usuário logado, podemos compartilhar os IDs de ambos.

- Explorar estratégias para salvar usuários. Comparamos diversas estratégias para transformar entidades em usuários, entendendo quais os conceitos em que cada uma se encaixa melhor.


```bash

```

# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-spring-security-crie-perfis-autorize-requisicoes
![Nome imagem](link) ![Nome imagem 2](link)

