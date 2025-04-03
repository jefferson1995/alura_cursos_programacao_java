# Conhecendo o projeto CodeChella



## O que é Arquitetura?

Comparando-o à profissão de arquiteto de construções. Assim como um arquiteto de construções, o arquiteto de software pensa em como os diferentes componentes de uma aplicação se conectam.

Algumas propostas de arquitetura de software, como a Arquitetura Hexagonal (Ports & Adapters), a Arquitetura em Cebola (Onion Architecture) e a Clean Architecture.

### Conceitos tipos de arquitetura

- Arquitetura hexagonal (hexagonal architecture)
- Arquitetura onion (onion architecture)
- Clean architecture

Saber mais: https://drive.google.com/file/d/1OoC6uR69ppFgE8L63zLf825MktQRrzcx/view?usp=drive_link

## Separando as camadas do projeto codechella

Inicialmente, o projeto violava alguns princípios da Clean Architecture, pois a classe Usuario estava acoplada à persistência e ao framework Spring.

Para resolver isso, foi criada uma pasta chamada naousar, onde foram movidas todas as classes que não fazem parte do domínio da aplicação.

Em seguida, foi criado o pacote domain, onde foi definida a classe Usuario, que representa a entidade de domínio, sem depender de anotações ou frameworks específicos.

A classe Usuario foi criada com os atributos básicos (CPF, nome, data de nascimento e email) e os métodos getters e setters.

A filosofia da Clean Architecture é manter as regras de negócio dentro do próprio domínio, evitando acoplamento desnecessário com outras camadas.

O objetivo dessa refatoração é ter um código Java puro, que possa ser facilmente utilizado em diferentes frameworks ou contextos, sem depender de elementos externos.


Para saber mais: arquitetura limpa: https://drive.google.com/file/d/13mnymmP7hvjJjXhsCg43xZcZXeSaUA9G/view?usp=drive_link



### Nessa aula, você aprendeu:

- A importância de uma boa arquitetura para o desenvolvimento de sistemas eficientes e sustentáveis.
- A ideia central dos tipos de arquiteturas, que tem por objetivo a separação entre a lógica de negócios e as tecnologias externas, sejam bancos de dados, frameworks etc.
- As diferenças e semelhanças entre as arquiteturas hexagonal, onion e clean.
- Os princípios por trás da clean architecture, que visa a separação de preocupações



```bash

```


# Autor/Professor

Jacqueline Oliveira
https://cursos.alura.com.br/course/arquitetura-java-descomplicando-clean-architecture


![Nome imagem](link) ![Nome imagem 2](link)

