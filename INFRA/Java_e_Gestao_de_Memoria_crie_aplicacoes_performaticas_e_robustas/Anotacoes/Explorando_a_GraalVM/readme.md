# Inicializando a aplicação instantaneamente

a importância da inicialização rápida de aplicações Java, especialmente no contexto da Vollmed, onde a equipe de DevOps relatou que a aplicação estava demorando muito para iniciar. A execução da API levou 9,7 segundos, o que pode ser problemático em ambientes de produção.

Discutimos o processo que ocorre desde o arquivo .java até a saída do programa, passando pela compilação com o javac, geração de bytecodes e execução na JVM. Embora o Java ofereça flexibilidade, a inicialização pode ser lenta devido aos vários passos que a JVM precisa executar.

Para resolver esse problema, introduzimos a GraalVM, uma JVM que promete inicialização instantânea e que surgiu no projeto OpenJDK. Aprendemos que podemos baixar a GraalVM diretamente do site da Oracle e que ela é compatível com a versão mais recente do Java, garantindo que não haverá problemas de incompatibilidade.

# Conhecendo a GraalVM

Explorando a GraalVM", aprendemos sobre a importância da GraalVM para melhorar a inicialização de aplicações Java.

Primeiro, foi mostrado como adicionar a GraalVM como uma nova JVM no IntelliJ, através do menu "File > Project Structure", onde podemos selecionar ou adicionar a JDK da GraalVM. Depois, configuramos a execução da aplicação ApiApplication, escolhendo a versão correta do Java.

Em seguida, discutimos o funcionamento da GraalVM, que pode operar em dois modos: JIT (Just-In-Time) e AOT (Ahead of Time). No modo JIT, a GraalVM atua como uma JVM comum, realizando otimizações, mas ainda assim não proporciona uma inicialização instantânea. Já no modo AOT, o bytecode é compilado em um executável nativo, permitindo que a aplicação inicie instantaneamente, embora isso comprometa a portabilidade.

Preparando o ambiente: instalação e configuração da GraalVM: https://drive.google.com/file/d/118xrWxtnKRs5rDxDeyAUF61RJVmGzsoA/view?usp=drive_link

#  Utilizando a GraalVM no Spring

Descobrimos que apenas as configurações do IntelliJ não eram suficientes para executar a GraalVM no modo AOT, necessário para gerar o nosso executável nativo.

Quando apenas adicionamos as configurações, a GraalVM funciona como uma JVM normal e executa no modo JIT. Para realmente executar nossa aplicação no modo AOT, precisamos de várias configurações, tanto no nosso computador quanto no Spring.

A parte do computador disponibilizamos no Preparando Ambiente. É importante que para prosseguir, você já tenha o Visual Studio instalado e as variáveis de ambiente configuradas.

No Spring, precisaremos adicionar um novo modo de execução, que é a compilação nativa. Para fazer isso, utilizaremos um plugin no arquivo .xml.

Adicionando o plugin no pom.xml

Na pasta raiz do projeto, acessamos o arquivo pom.xml. No fim do arquivo, encontramos nossos plugins. Na linha 104, pulamos uma linha e passamos um novo plugin, conforme o código abaixo.

```bash
<plugin>
    <groupId>org.graalvm.buildtools</groupId>
    <artifactId>native-maven-plugin</artifactId>
</plugin>
```

Este plugin será responsável por construir um perfil nativo, que fará a compilação para nós. Feito isso, na lateral superior direita, clicamos no ícone do Maven para fazer o reload.

Após, abriremos o terminal na pasta raiz. Para isso, no menu inferior esquerdo, clicamos no quarto ícone. É importante conferir se está mesmo na pasta raiz.

Para fazermos a compilação nativa, passamos o comando mvn -P native, isso porque queremos criar um perfil nativo para o Maven. Nesse perfil nativo, queremos fazer a compilação nativa. Então, passamos native:compile. Nisso, também queremos pular nossos testes, então passamos -d skip tests.

Como já recarregamos a aplicação e tudo está salvo, podemos executar essa compilação.

```bash
mvn -Pnative native:compile -DskipTests
```

