# Simplificando entidades com Embeddable

Nesta aula, aprendemos sobre como simplificar entidades utilizando o recurso de @Embeddable da JPA. A partir da classe "Cliente", que inicialmente possui atributos como ID, nome e CPF, foi demonstrado como organizar o código ao extrair atributos comuns para classes separadas, como "DadosPessoais" e "Endereço".

A ideia é evitar que uma classe fique sobrecarregada com muitos atributos, facilitando a manutenção e a legibilidade do código. A classe "DadosPessoais" foi criada para agrupar os atributos nome e CPF, e a classe "Cliente" passou a ter um atributo do tipo "DadosPessoais". Para que a JPA reconheça esses atributos como colunas da tabela "Cliente", foi utilizada a anotação @Embeddable na classe "DadosPessoais" e @Embedded na classe "Cliente".

Além disso, foi abordado o conceito de métodos delegate, que permitem que a classe "Cliente" continue a fornecer acesso aos atributos de "DadosPessoais" sem quebrar a compatibilidade com outras partes do código. Por fim, foi ressaltada a importância de ter um construtor padrão na classe embutível para que a JPA funcione corretamente. Essa abordagem é especialmente útil quando se trabalha com dados que não justificam a criação de tabelas separadas, como telefone e endereço.


# Mapeamento de herança

Na aula sobre mapeamento de herança na JPA, foi abordado como modelar classes utilizando herança e como isso se reflete no banco de dados. A classe base "Produto" possui atributos comuns, enquanto as subclasses "Livro" e "Informatica" têm atributos específicos.

Duas estratégias principais de mapeamento de herança foram discutidas:

Single Table: Utiliza uma única tabela para armazenar todos os atributos, incluindo os específicos de cada subclasse. Isso oferece melhor performance, mas resulta em uma tabela com muitos atributos misturados. A classe base é anotada com @Inheritance(strategy = InheritanceType.SINGLE_TABLE).

Joined: Cria uma tabela para a classe base e tabelas separadas para cada subclasse, mantendo os atributos específicos em suas respectivas tabelas. Isso organiza melhor os dados, mas pode resultar em consultas mais lentas devido à necessidade de joins. A anotação utilizada é @Inheritance(strategy = InheritanceType.JOINED).

Foi sugerido um desafio para pesquisar sobre a estratégia "Table per Class" e suas diferenças em relação à "Joined".

# Mapeamento de chaves compostas

Nesta aula, aprendemos sobre o mapeamento de chaves compostas na JPA. Normalmente, as entidades possuem uma chave primária única, mas em alguns casos, precisamos usar duas ou mais informações como chave. Para isso, criamos uma nova classe, chamada CategoriaId, que contém os atributos que formarão a chave composta, como nome e tipo.

Utilizamos a anotação @Embeddable na classe CategoriaId e a anotação @EmbeddedId na entidade Categoria para indicar que esses atributos juntos formam a chave primária. Ao realizar consultas, em vez de passar um único valor, passamos um objeto do tipo CategoriaId que contém os valores da chave composta.

Além disso, é recomendado que as classes com @Embeddable implementem a interface Serializable para evitar problemas. Essa abordagem permite que a JPA reconheça corretamente a chave composta nas operações de persistência e consulta.




### Nessa aula, você aprendeu:

- A utilizar as anotações @Embeddable e @Embedded para organizar o código de uma entidade;
- A realizar herança entre entidades com as estratégias SINGLE_TABLE e JOINED;
- Como mapear uma chave composta com a anotação @EmbeddedId.


```bash

```

# Autor/Professor

Rodrigo da Silva
https://cursos.alura.com.br/course/java-jpa-consultas-avancadas-performance-modelos-complexos

![Nome imagem](link) ![Nome imagem 2](link)

