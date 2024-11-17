package com.jefferson.anotacoes;

public class Escabilidade {

    //Disponibilidade e escabilidade

//    Além de otimizar a performance do banco de dados, é importante pensar em outras preocupações de arquitetura como disponibilidade e escalabilidade.
//    Mesmo com melhorias na camada de persistência, se houver um pico de acesso, a aplicação pode ficar indisponível se estiver rodando em apenas um servidor.
//    Existem duas formas de escalar a aplicação:
//    Escalabilidade vertical: Aumentar os recursos do servidor (mais CPU, memória, etc).
//    Escalabilidade horizontal: Adicionar mais servidores para distribuir a carga.
//    A escalabilidade horizontal, com o uso de balanceamento de carga pelo NGINX, é a melhor opção para garantir a disponibilidade da aplicação.
//    O projeto atual não possui essas características de escalabilidade, rodando em apenas uma máquina. Será necessário alterar a arquitetura para utilizar Docker e escalar horizontalmente.
//    O foco da aula foi mostrar a importância de pensar em disponibilidade e escalabilidade, além da otimização do banco de dados, para construir uma aplicação robusta e preparada para lidar com picos de acesso.



//    O objetivo é escalar a aplicação, aumentando a disponibilidade e a performance, através da adição de uma segunda instância da API.
//    Para isso, foram feitas as seguintes alterações na configuração do Docker Compose:
//    Adicionada uma segunda instância da aplicação, chamada app-2, que herda as mesmas configurações da app-1.
//    No serviço do Nginx, foi alterado o depends_on para incluir as duas instâncias da aplicação (app-1 e app-2).
//    No arquivo de configuração do Nginx (nginx.conf), foram feitas as seguintes alterações:
//    Criado um bloco upstream chamado servers, que define as duas instâncias da aplicação (app-1 e app-2).
//    No bloco server, o proxy_pass foi alterado para referenciar o upstream servers ao invés de uma única instância da aplicação.
//    Dessa forma, o Nginx agora faz o balanceamento de carga entre as duas instâncias da aplicação, usando a estratégia Round Robin.
//    Essa configuração permite que a aplicação seja escalada horizontalmente no futuro, adicionando mais instâncias conforme a necessidade.



    //
    //Para saber mais: limitando recursos dos containers


//    No curso, foi utilizado o Docker e o Docker Compose para criar uma infraestrutura de containers composta pelo Nginx, atuando como balanceador de carga, duas instâncias da aplicação, um servidor Redis para cache e o banco de dados MySQL. No entanto, não foi configurada nenhuma limitação quanto ao uso de CPU e memória de tais containers.
//
//    É importante ressaltar que não limitar os recursos dos containers não é uma prática recomendada, pois sem limites, eles podem consumir todos os recursos disponíveis no host, o que pode levar a problemas de desempenho e até mesmo à paralisação do sistema como um todo.
//
//    Limitar os recursos dos containers é essencial para garantir um ambiente de execução estável e previsível. Ao definir limites para CPU e memória, você evita que um único container monopolize todos os recursos do host, garantindo que outros containers e aplicativos em execução no mesmo host continuem funcionando de forma adequada.
//
//    Limitando recursos
//    No Docker, é possível limitar os recursos de CPU e memória de um contêiner usando as opções --cpu e --memory ao criar ou executar um container. Por exemplo, para limitar um container a utilizar no máximo 1 núcleo de CPU e 512MB de memória, você pode usar o seguinte comando:
//
//    docker run --cpu 1 --memory 512m nginx
//    Copiar código
//    Também é possível definir limites de recursos no arquivo docker-compose.yml usando as opções cpu_limit e mem_limit:
//
//    redis:
//    image: redis:7.2.4
//    restart: unless-stopped
//    deploy:
//    resources:
//    limits:
//    cpus: '1'
//    memory: 512M
//    Copiar código
//    Ao definir esses limites, você garante que cada container tenha acesso apenas aos recursos especificados, impedindo que eles afetem negativamente o desempenho de outros containers e aplicativos em execução no mesmo host.



