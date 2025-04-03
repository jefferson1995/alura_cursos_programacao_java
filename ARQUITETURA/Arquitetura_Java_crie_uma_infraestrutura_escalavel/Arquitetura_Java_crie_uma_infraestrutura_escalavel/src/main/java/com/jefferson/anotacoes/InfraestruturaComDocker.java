package com.jefferson.anotacoes;

public class InfraestruturaComDocker {

    // Apresentação

//    introdução do curso "Arquitetura Java: crie uma infraestrutura escalável". Nela, o Rodrigo Caneppele, nosso instrutor, explica que o foco do curso é a infraestrutura, mostrando como colocar uma aplicação Java em produção, utilizando Docker e Docker Compose.
//    Vamos aprender a projetar uma infraestrutura escalável e disponível, utilizando ferramentas como Nginx como proxy reverso, otimizando a performance da aplicação, principalmente na camada de persistência (acesso ao banco de dados).
//    Para acompanhar o curso, é importante ter conhecimentos em Java, APIs Rest com Spring Boot, Docker, Docker Compose e Nginx.


    //Build do projeto

//    fazer o build do nosso projeto Java utilizando o Maven.
//    Vimos que o build é o processo de gerar o executável da aplicação, que no caso do Java com Spring Boot, é um arquivo .jar.
//    Existem duas formas de fazer o build: pela IDE (IntelliJ) ou pelo terminal.
//    Na IDE, podemos usar o comando package do Maven, que irá compilar as classes, executar os testes e gerar o arquivo .jar.
//    No terminal, podemos usar os scripts mvnw ou mvnw.cmd para executar o comando package e gerar o arquivo .jar.
//            Agora, com o arquivo .jar em mãos, estamos prontos dpara fazer o deploy da nossa aplicação!


    //Adicionando docker

//    Nessa aula, aprendemos como adicionar o Docker no nosso projeto Java com Spring Boot.
//            Primeiro, criamos um arquivo Dockerfile que contém as instruções para o Docker construir a imagem da nossa aplicação.
//    O Dockerfile é dividido em duas etapas: a primeira etapa (builder) faz o build da aplicação usando o Maven, e a segunda etapa define como a aplicação será executada.
//    Depois de criar o Dockerfile, usamos o comando docker build para criar uma imagem da aplicação.
//    Por fim, usamos o comando docker run para criar um container baseado na imagem e executar a aplicação.
//    No entanto, ao executar a aplicação dentro do container, encontramos um erro relacionado ao acesso ao banco de dados. Isso acontece porque o Docker não tem o banco de dados configurado.
//    Na próxima aula, vamos aprender como lidar com as dependências da aplicação, como o banco de dados, dentro do Docker.


    //Utiliando docker compose


//    Que legal que você está se aventurando no mundo da infraestrutura com Docker!
//    Nessa aula, aprendemos como configurar nossa aplicação Java para rodar em um ambiente de produção, utilizando o Docker Compose.
//            Primeiro, criamos um arquivo application-prod.properties com as configurações específicas para o ambiente de produção, utilizando variáveis de ambiente para evitar hardcoding de informações sensíveis.
//            Depois, configuramos o Docker Compose para gerenciar dois containers: um para o MySQL e outro para nossa aplicação.
//    Criamos arquivos app.env e mysql.env para armazenar as variáveis de ambiente de cada container.
//    Por fim, subimos os containers com o comando docker compose up --build e nossa aplicação funcionou perfeitamente!
//    Para finalizar, aprendemos a ignorar os arquivos de variáveis de ambiente no Git, adicionando env e mysql-data ao .gitignore.


    //DOCKER HUB
//
//    Ao longo desta aula aprendemos como criar uma imagem Docker da aplicação para então conseguir criar containers baseados nela. Entretanto, essa imagem Docker existe apenas localmente, ou seja, apenas em nosso computador de desenvolvimento. Para compartilhar essa imagem com as outras pessoas do nosso time, ou mesmo ter acesso a ela de um servidor de produção, podemos utilizar o Docker Hub, que é uma plataforma central para compartilhamento de imagens Docker.
//
//    O que é o Docker Hub?
//    Docker Hub é um serviço em nuvem que serve como repositório central para imagens Docker. Tal serviço permite que as pessoas desenvolvedoras publiquem, compartilhem e gerenciem as imagens Docker de suas aplicações de maneira simples. Fazendo uma analogia, é como se o Docker Hub fosse o GitHub, que funciona como um serviço para hospedagem de repositórios Git, porém com o propósito de hospedar imagens Docker.
//
//            Recursos do Docker Hub
//    Registro de imagens
//
//    O Docker Hub oferece suporte ao armazenamento de imagens tanto públicas quanto privadas. As imagens públicas podem ser acessadas e baixadas por qualquer pessoa, enquanto as imagens privadas são restritas às pessoas designadas.
//            Colaboração
//
//    As pessoas podem colaborar em projetos compartilhando imagens Docker via Docker Hub. Isso facilita a distribuição de software e o trabalho em equipe em diferentes fases do ciclo de vida do desenvolvimento.
//    Integração com o GitHub
//
//    O Docker Hub permite vincular repositórios do GitHub para automatizar a criação e a atualização de imagens Docker a partir de Dockerfiles presentes no GitHub. Isso simplifica o processo de integração contínua e entrega contínua (CI/CD) para projetos baseados em contêineres.
//    Automatização de build
//
//    É possível configurar builds automatizadas para suas imagens Docker no Docker Hub. Isso significa que sempre que houver uma alteração em um repositório vinculado a ela, uma nova imagem será construída automaticamente, garantindo que as versões mais recentes estejam sempre disponíveis.
//            Segurança
//
//    O Docker Hub oferece recursos de segurança, incluindo escaneamento de vulnerabilidades em imagens. Isso ajuda na identificação de potenciais vulnerabilidades em suas dependências de forma proativa.
//            Organização
//
//    É possível organizar suas imagens em repositórios e tags, facilitando a descoberta e a gestão de versões diferentes de uma mesma imagem.
//    Como o Docker Hub se integra ao fluxo de trabalho?
//    Publicação
//
//    Após criar e testar suas imagens Docker localmente, você pode publicá-las no Docker Hub para que outras pessoas possam acessá-las.
//            Compartilhamento
//
//    Ao trabalhar em um projeto, você pode compartilhar imagens Docker via Docker Hub, garantindo que todas as pessoas da equipe tenham acesso às versões mais recentes do projeto.
//    Integração com CI/CD
//
//    Configure pipelines de CI/CD para automatizar a construção e implantação de imagens Docker diretamente no Docker Hub, garantindo uma entrega contínua eficiente.


