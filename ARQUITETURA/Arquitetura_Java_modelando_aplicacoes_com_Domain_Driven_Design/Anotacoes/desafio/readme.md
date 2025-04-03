# Camada anticorrupção

O desafio consiste em modelar, usando os princípios do Domain-Driven Design (DDD), uma aplicação para uma clínica médica que permita o agendamento de consultas. Imagine que você está trabalhando com um especialista de negócios (eu, no caso!) e precisa entender as necessidades do negócio para traduzi-las em uma modelagem de software.

Precisamos considerar as seguintes entidades e seus atributos:

Atendente: Responsável pelo login no sistema e pelas demais funcionalidades. Precisamos pensar como representar isso na nossa modelagem.

Médico: Com atributos como especialidade, CRM (Cadastro de Registro Médico), status (ativo ou inativo) e endereço. Como você representaria essas informações em uma classe?

Paciente: Identificado por seu CPF, com e-mail e endereço obrigatórios. Como você criaria uma classe para representar um paciente, considerando a necessidade de um CPF único?

Consulta: Com atributos como médico, paciente, data, hora e status (agendada, realizada ou cancelada). Precisamos também modelar os motivos de cancelamento (paciente não compareceu, médico cancelou, plano não autorizou, etc.). Como você estruturaria uma classe para representar uma consulta, considerando todas essas informações e a possibilidade de mudanças de status?

Lembre-se: o foco é a modelagem do domínio, usando a linguagem ubíqua (a linguagem que usamos para descrever o problema). Não precisamos escrever código, mas sim definir as classes e seus atributos, pensando na melhor forma de representar o negócio. Você pode usar diagramas

Caso queira, você pode baixar o projeto final do desafio desenvolvido nesta aula: link https://github.com/alura-cursos/3699-java-ddd-desafio

Lembrando que o foco principal desse curso foi a modelagem orientada ao domínio, por isso não fizemos muita implementação de código. A ideia central foi mostrar que entender o propósito do negócio, o que ele resolve e como deve funcionar, suas regras, faz com que possamos ser mais efetivos e coesos na implementação.


# Para ir mais fundo

saber mais: https://drive.google.com/file/d/1dSpKhcsnVf8YgnjiQG27hTMXk3A0Q09Y/view?usp=drive_link


```bash

```


# Autor/Professor

Jacqueline Oliveira
https://cursos.alura.com.br/course/arquitetura-java-aplicacoes-domain-driven-design


![Nome imagem](link) ![Nome imagem 2](link)

