# Consultas com parâmetro dinâmicos 

Nesta aula do curso de Java e JPA, é abordado como realizar consultas dinâmicas com parâmetros opcionais utilizando a Criteria API. O foco é em criar consultas que possam receber diferentes parâmetros (como nome, preço e data de cadastro) de forma flexível, sem torná-los obrigatórios.

A aula demonstra que, ao construir a JPQL, é necessário começar com uma consulta padrão e adicionar condições apenas se os parâmetros forem fornecidos. Para evitar problemas com parâmetros nulos, é sugerido o uso de uma técnica onde a cláusula WHERE é iniciada com 1=1, permitindo que os filtros sejam adicionados de forma condicional sem gerar erros de sintaxe.

Além disso, é necessário criar uma TypedQuery para definir os parâmetros apenas quando eles forem informados, evitando a tentativa de definir parâmetros que não estão presentes na consulta. O método final retorna a lista de produtos que atendem aos critérios especificados.

A aula conclui com a expectativa de que, no próximo vídeo, será apresentado um recurso adicional da JPA que pode simplificar esse processo de consulta.



# Consultas com Criteria API 

Na aula sobre Criteria API, foi apresentada uma alternativa ao JPQL para realizar consultas em JPA. A abordagem envolve o uso de classes e métodos em vez de strings, permitindo uma construção mais dinâmica das consultas, especialmente quando se trata de parâmetros opcionais.

O processo começa com a obtenção de um CriteriaBuilder através do EntityManager, que é usado para criar uma CriteriaQuery. A consulta é configurada especificando a entidade de origem e, em seguida, filtros são aplicados utilizando objetos do tipo Predicate. Esses filtros são construídos de forma a evitar a duplicação de condições, utilizando o método and do CriteriaBuilder.

A aula também destacou que, apesar das vantagens em termos de flexibilidade e a eliminação de duplicação de código, a API de Criteria pode resultar em um código mais complexo e difícil de ler. O instrutor expressou uma preferência pessoal por manter a simplicidade do código, mesmo que isso signifique ter um pouco de duplicação. A aula concluiu com a ideia de que a escolha entre JPQL e Criteria API depende das preferências e necessidades do desenvolvedor.


### Nessa aula, você aprendeu:

- Como realizar consultas JPQL com parâmetros opcionais;
- Como funciona a Criteria API da JPA;
- Como realizar uma consulta com parâmetros opcionais via Criteria API.

```bash

```

# Autor/Professor

Rodrigo da Silva
https://cursos.alura.com.br/course/java-jpa-consultas-avancadas-performance-modelos-complexos

![Nome imagem](link) ![Nome imagem 2](link)