    //Deploy servidor

//    Resumo da Aula:
//
//    Nessa aula, aprendemos como fazer o deploy da nossa aplicação Java em um servidor de produção, utilizando o Docker e o Docker Compose.
//
//            Primeiro, modificamos o arquivo docker-compose.yml para que ele baixasse as imagens do Docker Hub, ao invés de construir as imagens localmente. Isso é importante para evitar ter que copiar todo o projeto para o servidor toda vez que houver uma atualização.
//
//    Em seguida, transferimos os arquivos docker-compose.yml e a pasta env (com as variáveis de ambiente) para o servidor de produção, utilizando o comando scp.
//
//    Depois, fizemos login no servidor via SSH, utilizando o comando ssh, e verificamos se os arquivos foram transferidos corretamente.
//
//    Por fim, subimos os containers utilizando o comando docker-compose up.
//
//    Comandos utilizados:
//
//    scp -i ~/key-pair.pem docker-compose.yml ec2-user@3.82.57.80:/home/ec2-user: Este comando copia o arquivo docker-compose.yml do seu computador para o diretório home do usuário ec2-user no servidor com o IP 3.82.57.80. O -i ~/key-pair.pem indica a chave privada que você usa para se conectar ao servidor.
//
//    scp -i ~/key-pair.pem -r env ec2-user@3.82.57.80:/home/ec2-user: Este comando copia a pasta env e todos os seus arquivos do seu computador para o diretório home do usuário ec2-user no servidor com o IP 3.82.57.80. O -r indica que você deseja copiar recursivamente, ou seja, copiar a pasta e todos os arquivos dentro dela.
//
//    ssh -i ~/key-pair.pem ec2-user@3.82.57.80: Este comando abre uma conexão SSH com o servidor, permitindo que você execute comandos diretamente no servidor.
//
//    docker-compose up: Este comando inicia os containers definidos no arquivo docker-compose.yml no servidor.
//
//    Lembre-se: É importante manter as variáveis de ambiente seguras e não incluí-las no projeto.



