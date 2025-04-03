# Apresentação

Mapeamentos avançados, incluindo o relacionamento many-to-many e relacionamentos bidirecionais.

Consultas mais complexas, como funções de agregação, named queries e o uso de select new para relatórios.

Performance em consultas, abordando conceitos como carregamento lazy e eager, além de join fetch.
A API de Criteria como uma alternativa ao JPQL, discutindo suas vantagens e desvantagens.
Mapeamento de herança e chaves compostas na JPA.

# Relacionamentos many-to-many

é abordado o mapeamento de relacionamentos muitos para muitos em JPA, focando na relação entre pedidos e produtos. Um pedido pode conter vários produtos e um produto pode estar presente em vários pedidos, o que requer uma tabela de junção.

Para um mapeamento simples, seria criada uma tabela chamada "itens_pedido", contendo apenas os IDs de pedido e produto. No entanto, como é necessário armazenar informações adicionais, como a quantidade de produtos e o preço unitário no momento da compra, é preciso criar uma nova entidade chamada "ItemPedido".

A entidade "ItemPedido" terá um ID próprio, além de relacionamentos com as entidades "Pedido" e "Produto", utilizando a anotação @ManyToOne para esses relacionamentos. A classe "Pedido" terá uma lista de "ItemPedido", mapeada com a anotação @OneToMany, criando um relacionamento bidirecional entre as entidades.

A aula também enfatiza a importância de criar um construtor e os métodos getters e setters para a nova entidade, e finaliza prometendo discutir boas práticas para lidar com relacionamentos bidirecionais na próxima aula.


# Relacionamentos bidirecionais

Relacionamento Bidirecional: A aula aborda como mapear relacionamentos bidirecionais entre as classes Pedido e ItemPedido. O ItemPedido já possui um mapeamento para Pedido, e Pedido também deve mapear o relacionamento de volta para ItemPedido.

Cuidado com o Mapeamento: É importante usar a anotação @OneToMany(mappedBy = "pedido") no lado do Pedido para indicar que esse relacionamento já está mapeado na classe ItemPedido. Se isso não for feito, a JPA pode criar uma nova tabela desnecessária.

Inicialização de Coleções: É uma boa prática inicializar listas na declaração dos atributos, como private List<ItemPedido> itens = new ArrayList<>();, para evitar verificações constantes de nulidade.

Método Utilitário: Para facilitar a adição de itens a um pedido, recomenda-se criar um método na classe Pedido que adicione um ItemPedido, garantindo que ambos os lados do relacionamento sejam atualizados corretamente.

Dicas de Implementação: Ao implementar o construtor do ItemPedido, é sugerido que o preço unitário do produto seja definido diretamente no construtor, evitando esquecimentos.

Próximos Passos: Na próxima aula, será feito um exemplo prático de como criar um produto, adicionar um item e testar o relacionamento na classe principal.


# Teste do relacionamento bidirecional

Nesta aula, é abordado o teste do relacionamento bidirecional entre as entidades Pedido e ItemPedido, utilizando JPA. O processo começa com a criação de uma nova classe de teste chamada "CadastroDePedido", onde se reaproveita o código de cadastro de produtos para popular o banco de dados com categorias e produtos.

É explicado que, para criar um pedido, é necessário ter um cliente associado. O procedimento de adicionar itens ao pedido é detalhado, enfatizando a importância de gerenciar transações corretamente. Também são criadas classes DAO para gerenciar operações de banco de dados, como ProdutoDao e ClienteDao.

A aula destaca a necessidade de persistir o cliente antes de associá-lo ao pedido e introduz o conceito de cascade na JPA, que permite que a persistência de um pedido também persista os itens associados a ele.

Por fim, são feitos ajustes nas anotações das colunas para seguir a convenção de nomenclatura desejada, e a aula conclui ressaltando a importância do entendimento dos relacionamentos e mapeamentos na JPA, com a promessa de continuar com novos assuntos na próxima aula.



### Nessa aula, você aprendeu:

- A mapear novas entidades na aplicação conforme a modelagem do banco de dados;
- A mapear um relacionamento com cardinalidade muitos-para-muitos;
- A mapear um relacionamento bidirecional;
- Como persistir entidades que possuam relacionamentos bidirecionais.


```bash

```

# Autor/Professor

Rodrigo da Silva
https://cursos.alura.com.br/course/java-jpa-consultas-avancadas-performance-modelos-complexos

![Nome imagem](link) ![Nome imagem 2](link)

