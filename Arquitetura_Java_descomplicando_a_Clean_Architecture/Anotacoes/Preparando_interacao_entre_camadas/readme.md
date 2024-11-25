# Preparando a interação entre camadas


## Resumo: aula - Conceituando casos de uso e interfaces

exploramos a camada de Application da Clean Architecture, onde definimos os Use Cases (Casos de Uso) da nossa aplicação. Começamos criando um novo pacote chamado Application e, em seguida, dois subpacotes: usecases e gateways.

Os Use Cases representam as ações que podem ser realizadas na aplicação, como o cadastro de um usuário. Para isso, criamos uma classe chamada CriarUsuario, que implementa o método cadastrarUsuario, responsável por cadastrar um usuário utilizando um repositório.

Por outro lado, os Gateways são responsáveis por abstrair a persistência dos dados. Criamos uma interface chamada RepositorioDeUsuario, que define os métodos para cadastrar e listar usuários. Na classe CriarUsuario, injetamos essa interface, permitindo que a implementação da persistência seja independente da lógica de negócio.

Essa estrutura ajuda a manter a aplicação organizada e facilita a manutenção e evolução do código, seguindo os princípios da Clean Architecture.

03 Para saber mais: casos de uso: https://drive.google.com/file/d/1IRsB99FSxyYcfYQTO3gpx7ZQOzUSAOru/view?usp=drive_link

## Resumo: aula - implementando um repositório

Nesta aula, focamos na implementação da camada de infraestrutura da Clean Architecture, especificamente na criação do repositório utilizando JPA.

Começamos criando o pacote infra e, dentro dele, dois subpacotes: persistence e gateways. A interface UsuarioRepository, que implementa o JpaRepository, foi movida para o pacote persistence. Em seguida, criamos a classe RepositorioDeUsuarioJpa no pacote gateways, que implementa o repositório de usuários.

Na implementação, declaramos um atributo do tipo UsuarioRepository e criamos um construtor para inicializá-lo. Os métodos cadastrarUsuario e listarTodos foram implementados utilizando os métodos do UsuarioRepository.

Um ponto importante abordado foi a distinção entre a entidade de domínio Usuario e a entidade que representa a tabela no banco, que renomeamos para UsuarioEntity. Essa mudança foi necessária para evitar confusões e garantir que a persistência no banco de dados fosse feita corretamente.

Por fim, discutimos a necessidade de converter o objeto de domínio para a entidade correspondente ao salvar no repositório.

05 Para saber mais: entendendo os subpacotes gateways: https://drive.google.com/file/d/1i3M-JCKdrumbo5vGscWbbkc6t7f2evzp/view?usp=sharing


## Resumo: aula - Ajustando a persistência

Nesta aula, aprendemos sobre a interação entre camadas na arquitetura Clean Architecture, focando na persistência de dados. O principal objetivo foi entender como mapear objetos de domínio para entidades que serão persistidas no banco de dados.

Começamos criando uma classe chamada UsuarioEntityMapper, que tem a função de converter um objeto de domínio Usuario em uma entidade UsuarioEntity e vice-versa. Para isso, implementamos dois métodos: toEntity, que transforma um objeto de domínio em uma entidade, e toDomain, que faz o processo inverso.

Em seguida, ajustamos o repositório de usuários, RepositorioDeUsuarioJpa, para incluir o UsuarioEntityMapper em seu construtor. Isso nos permitiu transformar o objeto de domínio recebido no método cadastrarUsuario em uma entidade, que é então salva no repositório. Após a persistência, o objeto de domínio correspondente é retornado.

Por fim, simplificamos o método cadastrarUsuario, eliminando uma variável intermediária e retornando diretamente o resultado da conversão.

Com isso, preparamos o caminho para o próximo passo, que será trabalhar no controller para efetivar o cadastro de usuários.



## Resumo: Aula - Configurando o controlador

preparar a interação entre camadas na Clean Architecture, focando na configuração do controlador UsuarioController.

Iniciamos criando um novo pacote chamado controller dentro do pacote infra e implementamos a classe UsuarioController, utilizando as anotações @RestController e @RequestMapping para definir o endpoint /usuarios.

Em seguida, injetamos o caso de uso CriarUsuario no controlador, ao invés de injetar serviços ou repositórios, pois o caso de uso representa a lógica de negócio. Criamos um método cadastrarUsuario com a anotação @PostMapping, que recebe um objeto do tipo UsuarioDto como entrada.

O UsuarioDto foi definido como um record, contendo os campos CPF, nome, nascimento e e-mail. No método cadastrarUsuario, convertemos o UsuarioDto em uma entidade de domínio Usuario e chamamos o método cadastrarUsuario do caso de uso. Por fim, retornamos um novo UsuarioDto com os dados do usuário salvo.

A aula também enfatizou a importância de manter as camadas da Clean Architecture isoladas e unidirecionais, garantindo que as classes de domínio não dependam de outras camadas. Por último, discutimos a execução da aplicação e a necessidade de declarar os beans necessários para que o Spring funcione corretamente.



### Nessa aula, você aprendeu:

- Entendeu o conceito dos casos de uso e como eles se assemelham ao pacote service quando utilizamos uma arquitetura MVC;
- Criou uma interface para determinar os métodos que deverão ser implementados no momento em que a persistência for implementada;
- Implementou o pacote persistence no qual colocamos a classe UsuarioEntity para representar a tabela do banco de dados relacional, com suas anotações da JPA e também a interface UsuarioRepository que se estende da JpaRepository;
- Criou um mapper para transformar um objeto de domínio em entidade do banco e vice-versa;
- Criou um DTO para representar os dados que serão trafegados no controlador;
- Implementou o controlador, que irá receber as requisições HTTP e direcioná-las para as classes específicas que lidarão com a gravação dos dados.


```bash



```


# Autor/Professor

Jacqueline Oliveira
https://cursos.alura.com.br/course/arquitetura-java-descomplicando-clean-architecture


![Nome imagem](link) ![Nome imagem 2](link)

