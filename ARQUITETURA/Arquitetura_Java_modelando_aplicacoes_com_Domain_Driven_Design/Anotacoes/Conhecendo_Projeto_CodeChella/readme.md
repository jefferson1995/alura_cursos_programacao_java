var ambiente

-DDB_USER=postgres <br>
-DDB_PASSWORD=123456 <br>
-DDB_HOST=localhost <br>
-DDB_PORT=5432 <br>

# Linguagem ubíqua

Aprendemos sobre a importância da Linguagem Ubíqua no Domain-Driven Design. 
Basicamente, é sobre a necessidade de todos falarem a mesma língua, desde o time de negócios até os desenvolvedores. 
Usamos o exemplo do projeto CodeChella, onde a classe Formato no código representava o que, no negócio, era chamado de Setor.
Refatoramos o código, renomeando a classe e todas as suas referências, para garantir a consistência da linguagem. 
Vimos na prática como isso impacta o código, as mensagens de erro, o banco de dados (com o auxílio do JPA e o ddl-auto=update) e até mesmo a API, que precisa ser atualizada para refletir a mudança. O
objetivo é garantir que a linguagem usada em todas as partes do projeto seja a mesma que o negócio utiliza, facilitando a comunicação e a compreensão do sistema. 
Foi um processo que envolveu renomear classes, atualizar getters e setters, e verificar cuidadosamente todas as ocorrências da palavra antiga para garantir que a mudança fosse completa. 
No final, conseguimos cadastrar um evento no Postman usando o nome correto, "setor", no JSON.

Para saber mais: usando uma linguagem onipresente: https://drive.google.com/file/d/1ch2LzMXBsfg2V_NRBoqJHdVS1RJYAKXM/view?usp=drive_link

## Classes anêmicas

Aprendemos sobre as armadilhas das "classes anêmicas" em Domain-Driven Design (DDD). Elas são aquelas classes que só possuem getters e setters, sem nenhuma regra de negócio, sem um "motivo para mudar". Isso é um problema porque, em DDD, o foco é modelar o domínio do negócio, com suas regras e comportamentos.

Criamos um pacote dominio (ou domain) para organizar nossas classes de domínio,
e dentro dele, classes como Evento e Endereco, representando o nosso negócio, 
sem se preocupar com o banco de dados. Vimos que, ao invés de usar apenas setters para modificar os atributos de um Evento, 
podemos criar métodos como incluiNovoTipoDeIngressoAoEvento e aumentaNumeroDeIngressosPorTipo, que encapsulam regras de negócio e dão à classe um propósito além de simplesmente armazenar dados.
Isso torna o código mais robusto, mais fácil de manter e mais alinhado com os princípios do DDD. 
O principal aprendizado é que classes de domínio devem ter comportamentos e regras, não apenas dados!

Para saber mais: complexidade de domínio e complexidade acidental: https://drive.google.com/file/d/16L40x8JnhZbIUgkIwgAFFAC5B4hSmhPt/view?usp=drive_link

## Subdomínios e contextos delimitados

Aprendemos sobre Design Estratégico no DDD, que basicamente é a arte de dividir um grande negócio em partes menores e mais fáceis de gerenciar. Começamos entendendo a importância de identificar o domínio principal – a parte do negócio que gera receita e justifica o desenvolvimento do software. Para a CodeChella, por exemplo, é a venda de ingressos.

Depois, exploramos os subdomínios: o principal (venda de ingressos, no nosso caso), os genéricos (que podem ser terceirizados, como a plataforma de pagamento) e os de suporte (importantes, mas não centrais, como o cadastro de usuários). Usamos um fluxograma para decidir a categoria de cada subdomínio, baseado em se a solução pode ser comprada e se a lógica de negócio é complexa.

Por fim, falamos sobre Contextos Delimitados (Bounded Contexts), que são como "caixinhas" onde organizamos esses subdomínios no nosso software, seja em módulos ou pacotes separados. Tudo isso para manter o foco no que realmente importa e construir um sistema mais organizado e eficiente!

saber mais: https://drive.google.com/file/d/1JTVta2A9_RYOePY0QO8kHli-cngnQdUT/view?usp=drive_link

### Nessa aula, você aprendeu:

- Conheceu o termo Linguagem Ubíqua, que consiste em ter uma linguagem onipresente entre a equipe de desenvolvimento e a equipe de negócios;

- Entendeu o que compõe o domínio e os subdomínios, classificando-os em principal, genérico ou de suporte;

- Aprendeu sobre os contextos delimitados (ou "Bounded Contexts") e como o uso dessa abordagem pode facilitar o design estratégico da aplicação.

```bash

```


# Autor/Professor
Jacqueline Oliveira
https://cursos.alura.com.br/course/arquitetura-java-aplicacoes-domain-driven-design


![Nome imagem](link) ![Nome imagem 2](link)