    //Para saber mais: métodos de balanceamento de carga

//    No curso, aprendemos como utilizar o Nginx como servidor de proxy reverso para balancear a carga entre diferentes instâncias da aplicação. Uma configuração básica foi realizada com duas instâncias da aplicação sendo executadas e o Nginx distribuindo as requisições entre elas. No entanto, não foi configurada explicitamente a estratégia de balanceamento de carga, resultando na utilização da estratégia padrão de round-robin.
//
//    Estratégias de balanceamento de carga
//    O Nginx suporta diversas estratégias de balanceamento de carga, permitindo personalizar o comportamento de distribuição das requisições entre os servidores backend. Algumas das estratégias mais comuns são:
//
//    Round Robin: Esta é a estratégia padrão do Nginx. O Nginx distribui as requisições de forma sequencial entre os servidores backend, garantindo que cada servidor receba uma quantidade igual de requisições ao longo do tempo.
//
//            Least Connections (Menor número de conexões): Esta estratégia direciona as requisições para o servidor com o menor número de conexões ativas no momento. É útil quando os servidores backend têm capacidades diferentes ou quando o tempo de resposta pode variar entre os servidores.
//
//    IP Hash (Hash do endereço IP do cliente): Com esta estratégia, o Nginx calcula um hash do endereço IP do cliente e usa esse valor para determinar para qual servidor enviar a requisição. Isso garante que todas as requisições de um mesmo cliente sejam enviadas para o mesmo servidor, útil para manter a consistência em aplicações que requerem sessões persistentes.
//
//    Least Time (Menor tempo de resposta): O Nginx direciona as requisições para o servidor que teve o menor tempo de resposta em um determinado período de tempo. Esta estratégia é útil para otimizar o desempenho da aplicação, enviando requisições para os servidores mais rápidos disponíveis.
//
//    Exemplo de configuração
//    A configuração da estratégia de balanceamento de carga é feita no arquivo de configuração do Nginx. A seguir temos um exemplo de como configurar a estratégia de balanceamento de carga Least Connections:



//    upstream servers {
//        least_conn;
//        server app-1:8080 weight=1;
//        server app-2:8080 weight=2;
//    }
//
//    server {
//        listen 80;
//        location / {
//                proxy_pass http://servers;
//        proxy_set_header Host $host;
//        proxy_set_header X-Real-IP $remote_addr;
//        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
//        proxy_set_header X-Forwarded-Proto $scheme;
//
//        add_header X-Backend-Server $upstream_addr;
//
////  }
//    }

//    Neste exemplo anterior, configuramos a estratégia least_conn para distribuir as requisições para o servidor com o menor número de conexões ativas no momento. Os servidores app-1 e app-2 são especificados dentro da diretiva upstream, com weight=1 atribuído ao primeiro servidor e weight=2 atribuído ao segundo servidor, indicando que o segundo servidor deve receber o dobro de requisições em comparação ao primeiro devido ao seu maior peso.
//
//    Escolhendo a estratégia adequada
//    A escolha da estratégia de balanceamento de carga depende das características específicas da aplicação e dos requisitos de desempenho. É importante considerar fatores como a carga de trabalho esperada, a capacidade dos servidores backend, o tempo de resposta desejado e a necessidade de persistência de sessão ao selecionar a estratégia mais adequada.
//
//    Ao experimentar diferentes estratégias de balanceamento de carga e ajustar as configurações conforme necessário, é possível otimizar o desempenho da aplicação e garantir uma distribuição eficiente das requisições entre os servidores backend.


