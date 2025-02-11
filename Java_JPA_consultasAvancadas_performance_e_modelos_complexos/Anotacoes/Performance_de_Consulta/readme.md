# Entendendo Lazy e Eager 

"Performance de consultas" do curso de Java e JPA, é abordada a importância de entender como a JPA lida com o carregamento de dados e sua relação com a performance da aplicação.

É destacado que, ao utilizar a JPA, muitos desenvolvedores esquecem de analisar as consultas SQL geradas, o que pode levar a problemas de performance devido a queries mal planejadas. A aula demonstra que a JPA carrega automaticamente relacionamentos to one (como @ManyToOne) de forma eager, ou seja, esses dados são carregados mesmo que não sejam necessários. Em contrapartida, relacionamentos to many (como @OneToMany) são carregados de forma lazy, apenas quando acessados.

Como boa prática, é sugerido que os desenvolvedores alterem os relacionamentos to one para serem lazy também, evitando o carregamento desnecessário de dados e melhorando a performance das consultas. A aula exemplifica essa mudança e mostra como isso impacta as consultas realizadas, reduzindo o número de joins e a quantidade de dados trafegados.

A aula conclui com a promessa de discutir os possíveis impactos dessa mudança na próxima sessão.


#  Consultas com Join Fetch

Na aula sobre performance de consultas em JPA, foi discutido o uso de relacionamentos lazy e o impacto que isso pode ter nas consultas. Quando um relacionamento é definido como lazy, a JPA evita carregar informações desnecessárias, o que melhora a performance. No entanto, ao acessar um relacionamento lazy após o fechamento do entity manager, pode ocorrer a "LazyInitializationException", que impede o carregamento da entidade relacionada.

Para evitar esse problema, é recomendado o uso de queries planejadas, onde se pode utilizar o comando JOIN FETCH para carregar relacionamentos lazy junto com a entidade principal em uma única consulta. Isso garante que as informações necessárias sejam carregadas sem disparar novos selects, mesmo que o entity manager esteja fechado. Essa abordagem ajuda a manter a aplicação organizada e a evitar gargalos de performance, permitindo que apenas as informações necessárias sejam carregadas em cada consulta.

Além disso, é importante monitorar o SQL gerado pelo Hibernate durante o desenvolvimento para evitar múltiplos selects desnecessários. Ao implementar essas boas práticas, é possível otimizar o desempenho da aplicação e evitar problemas comuns relacionados ao gerenciamento de entidades.





### Nessa aula, você aprendeu:

- Como funcionam as estratégias EAGER e LAZY, em consultas de entidades que possuem relacionamentos;
- Por que a JPA pode lançar a exception LazyInitializationException em determinadas situações;
- As boas práticas no carregamento de entidades com relacionamentos;
- Como realizar consultas planejadas com o recurso join fetch.


```bash

```

# Autor/Professor

Rodrigo da Silva
https://cursos.alura.com.br/course/java-jpa-consultas-avancadas-performance-modelos-complexos

![Nome imagem](link) ![Nome imagem 2](link)

