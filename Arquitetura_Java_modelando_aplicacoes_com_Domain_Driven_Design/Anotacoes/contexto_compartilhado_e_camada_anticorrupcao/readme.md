# Camada anticorrupção

Falamos sobre a importância das camadas de anticorrupção no Domain-Driven Design (DDD).
Elas são como um escudo protetor para o nosso sistema principal, impedindo que problemas em sistemas externos, como uma API de pagamento, causem falhas na nossa aplicação.

Imagine que nosso sistema principal é como o coração do nosso negócio, e não podemos deixar que nada o prejudique. A camada de anticorrupção atua como um tradutor, transformando os dados que recebemos e enviamos para outros sistemas, garantindo que tudo funcione perfeitamente, independente de mudanças externas. 
O objetivo é manter a integridade do nosso sistema principal, que é o que realmente importa para o negócio. A gente precisa sempre avaliar se a adição de uma camada de anticorrupção vai adicionar mais complexidade ou simplificar o código. Se adicionar complexidade, não vale a pena. O foco é sempre reduzir a complexidade, e não aumentá-la!


## Contexto compartilhado?

Aprendemos sobre o Shared Kernel (Núcleo Compartilhado) no contexto do Domain-Driven Design. Basicamente, o Shared Kernel é uma estratégia para decidir se você compartilha dados entre diferentes partes de uma aplicação (como módulos ou microsserviços) ou se é melhor duplicar o código.

Imagine nossa aplicação CodeChella: temos módulos para Vendas, Customer Success, Financeiro e B2B. Todos precisam de informações sobre o usuário. O Shared Kernel nos ajuda a decidir se criamos um pacote compartilhado com essas informações ou se cada módulo terá sua própria versão.

A decisão crucial é: compartilhar ou duplicar? Compartilhar é mais eficiente, mas arriscado se as regras de negócio de um módulo puderem afetar negativamente outro. Duplicar é mais seguro, mas menos eficiente. A melhor escolha depende da sua análise do negócio e de como os diferentes módulos interagem. O ideal é tomar essa decisão na fase estratégica do design, antes mesmo de começar a codificação, para evitar problemas futuros. A aula usou o exemplo de um usuário inativado pelo suporte, impedindo-o de usar um ingresso já comprado, para ilustrar os riscos de um Shared Kernel mal planejado. Lembre-se: o foco é sempre modelar o negócio da melhor forma possível!

Saber mais: https://drive.google.com/file/d/1fPFzbrw_FPxbpSTMe8-ltKXhIFC3gUlE/view?usp=drive_link




### Nessa aula, você aprendeu:

- O que é o Shared Kernel (Contexto compartilhado) no contexto de Domain-Driven Design (DDD) e como ele permite compartilhar um modelo de domínio comum entre diferentes equipes ou partes de um sistema, promovendo a consistência e a integração;

- O propósito de implementar uma Camada Anticorrupção como forma de proteger nosso domínio de influências externas indesejadas, garantindo que a integridade do nosso modelo de domínio seja mantida quando interagimos com sistemas externos ou legados.


```bash

```


# Autor/Professor

Jacqueline Oliveira
https://cursos.alura.com.br/course/arquitetura-java-aplicacoes-domain-driven-design


![Nome imagem](link) ![Nome imagem 2](link)