    //CI/CD
//
//    Já aprendemos como utilizar o Docker e o Docker Compose para empacotar, distribuir e executar nossa aplicação Java de maneira eficiente e consistente. Além disso, exploramos como realizar o deploy manual dessa aplicação em um servidor EC2 da AWS, e atualizamos manualmente as imagens Docker e executando o Docker Compose para implantar as novas versões.
//
//    No entanto, existe uma abordagem mais moderna e automatizada para realizar o deploy de nossa aplicação, conhecida como CI/CD (Integração Contínua e Entrega Contínua). Uma das ferramentas mais populares atualmente para implementar CI/CD é o GitHub Actions, oferecido diretamente pelo GitHub.
//
//    CI/CD
//    CI/CD é uma prática de desenvolvimento de software que visa automatizar o processo de integração, testes e entrega de código em ambientes de produção de forma rápida e confiável. Com CI/CD, as alterações no código são integradas e testadas automaticamente, garantindo que apenas o código funcional e testado seja entregue aos usuários finais.
//
//            GitHub Actions
//    O GitHub Actions oferece uma maneira flexível e integrada de automatizar fluxos de trabalho de desenvolvimento diretamente no GitHub. Com ele, podemos configurar pipelines de CI/CD que são acionados automaticamente por eventos como push de código, pull requests ou criação de tags. Isso significa que podemos automatizar completamente o processo de build, testes e deploy de nossas aplicações.
//
//            CI/CD com GitHub Actions e Docker Hub
//    Para implementar CI/CD para nossa aplicação Java usando o GitHub Actions, podemos seguir os seguintes passos:
//
//    Configurar um Workflow
//
//    Crie um arquivo YAML na pasta .github/workflows do seu repositório para definir o fluxo de trabalho do GitHub Actions. Este arquivo deve conter as instruções de todo o workflow que desejamos implementar.
//    Build e testes
//
//    Utilize os comandos necessários para construir a imagem Docker da aplicação e executar os testes automatizados.
//    Publicação no Docker Hub
//
//    Adicione passos ao workflow para fazer o login no Docker Hub e fazer o push da imagem da aplicação.
//            Deploy
//
//    Configure etapas adicionais para se conectar ao seu servidor EC2 e executar o Docker Compose para realizar o deploy da nova versão da aplicação.
//    Com esses passos configurados no GitHub Actions, cada vez que você fizer uma alteração no código e enviar para o repositório no GitHub, o GitHub Actions será acionado automaticamente, realizando o build, executando os testes automatizados, gerando a imagem docker da aplicação e a publicando no Docker Hub, e, por fim, realizando o deploy da aplicação de forma automatizada.
//
//    Ao automatizar o processo de CI/CD com o GitHub Actions e o Docker Hub, é possível acelerar significativamente o ciclo de desenvolvimento, garantindo assim uma entrega mais ágil e confiável de novas funcionalidades da aplicação.
//
//    No caso da aplicação utilizada do curso, esse seria um exemplo de como configurar todo o processo de deploy dela via GitHub Actions:


//    name: CI/CD with Docker and GitHub Actions
//
//    on:
//    push:
//    branches:
//            - main
//
//    jobs:
//    build:
//    runs-on: ubuntu-latest
//
//    steps:
//            - name: Checkout repository
//    uses: actions/checkout@v2
//
//    - name: Build Docker image
//    run: docker build -t aluracursos/codechella:latest .
//
//    - name: Log into Docker Hub
//    run: docker login -u aluracursos -p ${{ secrets.DOCKERHUB_TOKEN }}
//
//    - name: Push image to Docker Hub
//    run: docker push aluracursos/codechella:latest
//
//    deploy:
//    runs-on: ubuntu-latest
//
//    needs: build
//
//    steps:
//            - name: Install SSH key
//    uses: webfactory/ssh-agent@v0.5.3
//    with:
//    ssh-private-key: ${{ secrets.SSH_PRIVATE_KEY }}
//
//    - name: SSH into EC2 instance and update Docker Compose
//    run: |
//    ssh -o StrictHostKeyChecking=no ec2-user@IP_DO_SERVIDOR_EC2 "cd /home/ec2-user && docker-compose pull && docker-compose up -d"



//    No exemplo anterior, teremos o seguinte comportamento:
//
//    O fluxo de trabalho é acionado sempre que houver um push na branch main;
//    O primeiro job, chamado de build, é responsável por construir a imagem Docker, fazer login no Docker Hub (usando um token de acesso armazenado em secrets) e fazer push da imagem para o Docker Hub;
//    O segundo job, chamado de deploy, depende do job build e é responsável por implantar a aplicação no servidor EC2. Ele instala uma chave SSH (armazenada em secrets) para acessar o servidor EC2 e, em seguida, executa comandos remotos via SSH para atualizar o Docker Compose e reiniciar os contêineres via docker compose.
//    Se você quiser conhecer mais sobre como configurar pipelines de CI/CD com o GitHub Actions, recomendamos explorar a sua documentação oficial.
//
//    https://docs.github.com/pt/actions



    //ec2 amazon
//
//    Caso você queira realizar o deploy da aplicação de maneira similar à que mostrada nesta aula, vai precisar criar uma instância EC2 na AWS. Para isso, será necessário que você tenha uma conta na AWS.
//
//    Execute os seguintes passos para tal objetivo:
//
//    Crie uma nova instância EC2 na AWS, do tipo Amazon Linux;
//    Copie para a instância, via SCP, o arquivo docker-compose.yml e o diretório env contendo os arquivo app.env e mysql.env;
//    Acesse a instância, via SSH, e instale nela o Docker e o Docker Compose;
//    Execute o Docker Compose para iniciar os containers da aplicação e do banco de dados.
//            ATENÇÃO! Ao criar a instância EC2 atente-se ao AMI (Amazon Machine Image) e ao tipo de instância, escolhendo opções que estejam marcadas como Free tier eligible, que são opções gratuitas e que não vão gerar custos na sua conta AWS.
//
//    Caso você tenha alguma dificuldade, veja na seção Opinião do instrutor o passo a passo de como realizar tais procedimentos.



//    Nesta aula, você aprendeu:
//    A realizar o build de uma aplicação Java utilizando o Maven no IntelliJ e também via terminal;
//    A adicionar o Docker na aplicação, via criação do arquivo Dockerfile no diretório raiz do projeto;
//    Como funciona o build e execução de uma aplicação Java utilizando o Docker;
//    A utilizar o Docker Compose para gerenciar múltiplos containers Docker;
//    Como configurar o Docker Compose via arquivo docker-compose.yml;
//    A realizar o deploy da aplicação em um servidor EC2 na AWS, via conexão SSH.
}
