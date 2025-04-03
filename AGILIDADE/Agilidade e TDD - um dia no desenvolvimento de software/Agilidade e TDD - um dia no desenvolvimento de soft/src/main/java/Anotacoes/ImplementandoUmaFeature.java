package Anotacoes;

public class ImplementandoUmaFeature {

    //AULA ENTENDENDO A FEATURE

//    Nessa aula, aprendemos como identificar uma nova funcionalidade a ser desenvolvida em um projeto já em andamento.
//    Vimos que, no nosso caso, a tarefa "API for User" está na coluna "To do" do nosso quadro Kanban no Trello.
//    Para entender melhor o que precisamos fazer, analisamos o cartão da tarefa, que nos informa que a API deve cadastrar, listar e detalhar usuários.
//    No entanto, o cartão não detalha quais informações do usuário devemos cadastrar.
//    Para isso, precisaríamos consultar a documentação do projeto ou conversar com alguém do time, como um Product Owner.
//    Como estamos em um curso online, vamos assumir que a documentação informa que precisamos cadastrar apenas o nome, e-mail e senha do usuário.
//    Com isso, já temos o conhecimento necessário para começar a implementar a funcionalidade.
//    Antes de começar a escrever código, vamos analisar o código das outras APIs para entender como elas foram implementadas e seguir os padrões do projeto.
//    No próximo vídeo, vamos começar a implementar a funcionalidade "API for User" com base nas funcionalidades já existentes.

    //ESCREVENDO O CÓDIGO

//    Nessa aula, aprendemos a implementar uma nova funcionalidade em nosso sistema, seguindo o padrão de arquitetura do projeto.
//    Começamos criando uma nova migration para a tabela de usuários, definindo os campos id, name, email e password. Em seguida, criamos a entidade User para representar um usuário no sistema, com os atributos correspondentes e anotações do Lombok para gerar construtores, getters e setters.
//    Depois, criamos um novo pacote users para organizar as classes relacionadas à funcionalidade de usuários. Dentro desse pacote, criamos o UserController, que será responsável por lidar com as requisições relacionadas aos usuários.
//    Implementamos a funcionalidade de listagem de usuários, criando a classe UserService e o UserRepository. Também criamos a classe UserView para representar a visualização dos dados do usuário na API front-end.
//    Por fim, testamos a funcionalidade de listagem, verificando se a API retorna os dados dos usuários corretamente.
//    Lembre-se que ainda temos o desafio de implementar as funcionalidades de cadastro e detalhes do usuário!


    //TESTANDO MANUALMENTE

//    Nessa aula, aprendemos a implementar uma funcionalidade de cadastro de usuários, testando-a manualmente com o Postman.
//            Primeiro, criamos os métodos createBy() no UserController.java e createUserBy() no UserService.java, que recebem um UserForm como parâmetro e salvam o usuário no banco de dados.
//    Depois, testamos a funcionalidade no Postman, enviando requisições do tipo POST para a URL da API.
//    Também testamos a validação de regras de negócio, como a de não permitir o cadastro de dois usuários com o mesmo e-mail, e a de campos obrigatórios.
//    Por fim, vimos que os testes manuais podem ser trabalhosos e propensos a erros, e que a automatização de testes é uma solução para aumentar a produtividade e a confiabilidade do desenvolvimento.



}
