# Carregando classes para a JVM

o fluxo de execução na Java Virtual Machine (JVM) e como as classes são carregadas para a memória. Aqui estão os principais pontos abordados:

JVM como intermediária: A JVM atua como um intermediário entre o sistema operacional e a aplicação Java, sendo responsável por executar os arquivos .class gerados a partir dos arquivos .java.

Carregamento de classes: O primeiro passo da JVM é carregar as definições das classes, utilizando o ClassLoader. Para entender isso, criamos uma classe de teste chamada TestaJVM e utilizamos System.out.println para verificar qual ClassLoader carrega nossas classes.

Tipos de ClassLoaders: Observamos diferentes tipos de ClassLoaders:

- AppClassLoader: Carrega classes da aplicação. 
- PlatformClassLoader: Carrega classes de bibliotecas externas da plataforma Java.
- Bootstrap ClassLoader: Carrega classes padrão do Java, como java.lang e java.util.
- Hierarquia de ClassLoaders: A hierarquia é composta por três camadas:

- O Bootstrap ClassLoader carrega classes essenciais.
- O Platform ClassLoader carrega bibliotecas externas da plataforma.
- O Application ClassLoader carrega classes da aplicação e dependências.
- Carregadores nulos: Discutimos por que o ClassLoader de algumas classes, como ClassLoader e classes padrão, retorna nulo, devido à sua inicialização automática.

Próximos passos: A aula conclui com a promessa de explorar os próximos passos do fluxo de execução na JVM e os erros comuns que podem ocorrer durante o carregamento de classes.

Para saber mais: erros comuns com Classloading: https://drive.google.com/file/d/1e9ldebhYmp89jOjDyvUjuHgnlTeG7Dt4/view?usp=drive_link

#  Organizando os dados da execução

o fluxo de execução da JVM (Java Virtual Machine) e como ela organiza os dados durante a execução de um programa Java.

Arquivo .class: O processo começa com o carregamento do arquivo .class pelo class loader, que é responsável por linkar e carregar as definições para dentro da JVM.

Áreas de Dados de Execução: Após o carregamento, os dados são organizados em áreas específicas dentro da JVM:

- Method Area: Armazena associações entre classes, variáveis e métodos estáticos.
- Heap: Onde os objetos são armazenados.
- Java Stack: Guarda as variáveis e métodos de cada thread.
- PC Registers: Mantém o endereço da próxima instrução a ser executada.
- Native Method Stack: Utilizada para métodos nativos, permitindo a importação de funções escritas em linguagens de baixo nível.
- Threads: Cada thread possui sua própria Java Stack, mas compartilha a mesma heap.

Compreender essas áreas é fundamental para otimizar a performance das aplicações Java. Na próxima aula, vamos explorar mais sobre o fluxo de execução da JVM.


# Utilizando o JIT compiler

https://drive.google.com/file/d/1JF0evFBgzFUxJL14amLJkmn0-RhdJi6O/view?usp=drive_link

# Mão na massa: observando a execução do JIT em ação

https://drive.google.com/file/d/1GWBk4cFhjGBaQ1cra_3vIXHNcYXHeaaa/view?usp=drive_link

### Nessa aula, você aprendeu:

- O que é a JVM e como ela funciona. Vimos que a JVM é responsável por fazer nossos programas Java conversarem com o Sistema Operacional. Para isso, ela segue um fluxo de execução, com diversos passos.

- A carregar classes com os ClassLoaders. Pudemos entender a hierarquia dos classloaders, o processo do carregamento de classes e os erros comuns que podemos ter nesse processo.

- Quais são as áreas de dados da JVM. Uma vez que carregamos as classes, podemos carregar os dados para a JVM. Esses dados ficam na pilha Java e na heap, como já tínhamos visto, mas existem outras regiões também: a área de métodos (method area), os registradores PC (PC registers) e a pilha de métodos nativos.

- Como é composta a Execution Engine da JVM. A Execution Engine é responsável por trabalhar com os dados que armazenamos na JVM. Ela tem o interpretador, que traduz os bytecodes para instruções em linguagem de máquina, e o compilador JIT (Just in time), que é quem compila nativamente partes do código que são chamadas recorrentemente.

- A importar um código nativo em seu código Java. Exploramos a method native stack, vendo como importar um código em C no nosso código Java, utilizando a palavra reservada native.

```bash

```

w# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-gestao-memoria-crie-aplicacoes-performaticas-robustas

![Nome imagem](link) ![Nome imagem 2](link)