Essa compilação será bem demorada, por volta de 8 a 10 minutos. A GraalVM precisará pegar todas as classes, conferir tudo o que era dinâmico na JVM tradicional e transformar isso em estático.

Ao concluir, nossos arquivos são compilados para um nativo, geramos uma imagem nativa com a GraalVM. Notamos que o build foi feito com sucesso e ele mostra o tempo total. Nesse caso, demorou 7 minutos.

Ao scrollar a tela para cima, notamos que ele exibe quais são os recursos o build utiliza. Nesse caso, utilizou 11,93 GB, que representa 75% do nosso sistema operacional. Além disso, também mostra as threads e todos os passos que estão sendo feitos.

Ele olha para os campos, tipos, métodos, quais são as bibliotecas nativas, o que é a JNI, ou seja, a biblioteca para trabalhar com métodos nativos. Também trabalha com a reflection, que é a parte dos métodos reflexivos, que também aprendemos nessa formação.

Várias coisas ele precisa abstrair e fazer uma compilação estática para conseguirmos construir o que é nativo. Por isso que é um processo demorado e que utiliza bastante memória.

Uma vez que criamos o nativo, ele vai gerar um executável, que fica na pasta target. Então, no terminal, podemos navegar até a pasta passando o comando cd .\target\.

```bash
cd .\target\
```

Feito isso, no explorador, acessamos a pasta "target", nela temos um api.exe, nosso executável. Além disso, ele vai gerar vários arquivos .dll, que são todos os arquivos necessários para a compilação nativa. Isso foi informado para nós no terminal.

Para verificar como isso funciona, testaremos nossa aplicação. No terminal, passamos o comando .\api.exe.


```bash
.\api.exe
```

Feito isso ele inicia a aplicação. Dessa vez demorou 0,37 segundos. Dessa forma, temos a inicialização instantânea que a GraalVM promete.

Além dessa parte interessante que conseguimos ver na prática, existe ainda a economia de memória que ela proporciona. Existem várias outras otimizações por baixo dos panos, então, nesse caso estamos ganhando, mas foi necessário nos dedicar tempo e memória anteriormente.

Sempre precisaremos fazer essas escolhas enquanto pessoas desenvolvedoras. Precisaremos trocar algo em prol de outra coisa. Portanto, precisamos conhecer muito bem nossas aplicações e quais são os nossos objetivos para poder fazer a melhor escolha possível.

Nosso objetivo com relação à API Vollmed foi concluído. Conseguimos evoluir a API e fizemos a gestão de memória da melhor forma possível.




# Para saber mais: criando aplicações poliglotas com a GraalVM

https://drive.google.com/file/d/16v-FLfjgCIZgCRRm_iDNq5nZAv867E94/view?usp=drive_link




# Referências

https://drive.google.com/file/d/1MNChDDLw0JeCWNXd1XRRgJ7WNudVhCvE/view?usp=drive_link





### Nessa aula, você aprendeu:

- Que existem várias JVMs diferentes. A JVM é uma especificação. Se seguimos essa especificação, podemos criar uma JVM nossa. É isso que os diversos vendors (fabricantes) fazem. Por isso, temos uma grande variedade de JVMs, para diferentes finalidades.

- O que é a GraalVM e como utilizá-la. A GraalVM é um tipo de JVM também. Porém, além de ter a função comum de executar um código, ela tem outras funções, como a compilação nativa.

- A compilar nativamente um código com Spring utilizando a GraalVM. Pudemos baixar e executar a GraalVM, e compilar nativamente um código, com o auxílio do Maven e outras ferramentas. Assim, obtemos uma aplicação com inicialização instantânea, que é algo muito útil ao trabalharmos em ambientes de produção.

- Devemos entender as prioridades da nossa aplicação para escolher a melhor JVM. Ao escolher utilizar a GraalVM, temos o benefício da compilação nativa e inicialização instantânea, por exemplo. Porém, ao fazer isso, podemos perder em algum outro aspecto. Poderia acontecer algo semelhante se escolhêssemos alguma outra JVM. É nossa responsabilidade entender isso para fazer nossas escolhas.


```bash

```

w# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-gestao-memoria-crie-aplicacoes-performaticas-robustas

![Nome imagem](link) ![Nome imagem 2](link)

