# Enriquecendo o Domínio



## Resumo

resumo da aula sobre "Enriquecendo o domínio" do curso de Arquitetura Java: descomplicando a Clean Architecture:

Aprendemos a isolar o domínio da aplicação e pensar separadamente nas classes de negócio, as entidades de domínio.

Vimos que é comum ter uma separação ainda maior em pacotes, com um pacote "entities" dentro de "domain".

Discutimos a importância de tornar o domínio testável, para garantir que alterações futuras não quebrem a aplicação.

Implementamos um teste unitário para validar o formato do CPF na classe Usuario.

No teste, verificamos que ao tentar criar um usuário com um CPF inválido, uma exceção IllegalArgumentException deve ser lançada.

Aprendemos que os testes unitários facilitam muito o processo de validação e garantem a integridade do domínio, algo essencial na arquitetura Clean.

Ficou claro que a separação de responsabilidades e a testabilidade são pilares fundamentais da Clean Architecture.

O principal aprendizado foi entender a importância de enriquecer o domínio com validações e testes, tornando-o robusto e preparado para futuras manutenções.

Para saber mais: testes unitários: https://drive.google.com/file/d/1dm17zzCo32M-ugAAASU5Cc-6KfzzPjGd/view?usp=sharing

### Para saber mais: validações com uso de Regex

Link: https://drive.google.com/file/d/1kzLMOnIvJfTf0qvFsUlTl2m3qif8gini/view?usp=drive_link



## Resumo: aula - Padrão criacional para objetos complexos

A aula abordou o conceito de Value Objects, que são classes cujos atributos compõem a identidade do objeto, diferente de Entities que possuem um identificador único.

Foi criada a classe Endereco como um Value Object, pois a composição de seus atributos (CEP, número, complemento) define a identidade do endereço.

Para facilitar a criação de objetos complexos como o Usuario, que agora possui um atributo Endereco, foi implementado o padrão de projeto Fábrica, com a classe FabricaDeUsuario.

A Fábrica possui métodos como comNomeCpfNascimento() e incluiEndereco() que encapsulam a complexidade de criar um objeto Usuario com todos os seus atributos.

Essa abordagem torna a criação de objetos mais intuitiva e evita erros comuns, como passar os parâmetros na ordem errada no construtor.

O objetivo é enriquecer o domínio da aplicação, tornando-o mais expressivo e fácil de trabalhar.

Em resumo, a aula abordou o conceito de Value Objects, a implementação de uma Fábrica para criar objetos complexos e como esses padrões ajudam a melhorar a modelagem do domínio da aplicação.




Para saber mais: entidades e objetos de valor: https://drive.google.com/file/d/1y1lffrDRGCt2q_UhtMmJwhKKO3uNov7X/view?usp=drive_link

## Resumo: aula - Testando fábrica de usuários

Nesta aula, aprendemos a testar a FabricaDeUsuarios para criar objetos Usuario de forma mais simples e organizada.

Criamos um novo teste deveCriarUsuarioUsandoFabricaDeUsuario() para verificar se a fábrica está funcionando corretamente.

Utilizamos a fábrica para criar um objeto Usuario com nome, CPF e data de nascimento.

Verificamos se o nome do usuário criado é "Emily" usando o Assertions.assertEquals().

Adicionamos a funcionalidade de incluir endereço no usuário, tornando o método incluiEndereco() público na FabricaDeUsuario.

Testamos a inclusão do endereço, verificando se o complemento do endereço foi definido corretamente.

Aprendemos que o padrão utilizado aqui não é o padrão Factory, e sim o padrão Builder, que facilita a criação de objetos complexos.

Entendemos a importância de manter o domínio limpo e isolado, o que permite aplicar diversos recursos e padrões importantes para o desenvolvimento de aplicações.


Para saber mais: padrões Builder e Factory: https://drive.google.com/file/d/1FJH6ulfmpKmUP_nYF58yB5APzUSHmxHc/view?usp=drive_link



### Nessa aula, você aprendeu:

- Criar regras de negócio diretamente na entidade de domínio, para garantir a integridade das informações do negócio;
- Criar testes unitários no Java, utilizando o framework integrado JUnit, usando a anotação @Test e o método assertThrows da classe Assertions;
- A importância da criação de testes no conceito da clean architecture, visto que caso seja necessário trocar UI, framework, banco de dados ou algum agente externo, garantimos a integridade das regras do domínio;
- O uso dos padrões factory e builder na criação de objetos.


```bash



```


# Autor/Professor

Jacqueline Oliveira
https://cursos.alura.com.br/course/arquitetura-java-descomplicando-clean-architecture


![Nome imagem](link) ![Nome imagem 2](link)

