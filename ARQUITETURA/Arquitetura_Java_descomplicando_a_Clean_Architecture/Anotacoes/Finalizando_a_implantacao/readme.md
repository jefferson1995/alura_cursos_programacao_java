# Preparando a interação entre camadas


## Resumo: aula - Criando uma classe de configuração
Nesta aula, revisamos a implementação da nossa aplicação seguindo a Clean Architecture. Estruturamos a aplicação em três pacotes principais: "application", "domain" e "infra".

No pacote "domain", definimos as entidades e regras de negócio, como o Value Object Usuario. Na camada "application", implementamos os casos de uso, começando pelo CriarUsuario, que é responsável por criar uma nova pessoa usuária. Criamos uma interface no repositório "gateways" para definir os métodos de persistência, como cadastrarUsuario e listarTodos.

Na camada "infra", implementamos a persistência com o UsuarioRepository, que estende JpaRepository, e a classe RepositorioDeUsuarioJpa, que implementa a interface do repositório.

Ao tentar executar a aplicação, encontramos um erro relacionado à falta de um bean do tipo CriarUsuario. Para resolver isso, precisamos criar uma classe de configuração chamada UsuarioConfig, onde definimos os beans necessários para a injeção de dependência. Começamos a implementar o método criarUsuario, que retorna uma instância de CriarUsuario, mas percebemos que também precisamos de um bean para RepositorioDeUsuario.

A aula enfatizou a importância de criar uma cadeia de beans para que a injeção de dependência funcione corretamente, permitindo que as camadas se comuniquem de forma adequada sem violar os princípios da Clean Architecture.

Para saber mais: injeção de dependência e inversão de controle: https://drive.google.com/file/d/1jSQCpdAHlqHNYZ1yaiS8pLvPYbPo6GeB/view?usp=drive_link
## Resumo: Aula - Completando a criação de Beans

Nesta aula, aprendemos a finalizar a implementação da criação de beans na nossa aplicação utilizando a Clean Architecture. Começamos identificando a necessidade de um bean do tipo RepositorioDeUsuario, que é implementado pelo RepositorioDeUsuarioJpa. Para isso, criamos um bean para RepositorioDeUsuarioJpa no arquivo UsuarioConfig, injetando as dependências necessárias: UsuarioRepository e UsuarioEntityMapper.

Em seguida, definimos o bean para UsuarioEntityMapper, garantindo que todas as dependências estivessem corretamente configuradas. Após a configuração, executamos a aplicação e verificamos que não havia erros, confirmando que todos os beans estavam definidos corretamente.

Depois, testamos a funcionalidade de cadastro de usuários utilizando o Postman, realizando um POST para cadastrar uma nova usuária, a Emily. Verificamos a resposta da requisição e, em seguida, conferimos no banco de dados, utilizando o pgAdmin, se a gravação foi realizada corretamente.

Por fim, discutimos a importância da Clean Architecture, que nos permite isolar a lógica de domínio e aplicação, facilitando a troca de frameworks e bancos de dados, além de prepararmos o terreno para a implementação do método de listar usuários.

## Resumo: Aula -  Implementando a listagem

Nesta aula, aprendemos a implementar a listagem de usuários na nossa aplicação seguindo a Clean Architecture. Começamos criando o caso de uso ListarUsuarios, onde definimos um método obterTodosUsuario que retorna uma lista de usuários. Para isso, injetamos um repositório (RepositorioDeUsuario) no construtor da classe.

Em seguida, manipulamos o repositório de JPA, implementando o método listarTodos para que ele retornasse todos os usuários do banco de dados, utilizando um Stream para mapear as entidades para o domínio.

Depois, adicionamos um controlador (UsuarioController) com um método listarUsuarios, que utiliza a anotação @GetMapping para responder a requisições GET. Este método transforma os usuários do domínio em DTOs antes de retorná-los.

Por fim, configuramos o bean ListarUsuarios na classe de configuração para que a aplicação pudesse reconhecer e injetar corretamente essa dependência. Com tudo isso implementado, testamos a aplicação no Postman, onde conseguimos listar os usuários cadastrados com sucesso.

A aula enfatizou a importância de seguir a estrutura da Clean Architecture, separando as responsabilidades em diferentes camadas e garantindo que a aplicação fosse modular e fácil de manter.


Para saber mais: revisando o fluxo: https://drive.google.com/file/d/1nJ6RpxIWrP8V3VM76koQCJgf6luur-0j/view?usp=drive_link


### Nessa aula, você aprendeu:

- Criou uma classe de configuração para implementar os beans necessários para trabalhar com injeção de dependência e inversão de controle;
- Implementou a listagem de usuários;
- Entendeu o fluxo completo das camadas segundo os princípios da Clean Architecture.


```bash



```


# Autor/Professor

Jacqueline Oliveira
https://cursos.alura.com.br/course/arquitetura-java-descomplicando-clean-architecture


![Nome imagem](link) ![Nome imagem 2](link)

