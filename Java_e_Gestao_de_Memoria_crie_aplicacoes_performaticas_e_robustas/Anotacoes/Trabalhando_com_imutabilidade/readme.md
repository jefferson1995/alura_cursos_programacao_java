# Armazenando String

Começamos revisando a diferença entre stack (pilha) e heap (monte), onde os objetos são alocados. As strings são um tipo básico em Java, representadas pela classe String, e são armazenadas na heap.

Criamos uma classe de teste chamada TestaString para comparar diferentes strings. Ao declarar duas strings com o mesmo valor, percebemos que, apesar de serem objetos diferentes, o Java as considera iguais quando usamos ==, devido ao pool de strings. Isso acontece porque o Java reutiliza objetos de strings iguais para economizar memória.

Para entender melhor, introduzimos a criação de um novo objeto string usando new String(), o que resulta em referências diferentes, e assim, a comparação com == retorna false.

Por fim, discutimos a imutabilidade das strings, que significa que, uma vez criadas, não podem ser alteradas. Essa característica pode impactar o desempenho das aplicações, e vamos explorar mais sobre isso nas próximas aulas.


# Concatenando Strings de forma eficiente

Imagine que as strings são como um livro. Quando você escreve uma palavra em uma página, essa palavra é fixa e não pode ser alterada. Se você quiser adicionar uma nova palavra, você não pode simplesmente mudar a palavra que já está escrita. Em vez disso, você precisa criar uma nova página com a nova palavra escrita ao lado da antiga. Isso representa a imutabilidade das strings: você não altera o que já existe, mas cria algo novo.

Agora, pense na concatenação de strings como se você estivesse montando uma frase em um quadro. Cada vez que você quer adicionar uma nova palavra, você precisa pegar uma nova folha de papel, escrever a nova palavra e colá-la ao lado das palavras que já estão no quadro. Se você fizer isso várias vezes, acabará com muitas folhas de papel (ou objetos) que não são mais necessários, ocupando espaço.

Por outro lado, o StringBuilder pode ser comparado a um quadro magnético. Quando você quer adicionar uma nova palavra, você simplesmente a coloca no quadro, sem precisar de novas folhas de papel. Você pode facilmente mover as palavras, adicionar novas ou até mesmo apagar algumas, tudo isso sem criar novos objetos. Isso representa a mutabilidade do StringBuilder, onde você pode modificar o conteúdo ao longo do tempo sem criar novos objetos na memória.

Assim, quando você está concatenando várias strings em um loop, usar o StringBuilder é como usar um quadro magnético: é muito mais eficiente e organizado do que ficar criando novas folhas de papel a cada nova palavra que você deseja adicionar.

trabalhando com StringBuffers: https://drive.google.com/file/d/1ahWUSnZZrIxo5_oG8lIbeTzRsueXouBu/view?usp=drive_link


# Criando objetos imutáveis

imutabilidade em programação, focando especialmente nos objetos de transferência de dados (DTOs). Discutimos por que os DTOs são considerados objetos imutáveis, já que eles são criados para transferir dados sem modificações.

Vimos um exemplo prático com a classe DadosListagemPaciente, que é uma record em Java, permitindo a criação de objetos imutáveis de forma mais segura e eficiente. Também aprendemos a criar um DTO chamado ListagemPacienteDTO, onde definimos atributos privados e métodos getters, além de um construtor que recebe um objeto Paciente e inicializa os atributos do DTO.

Destacamos que, ao usar records, não é possível criar métodos que modifiquem os dados, o que ajuda a garantir a imutabilidade. Por fim, mencionamos que, ao contrário das strings, os DTOs não têm um pool de objetos, ou seja, cada instância é criada na memória, mesmo que os dados sejam iguais.

Com isso, a aula nos preparou para entender melhor como trabalhar com objetos imutáveis em Java e sua aplicação em projetos de software.

Para saber mais: aplicações da imutabilidade: https://drive.google.com/file/d/1ahWUSnZZrIxo5_oG8lIbeTzRsueXouBu/view?usp=drive_link



### Nessa aula, você aprendeu:

- Que strings são tratadas de forma diferente pelo Java. Como são uma classe extremamente utilizada no dia a dia com Java, as strings são objetos imutáveis, e ficam em uma região diferente da heap, que é o Pool de Strings.

- A utilizar classes específicas para concatenação de Strings. Vimos que, se precisamos concatenar algo muitas vezes na mesma string original, pode ser ineficiente. Por isso, existem classes específicas para a concatenação: StringBuilder e StringBuffer.

- A criar os seus próprios objetos imutáveis. Comparamos a criação de uma classe comum e uma record com a mesma funcionalidade: criar objetos imutáveis representando um DTO. Assim, concluímos que as records foram uma funcionalidade excelente para a construção de objetos imutáveis.

- A aplicar o uso de objetos imutáveis em diversos contextos. Além dos DTOs, entendemos que a imutabilidade também é útil em outros casos, como em aplicações com concorrência.


```bash

```


w# Autor/Professor

Yasmin araujo
https://cursos.alura.com.br/course/java-gestao-memoria-crie-aplicacoes-performaticas-robustas

![Nome imagem](link) ![Nome imagem 2](link)

