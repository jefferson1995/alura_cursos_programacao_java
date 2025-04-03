# Consultas com funções de agregação

consultas avançadas, especialmente em funções de agregação. A aula começa explicando como realizar consultas simples usando JPQL, como buscar todos os produtos ou aplicar filtros em atributos específicos.

Em seguida, é introduzido o conceito de funções de agregação, como SUM, MIN, MAX e AVG, que permitem realizar operações matemáticas sobre os dados. Um exemplo prático é apresentado, onde é criado um método na classe "PedidoDao" para calcular o valor total vendido, utilizando a função SUM para somar o atributo valorTotal da entidade "Pedido".

A construção da consulta JPQL é detalhada, enfatizando a importância de garantir que os atributos estejam corretamente preenchidos para evitar resultados nulos. Também é mencionado que a JPA suporta funções de agregação padrão do SQL, mas que funções específicas de um banco de dados podem gerar erros se não forem reconhecidas.

A aula termina com um exemplo prático de implementação e teste da consulta de agregação, resultando em um valor total correto. O conteúdo é apresentado de forma clara e prática, facilitando a compreensão sobre como utilizar consultas de agregação com JPA.



# Consultas para relatórios

criação de um relatório de vendas utilizando JPQL, que é uma linguagem de consulta para trabalhar com JPA (Java Persistence API). O relatório deve apresentar três informações principais: o nome do produto, a quantidade total vendida e a data da última venda.

Estrutura da Consulta
Objetivo do Relatório: O relatório deve exibir todos os produtos, a quantidade vendida de cada um e a data da última venda. Por exemplo, um celular pode ter 240 unidades vendidas e a última venda registrada em 1º de fevereiro de 2021.

Entidades Envolvidas: Para construir essa consulta, são utilizadas três entidades:

Produto: contém o nome do produto.
ItemPedido: que armazena a quantidade vendida.
Pedido: que possui a data da venda.
Funções de Agregação: A consulta utiliza funções de agregação:

SUM(item.quantidade): para somar a quantidade vendida de cada produto.
MAX(pedido.data): para obter a data da última venda.
Construção da Query:

A consulta é iniciada com SELECT, onde são especificadas as colunas a serem retornadas.
Utiliza-se FROM Pedido pedido para indicar a tabela principal da consulta.
JOIN é utilizado para relacionar as tabelas, primeiro com ItemPedido e depois com Produto.
É necessário um GROUP BY produto.nome para agrupar os resultados pelo nome do produto, já que estamos usando funções de agregação.
Ordenação dos Resultados: A consulta pode ser ordenada pela quantidade vendida, utilizando ORDER BY item.quantidade DESC para que os produtos mais vendidos apareçam primeiro.

Retorno da Consulta
O método relatorioDeVendas() retorna um List<Object[]>, onde cada elemento da lista representa uma linha do relatório, e cada linha é um array de objetos que contém as três informações distintas (nome do produto, quantidade vendida e data da última venda).
Exibição dos Resultados
Para exibir os resultados, é utilizado um loop for que percorre a lista retornada, imprimindo cada uma das informações.
Conclusão
A aula termina com a observação de que, embora essa abordagem funcione, o uso de List<Object[]> pode ser considerado um pouco "feio" ou não ideal. Na próxima aula, será abordada uma forma de simplificar esse retorno, tornando o código mais limpo e compreensível.

# Consultas com select new

abordado como melhorar consultas em JPQL utilizando o recurso select new. O objetivo é substituir o retorno de um List<Object[]> por uma classe que represente o relatório de vendas, tornando o código mais legível e orientado a objetos.

Inicia-se explicando que, ao invés de trabalhar com um array de objetos genérico, é melhor criar uma classe chamada RelatorioDeVendasVo, que conterá os atributos necessários: nome do produto, quantidade vendida e data da última venda. Essa classe será um value object, contendo apenas atributos, getters e um construtor.

A aula demonstra como usar o select new para instanciar essa classe diretamente na consulta, passando os parâmetros necessários. Também é mencionado a importância de incluir o caminho completo da classe no JPQL para evitar erros de compilação.

Ao final, é executado o código e mostrado que agora o resultado é uma lista de objetos do tipo RelatorioDeVendasVo, facilitando a leitura e manipulação dos dados. A aula enfatiza a importância de refatorar o código para torná-lo mais claro e eficiente ao trabalhar com relatórios em JPA.


# Utilizando Named Queries

aprendemos sobre o uso de named queries na JPA, que são consultas nomeadas que podem ser definidas diretamente nas entidades. A ideia é extrair as consultas da classe DAO e colocá-las na própria entidade, facilitando a localização das consultas relacionadas a cada entidade.

Para criar uma named query, utilizamos a anotação @NamedQuery, onde definimos um nome para a consulta e a própria JPQL. Por exemplo, podemos nomear uma consulta de busca de produtos por categoria como @NamedQuery(name = "Produto.produtosPorCategoria", query = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome").

Na classe DAO, para executar a named query, utilizamos o método createNamedQuery do entity manager, passando o nome da consulta e a classe da entidade resultante. É importante lembrar que o nome da named query deve ser único dentro da aplicação.

Essa abordagem pode ser preferida por alguns desenvolvedores, embora haja quem prefira manter as consultas isoladas nas classes DAO. O uso de named queries é uma maneira simples e eficaz de organizar as consultas em projetos que utilizam JPA.




### Nessa aula, você aprendeu:

- A realizar consultas utilizando funções de agregação, tais como min, max, avg e sum;
- Como escrever consultas de relatórios utilizando JPQL;
- Como utilizar o recurso select new em consultas JPQL;
- A realizar consultas utilizando named queries.


```bash

```

# Autor/Professor

Rodrigo da Silva
https://cursos.alura.com.br/course/java-jpa-consultas-avancadas-performance-modelos-complexos

![Nome imagem](link) ![Nome imagem 2](link)

