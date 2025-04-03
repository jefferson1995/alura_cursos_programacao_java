# Criando um estouro de memória

A aula focou em como um erro de memória pode acontecer e como podemos evitá-lo. Foi apresentado um cenário onde a listagem de consultas em uma API retornava um erro. A investigação levou à criação de um teste que simulava a situação, adicionando um bilhão de objetos Consulta a uma lista. Isso resultou em um OutOfMemoryError, um estouro de memória na heap.

A solução apresentada foi a utilização de paginação (Page) em vez de listas (List) para retornar dados. Ao invés de carregar todos os dados do banco de dados na memória de uma só vez, a paginação carrega apenas um subconjunto de dados por vez, reduzindo significativamente o consumo de memória e prevenindo o estouro. A aula destaca que essa é uma boa prática para evitar problemas de memória em aplicações que lidam com grandes conjuntos de dados.

Mão na massa: utilizando Page para a listagem de consultas: https://drive.google.com/file/d/1BiW_e7JdrRW12SJN2P1Ow0TChTJmtpRG/view?usp=drive_link

# Limitando a memória da JVM

Aprendemos como lidar com situações em que nosso programa Java precisa de mais memória do que o padrão. Vimos que, às vezes, boas práticas de programação não são suficientes, principalmente quando lidamos com objetos muito grandes, como arquivos CSV gigantescos.

Para resolver isso, aprendemos a pedir mais memória para a JVM (Java Virtual Machine), que é quem realmente executa nosso código. Isso é feito usando argumentos da JVM, especificamente o -Xmx, seguido do tamanho de memória desejado (ex: -Xmx4G para 4 Gigabytes). Vimos como configurar isso no IntelliJ IDEA, editando as configurações de execução do nosso programa.

Experimentamos aumentar a memória alocada gradualmente (de 256MB para 1GB, depois 4GB e finalmente 8GB), executando nosso programa que tentava criar um bilhão de registros. Mesmo com 8GB, ainda tivemos OutOfMemoryError! Isso nos mostrou que, apesar de podermos aumentar a memória disponível, existe um limite, dependendo dos recursos da nossa máquina e do tamanho do problema. Usar muita memória tem um custo, tanto em termos de recursos da máquina quanto, em um ambiente de produção, financeiramente.

Por fim, a aula nos preparou para a próxima, onde vamos usar a ferramenta VisualVM para visualizar melhor o que está acontecendo com a memória do nosso programa. Prepare seu ambiente para a próxima aula

Para saber mais: argumentos da JVM: https://drive.google.com/file/d/1DDAKpje3YBrjeTX3mvRWFqRM9WqFaffI/view?usp=drive_link

# Preparando o ambiente: instalação da VisualVM

https://drive.google.com/file/d/1jlaLy2bn_6cXCOGNPmiuZCsm65X1Dd05/view?usp=drive_link

# Visualizando a coleta de lixo

usar a VisualVM para monitorar o consumo de memória da sua aplicação Java. Vimos como a VisualVM mostra todas as aplicações Java em execução, incluindo a sua própria aplicação Spring Boot. O foco foi no gráfico de memória Heap, onde pudemos observar oscilações no uso da memória. Essas oscilações são causadas pelo Garbage Collector, um recurso do Java que identifica e remove objetos que não estão mais sendo usados, liberando a memória ocupada por eles. Vimos que o gráfico mostra o tamanho total da Heap (em laranja) e a quantidade de memória usada (em azul). A queda brusca no gráfico azul representa a ação do Garbage Collector limpando a memória. A aula introduziu o conceito do Garbage Collector e seus algoritmos, preparando o terreno para uma exploração mais profunda em aulas futuras.


# Para saber mais: explorando a VisualVM

https://drive.google.com/file/d/1l8YadTrpKOnPzdEoXtxqFnRG65qul2Ze/view?usp=drive_link

# Conhecendo o G1


Garbage Collector (GC), especificamente o G1 (Garbage First), e como ele gerencia a memória em Java. Vimos que o GC trabalha de forma autônoma e que tentar forçá-lo com System.gc() ou o botão "Perform GC" na VisualVM não é eficiente.

O G1 divide a memória em três espaços: Eden Space (para objetos recém-criados), Survivor Space (para objetos que sobreviveram a uma coleta de lixo) e Old Generation (para objetos "velhos" que sobreviveram a várias coletas). A principal vantagem dessa divisão é que a memória não é contígua, facilitando a coleta de lixo. O processo de coleta envolve várias fases (como Pause Young e Concurrent Mark Cycle), que são executadas para minimizar interrupções no código. Finalmente, aprendemos que o G1 foi uma grande evolução em relação aos coletores de lixo anteriores, tornando-se o padrão a partir do Java 9.

O comando usado para habilitar os logs do garbage collector no IntelliJ foi -verbose:gc. Este comando é adicionado como uma opção de VM (Add VM Options) nas configurações de execução da sua aplicação. Isso faz com que a JVM imprima informações detalhadas sobre a atividade do garbage collector no console, permitindo que você acompanhe seu funcionamento em tempo real. Lembre-se que você precisa adicionar essa opção antes de executar sua aplicação para ver os logs.

Para saber mais: algoritmos de coleta de lixo: https://drive.google.com/file/d/1pmGaZksoN4u_XX0_P2EY1GAd3diCK7jH/view?usp=drive_link


Mão na massa: comparando os diversos algoritmos de Garbage Collection: https://drive.google.com/file/d/1F3y2FWHuAUQ-OctItDhKsIB6pehhwlYp/view?usp=drive_link




### Nessa aula, você aprendeu:

- O que são estouros de memória. Quando criamos muitos objetos na memória, obtemos um OutOfMemoryError, que indica que a memória alocada para aquele processo não é suficiente para armazenar todos os objetos criados.

- Como lidar com os estouros de pilha. Vimos que, ao utilizar boas práticas, já conseguimos resolver vários erros de estouro de pilha. Porém, existem casos em que isso não é possível. Para isso, podemos usar os argumentos da JVM para aumentar a memória alocada.

- A utilizar uma ferramenta de profiling para monitorar suas aplicações. Conhecemos a VisualVM, uma ferramenta que permite monitorar vários aspectos do computador enquanto uma aplicação Java é executada. Focamos na análise da memória.

- O que é o Garbage Collector. Os objetos têm um ciclo de “vida”: eles nascem, são utilizados, mas em algum momento nenhuma referência utilizada aponta mais para eles. Nesse momento, o Garbage Collector entende que ele virou lixo e libera a memória que ele ocupava antes.

- Como funciona o algoritmo do G1. Existem diversos algoritmos de coleta de lixo. O algoritmo utilizado atualmente é o G1, que é baseado em diversas gerações de objetos, e várias etapas no processo de garbage collection.


```bash

```

w# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-gestao-memoria-crie-aplicacoes-performaticas-robustas

![Nome imagem](link) ![Nome imagem 2](link)

