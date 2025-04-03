# Apresentação

apresenta o curso sobre gestão de memória em Java, destacando a importância desse tema para otimizar aplicações e evitar erros inesperados, como o famoso NullPointerException. 
O curso irá explorar a interação do Java com o computador, a organização dos dados na memória, o funcionamento do garbage collector, erros comuns de gestão de memória e a arquitetura da JVM. 
Além disso, será abordado o uso da GraalVM no projeto da API Vollmed, que já foi utilizado em formações anteriores. 
É recomendado ter conhecimentos prévios sobre API REST em Java com Spring Boot, além de conceitos de Threads e Maven.

# Interagindo com o Sistema Operacional

interação entre a aplicação Java e o sistema operacional, focando na API da Clínica Vollmed. Discutimos a importância da gestão da memória, especialmente considerando o grande volume de dados gerados pelas interações entre médicos e pacientes ao longo do tempo.

Relembramos a estrutura do projeto no IntelliJ, que inclui pacotes de domínio e controladores, e enfatizamos a necessidade de testar a aplicação para entender seu funcionamento. Também exploramos o que acontece quando executamos um programa Java, observando o gerenciador de tarefas do Windows para visualizar os processos em execução.

Destacamos que, ao executar um programa, ele se torna um processo que consome recursos do computador, como CPU e memória RAM. A CPU é responsável por processar as informações, enquanto a memória RAM armazena os dados utilizados pelo programa em execução. Por fim, discutimos como a alocação de memória e o processamento de dados ocorrem simultaneamente, preparando o terreno para uma exploração mais profunda sobre como o Java gerencia sua memória nas próximas aulas.


Para saber mais: utilizando o Gerenciador de Tarefas em diferentes sistemas operacionais: https://drive.google.com/file/d/1ixJww1xhkflkqcJfP2YE6q4ATyf2qStq/view?usp=drive_link

# Conhecendo a pilha de execução

Contexto do Problema: A equipe de desenvolvimento da VollMed estava trabalhando em uma API e encontrou um bug ao tentar adicionar uma nova funcionalidade na classe Paciente. O problema surgiu ao chamar o método consultas().

Análise do Código: Ao abrir a classe Paciente.java, notamos que o atributo consultas estava marcado como @Transient, o que significa que não seria salvo no banco de dados. O método consultas() estava retornando consultas(), o que causava uma chamada recursiva infinita.

Identificação do Erro: Ao executar o método consultas(), uma exceção de Stack Overflow Error foi gerada. Isso ocorreu porque o método chamava a si mesmo repetidamente, levando a um loop infinito e, consequentemente, ao estouro da pilha de execução.

Solução do Problema: Para resolver o bug, foi necessário alterar o método consultas() para que ele retornasse a lista consultas em vez de chamar a si mesmo. Após essa correção, o método passou a funcionar corretamente, embora ainda não houvesse consultas para exibir.

Conceito de Stack Overflow: A aula explicou como a pilha de execução (stack) funciona em Java. Cada vez que um método é chamado, uma nova entrada é adicionada à pilha. No caso do loop infinito, a pilha se encheu, resultando em um Stack Overflow Error.

Diferença entre Variáveis e Referências: Discutimos que uma variável armazena um valor diretamente (como um int), enquanto uma referência aponta para um objeto em outra parte da memória. Essa distinção é fundamental para entender como os dados são gerenciados na memória.

Importância do Conhecimento da Stack: A aula enfatizou a importância de conhecer a pilha de execução para evitar problemas como estouros de pilha e garantir que as aplicações sejam robustas e eficientes.


Esses detalhes fornecem uma visão abrangente do que foi abordado na aula, destacando a importância da gestão de memória e a compreensão da pilha de execução em Java. Se precisar de mais informações ou exemplos, estou aqui para ajudar!


Para saber mais: métodos recursivos: https://drive.google.com/file/d/1T5WpOF5C8xGGR7oO-H36Bfzvw-JnwE3I/view?usp=drive_link


# Armazenando objetos na Heap

A aula abordou a diferença entre variáveis e referências na memória Java. As variáveis são armazenadas na pilha (stack), enquanto os objetos são armazenados na memória heap.

A referência é a primeira parte da declaração, como "Paciente paciente", que aponta para o objeto criado com "new Paciente()" na heap.

Ao imprimir uma referência, é exibido o endereço do objeto na heap, pois não há um método toString() definido.

A comparação entre referências verifica se elas apontam para o mesmo objeto na heap. Mesmo que os objetos sejam iguais, as referências serão diferentes.

A pilha (stack) é usada para armazenar métodos, funções e variáveis relacionadas a eles. A heap é usada para armazenar os objetos, que podem ocupar áreas dispersas na memória.

A separação entre stack e heap ajuda a manter a memória organizada, evitando um possível stack overflow ao armazenar diretamente os objetos complexos na pilha.

Foi proposto um exercício prático para entender melhor a diferença entre comparação de referências e comparação de valores dos objetos usando o método equals().

A próxima etapa será aprofundar o entendimento sobre como a heap organiza os dados dos objetos.


Para saber mais: os apontadores em Java: https://drive.google.com/file/d/1wjbFycM35s9RL7KvKc1bxcBtXqaBUDVY/view?usp=drive_link


Para saber mais: a famosa NullPointerException: https://drive.google.com/file/d/1JaEPx95e5dN1hx2OePiNYhwkNLBu9TVP/view?usp=drive_link

Mão na massa: comparando objetos adequadamente: https://drive.google.com/file/d/1gwjZsXIYDPN0atdJV_dQVwhT-FA8KPQX/view?usp=drive_link



### Nessa aula, você aprendeu:

- O funcionamento da interação do seu programa com o computador. Vimos que, ao executarmos um programa, é criado um processo no sistema operacional, que utilizará vários recursos: Rede, Disco, CPU e Memória.

- O que são estouros de pilha e porque eles acontecem. Entendemos que os métodos são empilhados na memória, junto às variáveis e referências declarados em seu escopo. Se fizermos chamadas infinitas aos métodos, teremos um estouro de pilha.

- O que são métodos recursivos e quando utilizá-los. Ao utilizarmos um método que chama ele mesmo, estamos criando um método recursivo, e isso gera um StackOverFlowError. Porém, há situações em que o uso de um método recursivo pode ser essencial para o programa funcionar.

- A divisão da memória entre heap e pilha. Além da pilha, há outra área da memória destinada à heap, onde ficam os objetos criados. Conseguimos associar a pilha à heap através das referências, que apontam para os objetos.

- A comparar as referências e objetos corretamente. Revimos um conceito chave do Java: para compararmos os valores de um objeto, precisamos utilizar o método equals, que pode ser sobrescrito de acordo com os nossos padrões de igualdade. Utilizar o == só vai comparar as referências.


```bash

```


w# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-gestao-memoria-crie-aplicacoes-performaticas-robustas

![Nome imagem](link) ![Nome imagem 2](link)

