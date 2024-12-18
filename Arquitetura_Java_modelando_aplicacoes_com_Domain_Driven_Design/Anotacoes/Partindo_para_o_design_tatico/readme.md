# Separando as camadas e responsabilidadeds

Vimos na prática como aplicar o design tático do Domain-Driven Design, separando nosso projeto em camadas para organizar melhor as responsabilidades. 
Começamos pela camada de aplicação, que é a porta de entrada do usuário, e nela organizamos os pacotes por contexto (evento, ingresso, venda, usuário), movendo os controladores e DTOs para seus respectivos lugares.
Depois, adicionamos as classes de serviço na camada de aplicação também, para controlar o fluxo. Por fim, criamos a camada de infraestrutura, onde ficam as implementações de persistência e repositórios. Aprendemos também a mover os arquivos restantes, como enums e classes de tratamento de erros, para seus locais apropriados. 
No final, refletimos sobre o fato de que, nesse projeto específico, a camada de domínio ficou com poucas classes, mostrando que o desenvolvimento não foi totalmente orientado a domínio desde o início, o que reforça a importância de começar o projeto pensando nas regras de negócio.


## Blocos de construção

Aprendemos sobre Design Tático dentro do Domain-Driven Design (DDD). 
Vimos que, diferente do foco em persistência (CRUD), o DDD prioriza o negócio. Para isso, usamos "blocos de construção" (building blocks). Um deles é a Entidade, que precisa de um identificador único (como um UUID) para ser diferenciada. Criamos um construtor para a entidade Evento, garantindo que informações essenciais sejam fornecidas ao criá-la. 
Outro bloco de construção é o Objeto de Valor, que complementa a Entidade, sem existir sozinho (exemplo: Endereco no Evento). 
Por fim, mencionamos as Fábricas, padrões para criar objetos complexos, que deixamos como desafio para você implementar para a classe Evento. A aula reforça a importância de usar a linguagem e os conceitos do DDD para uma comunicação eficiente na equipe.

Fábricas (Factories)
Além desses itens anteriores, podemos citar a factory (fábrica): um padrão para criar objetos complexos. No curso de Clean Architecture, também mostramos a criação de uma factory, que na realidade é um padrão builder. Ele recebe o nome factory, mas por trás disso, recebemos um padrão builder para construir objetos complexos.

Poderíamos ter várias formas de construir o evento: uma passando somente o endereço; outra passando a lista de ingressos; entre outras. Dessa maneira, criaríamos uma fábrica de eventos para aplicar todas essas implementações. Porém, não faremos essa implementação em vídeo.

Saber mais: https://drive.google.com/file/d/1U3lZuXmLuo9QaU_Wm6M4TZXZhgAbO4Cd/view?usp=drive_link

## Agregados

Aprendemos tudo sobre agregados (aggregates) em Domain-Driven Design (DDD). 
Basicamente, um agregado é um conjunto de entidades que dependem umas das outras para existir. 
Pensando no exemplo do CodeChella, um TipoIngresso não faz sentido sem um Evento associado, certo? 
Então, TipoIngresso está agregado a Evento. Quando salvamos um Evento, automaticamente salvamos seus TipoIngressos associados, pois eles "vivem" juntos, na mesma transação. 
O Endereco também é um exemplo de agregado, pois faz parte do Evento e é persistido junto com ele. 
A chave aqui é entender que, se uma entidade não tem sentido sozinha e precisa sempre estar ligada a outra, temos um agregado. E para finalizar, aprendemos sobre a "raiz do agregado" (aggregate root), que é a entidade principal, a "mãe" do grupo, que coordena todos os outros elementos do agregado.



### Serviços de domínio:

trata sobre serviços de domínio e como utilizá-los em Java, focando na criação de interfaces para definir o comportamento desejado, sem se preocupar com a implementação específica. Vimos que, em situações complexas envolvendo múltiplas entidades, criar uma interface para definir o fluxo da regra de negócio se torna uma solução elegante. 
Isso permite separar a definição do comportamento (na interface) da sua implementação (em outra classe). Foram apresentados dois exemplos: EnviarCupomDesconto, que define como enviar um cupom para um usuário, e RepositorioDeEvento, que define como buscar um evento por cidade. A ideia central é definir um contrato (a interface) que será implementado posteriormente, garantindo que o comportamento desejado seja mantido, independentemente da tecnologia ou estratégia de implementação utilizada. 
Assim como no curso de Clean Architecture, essa abordagem promove a separação de responsabilidades e a organização do código.

Podemos praticar com mais exemplos! Que tal você tentar criar uma interface para um serviço que calcula o valor total de uma compra, considerando possíveis descontos e impostos? Pense nos métodos e parâmetros necessários.

Saber mais: https://drive.google.com/file/d/1qtC7aYFTrCAR0wh726x8vQjWLHGiXTVw/view?usp=drive_link

## Nesta aula: 

- O que são os Blocos de Construção (Building Blocks) do DDD e como eles nos auxiliam a modelar uma aplicação com foco no domínio;

- Que Entidades são objetos que são diferenciados por uma identidade, mantendo continuidade e consistência através de mudanças;

- Que Objetos de Valor são imutáveis e definidos apenas por suas propriedades, não tendo uma identidade própria;

- Que Agregados são um conjunto de objetos associados que tratamos como uma unidade, para fins de mudanças, tendo uma raiz que controla o acesso ao agregado;

- Que as Fábricas são responsáveis por encapsular a lógica de criação de objetos complexos, garantindo que eles sejam criados em um estado válido;

- Sobre os Serviços de Domínio, que controlam o fluxo da aplicação.


```bash

```


# Autor/Professor

Jacqueline Oliveira
https://cursos.alura.com.br/course/arquitetura-java-aplicacoes-domain-driven-design


![Nome imagem](link) ![Nome imagem 2](link)