    //Testando a escabilidade

//    Foi feita uma configuração no Nginx para adicionar um cabeçalho X-Backend-Server na resposta, mostrando o endereço IP do servidor que processou a requisição. Isso permite identificar qual instância da aplicação está respondendo.
//
//    Foram subidos dois containers da aplicação usando o Docker Compose, simulando duas instâncias da API.
//
//    Foram feitas requisições usando o Curl para verificar o balanceamento de carga, observando os diferentes endereços IP nos cabeçalhos das respostas.
//
//    Para testar a alta disponibilidade, um dos containers da aplicação foi parado. As requisições continuaram sendo respondidas pelo container restante, demonstrando que o Nginx detectou a queda de um servidor e passou a encaminhar as requisições apenas para o servidor ativo.
//
//    Apesar de ter sido usado apenas um servidor físico no exemplo, em um ambiente real cada instância da aplicação deve rodar em máquinas separadas para ter uma escalabilidade e disponibilidade verdadeiras.
//
//    Foi mencionado que haverá uma atividade "Para Saber Mais" sobre como configurar o Docker para rodar containers em máquinas separadas, utilizando ferramentas como Docker Swarm e Kubernetes.





    //Para saber mais: Docker Swarm e Kubernetes

//    No curso, todo o deploy e configuração da infraestrutura da aplicação foi feito em uma única instância EC2 da AWS. Foi mencionado que essa abordagem foi utilizada para fins didáticos, porém, em um ambiente real, o ideal seria que cada container estivesse em um servidor distinto, para mitigar o risco de toda a aplicação ficar fora do ar caso ocorra algum problema com o servidor EC2.
//
//    Uma alternativa viável para alcançar esse nível de distribuição e escalabilidade é utilizar ferramentas de orquestração de containers, como o Docker Swarm e o Kubernetes.
//
//    Docker Swarm
//    O Docker Swarm é uma ferramenta de orquestração de containers nativa do Docker, projetada para simplificar o processo de implantação, escalonamento e gerenciamento de aplicações distribuídas em um cluster de hosts Docker. Com o Docker Swarm, é possível agrupar vários hosts Docker em um cluster e realizar o deploy de aplicações em containers de forma transparente, distribuindo a carga de trabalho entre os nós do cluster.
//
//    O Docker Swarm foi projetado para ser simples de usar e integrar-se perfeitamente ao ecossistema Docker existente. É uma escolha popular para equipes que estão começando com a orquestração de containers ou que preferem uma solução mais simples e direta.
//
//            Kubernetes
//    Kubernetes, também conhecido como K8s, é uma plataforma de código aberto para automatizar o deploy, o escalonamento e a operação de aplicações em containers. Desenvolvido pelo Google e lançado como projeto de código aberto em 2014, o Kubernetes oferece recursos avançados de gerenciamento de containers, incluindo escalonamento automático, auto-recuperação, atualizações de aplicações sem tempo de inatividade e muito mais. Kubernetes é amplamente adotado pela comunidade de desenvolvimento de software e é considerado uma solução robusta para ambientes de produção.
//
//    O Kubernetes oferece recursos mais avançados e flexibilidade para ambientes de produção complexos. Com sua arquitetura altamente escalável e extensível, Kubernetes é amplamente adotado por empresas de todos os tamanhos para implantar e gerenciar aplicações em containers em alta escala.


//https://cursos.alura.com.br/formacao-kubernetes




    //Para saber mais: metodologia Twelve-Factor App
    //https://12factor.net/pt_br/


