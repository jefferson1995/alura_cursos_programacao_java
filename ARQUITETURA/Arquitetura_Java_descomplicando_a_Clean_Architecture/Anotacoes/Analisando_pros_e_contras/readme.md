# Preparando a interação entre camadas


## Resumo: aula - Persistindo dados em outro formato

Nesta aula, aprendemos sobre a persistência de dados em diferentes formatos dentro da arquitetura Java, especificamente utilizando a Clean Architecture. O foco foi na implementação de um repositório que permite gravar dados em memória e, posteriormente, em um arquivo.

Iniciamos criando a classe RepositorioDeUsuarioEmArquivo, que implementa a interface RepositorioDeUsuario. Nela, implementamos os métodos cadastrarUsuario() e listarTodos(), utilizando uma lista em memória para armazenar os usuários. A ideia é que, ao cadastrar um usuário, ele é adicionado a essa lista e, ao listar, todos os usuários armazenados são retornados.

Depois, testamos essa implementação criando a classe UtilizaUsuarioComArquivos, onde instanciamos o repositório e cadastramos alguns usuários fictícios. Para visualizar os dados, implementamos o método toString() na classe Usuario, permitindo que as informações sejam impressas de forma legível.

Por fim, avançamos para a gravação em arquivo, implementando o método gravaEmArquivo() na classe RepositorioDeUsuarioEmArquivo, que utiliza FileWriter para salvar os dados da lista em um arquivo de texto. Aprendemos também sobre o tratamento de exceções ao trabalhar com arquivos, utilizando blocos try/catch.

Essa aula destacou a flexibilidade da Clean Architecture, permitindo que novas formas de persistência sejam implementadas sem afetar o restante da aplicação, além de discutir a importância de considerar trade-offs entre a rapidez de implementação e a facilidade de manutenção.


## Resumo: Aula - Analisando a arquitetura

Nesta aula, analisamos a implementação da Clean Architecture no projeto CodeChella, focando no cadastro e listagem de usuários. A Clean Architecture, ou arquitetura limpa, proporciona clareza ao dividir as responsabilidades em camadas, facilitando a compreensão do que cada parte do sistema faz.

Discutimos a importância do idioma na programação, destacando que a escolha entre português e inglês deve considerar o domínio do projeto e a equipe envolvida. O domínio do CodeChella envolve termos como ingresso, venda e evento, o que justifica o uso do português em algumas partes do código.

Refletimos sobre os cinco problemas que a Clean Architecture busca resolver, como a independência de frameworks, testabilidade, independência de interfaces gráficas, de bancos de dados e de agentes externos. A arquitetura permite que o domínio e as regras de negócio permaneçam protegidos, independentemente das tecnologias utilizadas.

Por fim, abordamos a questão dos trade-offs, ressaltando que as decisões arquiteturais devem ser feitas com base no contexto específico de cada projeto e equipe, considerando as necessidades e os riscos envolvidos.

Para ir mais fundo: https://drive.google.com/file/d/1yRLTYD6mAuJC5UjcygJhONBN74U5BGNK/view?usp=drive_link




### Nessa aula, você aprendeu:

- Entendeu o benefício de usar clean architecture no momento de implementar uma nova forma de persistência dos dados, pois foi relativamente rápido e não afetou em nada a outra forma de persistência; 
- Analisou os prós e contras em usar esse tipo de arquitetura, avaliando os benefícios e os desafios.


```bash



```


# Autor/Professor

Jacqueline Oliveira
https://cursos.alura.com.br/course/arquitetura-java-descomplicando-clean-architecture


![Nome imagem](link) ![Nome imagem 2](link)

