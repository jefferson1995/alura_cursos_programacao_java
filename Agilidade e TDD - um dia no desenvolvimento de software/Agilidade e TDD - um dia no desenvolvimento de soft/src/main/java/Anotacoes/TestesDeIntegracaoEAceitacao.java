package Anotacoes;

public class TestesDeIntegracaoEAceitacao {

    //TESTE PYRAMID

//    Nesta aula, aprendemos sobre a Test Pyramid, uma ferramenta que nos ajuda a entender os diferentes tipos de testes e como organizá-los em nossa aplicação.
//    A pirâmide é dividida em três camadas:
//    Testes de Unidade (Unit): São os testes mais básicos, que verificam o funcionamento de uma única classe de forma isolada. São rápidos, fáceis de escrever e manter, e representam a base da pirâmide.
//    Testes de Integração (Service): Verificam a interação entre diferentes classes e módulos, ou seja, como eles "conversam" entre si. São mais complexos que os testes de unidade, mas ainda são importantes para garantir que a aplicação funcione como um todo.
//    Testes de Interface (UI): Simulam a experiência do usuário, testando a aplicação do início ao fim, desde a tela até o banco de dados. São os testes mais lentos e complexos, mas garantem que a aplicação esteja funcionando como esperado para o usuário final.
//    A Test Pyramid nos mostra que devemos ter mais testes de unidade do que testes de integração e de interface, pois eles são mais rápidos, baratos e fáceis de manter.
//            Lembre-se: a pirâmide é apenas um guia, e a proporção ideal de cada tipo de teste pode variar de acordo com o projeto.

    //TESTE DE INTEGRAÇÃO

//    Nessa aula, aprendemos a escrever testes de integração, que são testes que verificam a interação entre diferentes partes do sistema, como o Controller, o Service e o Repository.
//    Vimos como criar um teste de integração para a classe UserController, utilizando o Spring Boot e o JPA para configurar o banco de dados e injetar as dependências necessárias.
//    Também aprendemos a usar o MockMvc para simular requisições HTTP e o TestEntityManager para interagir com o banco de dados.
//    Por fim, vimos como analisar os resultados dos testes e corrigir os erros encontrados.
//            Lembre-se que os testes de integração são importantes para garantir que as diferentes partes do sistema funcionam juntas como esperado, mas também são mais complexos e demorados do que os testes de unidade.
//    Para praticar, você pode tentar criar um teste de integração para a classe UserService, utilizando o Mockito para simular a entrada no banco de dados.

    //TESTE DE ACEITAÇÃO


//    Essa aula fala sobre os testes de aceitação, também conhecidos como testes de UI (User Interface) ou end-to-end. Eles são importantes para garantir que a aplicação funciona como um todo, mas são mais lentos e trabalhosos para escrever e manter. Por isso, devemos usá-los com moderação, priorizando os testes de unidade e integração.
//    No nosso caso, como estamos focando na API do back-end, não vamos escrever testes de aceitação, pois a parte gráfica da aplicação é responsabilidade do time de front-end. Eles usam ferramentas específicas para testar a interface gráfica.
//    É importante lembrar da pirâmide de testes e considerar os fatores relacionados a cada tipo de teste, como a proporção ideal, a performance e o custo de manutenção.


//    A pirâmide de testes representa um guia da proporção ideal de cada tipo de teste que uma aplicação deveria ter, levando em consideração tempo de execução e custo para manutenção.
//    Testes de unidades são rápidos: uma suíte extensa em geral é executada em milissegundos ou segundos. Além disso, são bem baratos de se escrever porque estão isolados e no mesmo nível de abstração do código. Além disso, aliados a práticas como TDD e refatoração, influenciam positivamente no design do nosso código.
//    Testes de serviços são um pouco mais lentos, tendo uma suíte executada em alguns minutos, em geral. É comum acessarem outras peças da infra-estrutura como Bancos de Dados ou Web Services. Por isso, seu setup é mais complicado e tais testes acabam sendo mais caros de desenvolver.
//    Testes de interface são os mais lentos, chegando a horas de execução, além de caros, pela complexidade de escrevê-los. Além disso, qualquer alteração visual pode quebrá-los e, às vezes, apresentam falhas intermitentes.
//    Conheça mais detalhes sobre o conceito de Test Pyramid acessando o seguinte artigo: The Practical Test Pyramid.



    //https://martinfowler.com/articles/practical-test-pyramid.html

//    Nessa aula, você aprendeu:
//    Os principais tipos de testes automatizados que podemos escrever em uma aplicação;
//    O conceito de Test Pyramid;
//    A escrever testes de integração na aplicação;
//    A ideia de um teste de aceitação.



}