    //A metodologia Twelve-Factor App é um conjunto de práticas recomendadas para o desenvolvimento de aplicações modernas, projetada para criar sistemas robustos, escaláveis e fáceis de manter.
    //
    //Foi criada por Adam Wiggins em 2011 e tem como objetivo fornecer um conjunto de princípios que abordam diferentes aspectos do desenvolvimento de software, desde a arquitetura da aplicação até a implantação e operação em escala.
    //
    //Princípios
    //A metodologia Twelve-Factor App é dividida em 12 princípios:
    //
    //Codebase (Código-fonte único): Uma aplicação deve ser armazenada em um único repositório de código, com múltiplas implantações derivadas do mesmo código-base.
    //
    //Dependencies (Dependências explícitas): Todas as dependências da aplicação, incluindo bibliotecas e ferramentas de sistema, devem ser declaradas explicitamente e gerenciadas de forma isolada.
    //
    //Config (Configurações): As configurações da aplicação devem ser armazenadas em variáveis de ambiente, não no código-fonte, para permitir a configuração flexível em diferentes ambientes.
    //
    //Backing Services (Serviços de Back-end): Os serviços de back-end, como bancos de dados e filas, devem ser tratados como recursos externos, acessíveis por meio de interfaces padrão.
    //
    //Build, Release, Run (Construir, entregar, executar): O processo de build, entrega e execução da aplicação deve ser separado em etapas distintas, com cada etapa tendo suas próprias responsabilidades e garantindo a consistência entre ambientes.
    //
    //Processes (Processos): As aplicações devem ser executadas como processos independentes, leves e sem estado (Stateless), para facilitar a escalabilidade e a resiliência.
    //
    //Port Binding (Ligação de porta): As aplicações devem ser autocontidas e expor serviços por meio de portas, para que possam ser facilmente conectados a outras aplicações e serviços.
    //
    //Concurrency (Concorrência): As aplicações devem escalar horizontalmente, adicionando instâncias concorrentes para lidar com cargas de trabalho aumentadas.
    //
    //Disposability (Descartabilidade): As aplicações devem ser fáceis de iniciar e parar rapidamente, sem impacto para outras partes do sistema, para facilitar o deploy e a atualização contínua.
    //
    //Dev/Prod Parity (Paridade dev/prod): Os ambientes de desenvolvimento, testes e produção devem ser o mais semelhantes possível, para minimizar diferenças e evitar problemas de compatibilidade.
    //
    //Logs (Registros): As aplicações devem produzir logs estruturados e acessíveis por meio de interfaces padronizadas, para facilitar a depuração e o monitoramento.
    //
    //Admin Processes (Processos de administração): As tarefas administrativas, como migrações de banco de dados e limpeza de caches, devem ser executadas como processos únicos e rastreáveis.
    //
    //Motivação
    //A metodologia Twelve-Factor App foi desenvolvida como resposta aos desafios enfrentados pelos times de desenvolvimento de software ao criar e realizar deploy de aplicações em ambientes de computação em nuvem. Até então, muitas práticas de desenvolvimento de software estavam enraizadas em abordagens monolíticas e tradicionais, que não se adequavam às demandas de agilidade, escalabilidade e resiliência exigidas por aplicações distribuídas e em ambientes cloud.
    //
    //A necessidade de uma metodologia mais moderna e flexível se tornou evidente à medida que as equipes de desenvolvimento buscavam maneiras de criar aplicações que pudessem ser facilmente escaladas e mantidas em ambientes de produção dinâmicos, com mudanças e evoluções constantes.
    //
    //Importância
    //A metodologia Twelve-Factor App é essencial para projetar arquiteturas escaláveis, pois fornece diretrizes claras para criar aplicações modulares, flexíveis e fáceis de escalar. Ao adotar os princípios dessa metodologia, as equipes de desenvolvimento podem garantir que suas aplicações sejam projetadas com escalabilidade em mente desde o início, facilitando a adaptação a picos de demanda e suportando um crescimento contínuo de usuários.
    //
    //Além disso, as aplicações são mais fáceis de manter, atualizar e operar em produção, reduzindo a complexidade e os custos operacionais ao longo do tempo.



    //links

    //https://docs.docker.com/
    //https://docs.aws.amazon.com/pt_br/AWSEC2/latest/UserGuide/concepts.html



//    Nesta aula, você aprendeu:
//    Os conceitos de escalabilidade e disponibilidade em uma arquitetura de software;
//    As diferenças entre escalabilidade vertical e horizontal;
//    Como aplicar escalabilidade horizontal em nossa arquitetura, configurando no arquivo docker-compose.yml a aplicação para executar em duas instâncias;
//    Como configurar o nginx para realizar o balanceamento de carga, distribuindo as requisições entre as duas instâncias da aplicação;
//    A testar a escalabilidade e o balanceamento de carga, checando qual instância da aplicação está recebendo as requisições, com a utilização de um cabeçalho HTTP;
//    A testar a disponibilidade da aplicação, derrubando de maneira proposital uma das instâncias da aplicação e verificando se a outra instância passa a receber todas as próximas requisições.




}
