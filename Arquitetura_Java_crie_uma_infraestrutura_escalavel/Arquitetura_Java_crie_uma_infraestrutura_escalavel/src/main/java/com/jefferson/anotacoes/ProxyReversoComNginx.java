package com.jefferson.anotacoes;

public class ProxyReversoComNginx {

    //Acessando a aplicação
//
//    Essa aula é super importante para entendermos como acessar nossa aplicação Java que está rodando em um servidor de produção, como a Amazon.
//
//    O problema é que não podemos simplesmente digitar localhost:8080 no navegador, pois isso tentaria acessar a aplicação no nosso próprio computador, e não no servidor.
//
//    A solução é usar um proxy reverso, que é como um intermediário entre o usuário e a aplicação. Ele recebe as requisições do usuário e as encaminha para a aplicação na porta correta.
//
//    O NGINX é uma ferramenta popular para configurar um proxy reverso. Ele escuta as requisições na porta 80 (ou 443 para HTTPS) e as encaminha para a nossa aplicação na porta 8080.
//
//    Na próxima aula, vamos configurar o NGINX no Docker para que ele funcione como um proxy reverso para nossa aplicação!


    //Saber mais DNS

//    No curso, aprendemos como acessar o servidor EC2 da AWS através de seu endereço IP público. No entanto, também mencionamos que é possível acessar o servidor usando um nome de domínio, conhecido como Sistema de Nomes de Domínio (DNS). Vamos explorar um pouco mais sobre como o DNS funciona e como podemos acessar servidores utilizando um DNS.
//
//    O que é DNS?
//    O DNS é um sistema hierárquico e distribuído que traduz nomes de domínio legíveis por pessoas, como "alura.com.br", em endereços IP numéricos, como "137.44.2.128". Isso permite que as pessoas acessem sites na internet usando nomes de domínio fáceis de lembrar, em vez de terem que memorizar endereços IP complexos.
//
//    Como funciona o DNS?
//    Consulta de Resolução:
//
//    Quando você digita um nome de domínio em seu navegador, ele inicia uma consulta de resolução DNS para traduzir esse nome de domínio em um endereço IP. Ele começa consultando um servidor DNS local configurado em seu sistema.
//    Caching e Hierarchy
//
//    Se o servidor DNS local não tiver o mapeamento de nome para IP em seu cache, ele encaminha a consulta para servidores DNS de nível superior, como servidores raiz, servidores de domínio de nível superior (TLD) e servidores autoritativos, seguindo uma hierarquia até encontrar o servidor autoritativo responsável pelo domínio específico.
//    Resposta e cache
//
//    Uma vez que o servidor DNS autoritativo é encontrado, ele responde à consulta com o endereço IP correspondente, que é então enviado de volta ao navegador. Além disso, o servidor DNS local armazena o resultado em seu cache para consultas futuras, melhorando a eficiência e reduzindo a latência.
//    Acessando Servidores via DNS
//    Agora que entendemos como funciona o DNS, vamos explorar como podemos acessar servidores EC2 da AWS via DNS:
//
//    Configuração de registro DNS
//
//    Para acessar um servidor EC2 via DNS, é necessário configurar um registro DNS que associe um nome de domínio legível por pessoas ao endereço IP público do servidor EC2. Isso pode ser feito através do provedor de registro de domínio ou serviço de hospedagem DNS que você estiver utilizando.
//    Atualização do registro DNS
//
//    Uma vez configurado, o registro DNS precisa ser atualizado sempre que o endereço IP público do servidor EC2 for alterado. Isso pode ocorrer, por exemplo, ao parar e iniciar a instância EC2, ou se você estiver usando um endereço IP elástico (EIP) e o realocar para outra instância.
//    Acesso por nome de domínio
//
//    Depois que o registro DNS estiver configurado e atualizado, você pode acessar seu servidor EC2 usando o nome de domínio associado, em vez do endereço IP público. Por exemplo, em vez de digitar "http://137.44.2.128", você pode digitar "http://seu-nome-de-domínio.com".
//    DNS padrão da AWS
//    Além de configurar um registro DNS personalizado, a AWS fornece automaticamente um nome de domínio público para cada instância EC2. Esse nome de domínio segue o padrão ec2-[seu-endereço-ip].compute.amazonaws.com. Por exemplo, se o endereço IP público de sua instância EC2 for 137.44.2.128, o nome de domínio público associado seria ec2-137-44-2-128.compute.amazonaws.com.
//
//    Esse nome de domínio padrão pode ser utilizado para acessar sua instância EC2 via DNS sem a necessidade de configurar registros DNS adicionais. No entanto, é importante notar que esse nome de domínio pode não ser tão amigável quanto um domínio personalizado e pode ser menos prático para os usuários finais. Portanto, em muitos casos, é preferível configurar um registro DNS personalizado para facilitar o acesso à sua instância EC2 por meio de um nome de domínio mais fácil de lembrar e usar.
//
//    Caso queira aprender mais sobre DNS e outros recursos relacionados com redes de computadores, recomendamos fazer a Formação Redes de computadores.


    //Adicionando ngnix

//    Nessa aula, aprendemos como configurar um proxy reverso com o Nginx, utilizando o Docker. O Nginx atuará como um intermediário entre o navegador e a nossa aplicação, recebendo as requisições e direcionando-as para a aplicação.
//
//    Para isso, seguimos os seguintes passos:
//
//    Parar os contêineres: docker-compose down - Esse comando interrompe todos os contêineres que estão em execução, incluindo a aplicação e o banco de dados.
//
//    Editar o arquivo docker-compose.yml: vim docker-compose.yml - O Vim é um editor de texto de linha de comando, que permite editar o arquivo docker-compose.yml diretamente no terminal.
//
//    Adicionar o serviço Nginx: Dentro do arquivo docker-compose.yml, adicionamos um novo serviço chamado nginx, utilizando a imagem nginx:stable-alpine do Docker Hub.
//
//    Configurar a porta do Nginx: Definimos o parâmetro ports para o serviço nginx, vinculando a porta 80 do host (servidor de produção) à porta 80 do contêiner Nginx.
//
//    Iniciar os contêineres: docker-compose up - Esse comando inicia os contêineres, incluindo o novo contêiner do Nginx.
//
//    Testar o Nginx: Acessamos o endereço IP do servidor na porta 80 (http://3.82.57.80) e verificamos se a página de boas-vindas do Nginx é exibida.
//
//    Com esses passos, configuramos o Nginx como um servidor web convencional, recebendo as requisições na porta 80. No entanto, ainda não configuramos o modo de proxy reverso, que é o objetivo final.
//
//    Na próxima aula, aprenderemos como configurar o Nginx para atuar como um proxy reverso, direcionando as requisições para a nossa aplicação.
//
//            Lembre-se que o Nginx é uma ferramenta poderosa que pode melhorar a segurança, o desempenho e a escalabilidade da sua aplicação.

    //código

//    nginx:
//    image: nginx:stable-alpine
//    ports:
//            -"80:80"



    //configurando ngnix
//
//    aprendemos a configurar o NGINX para funcionar como um proxy reverso, direcionando as requisições do navegador para a nossa aplicação Spring.
//
//    Para isso, seguimos alguns passos:
//
//    Criamos um arquivo de configuração para o NGINX:
//
//    mkdir nginx: Criamos uma pasta chamada "nginx" para armazenar as configurações do NGINX.
//    cd nginx: Entramos na pasta "nginx".
//    vim nginx.conf: Criamos um arquivo chamado "nginx.conf" para configurar o NGINX.
//    Configuramos o arquivo "nginx.conf":
//
//    server { ... }: Definimos um servidor NGINX.
//
//    listen 80: Indicamos que o servidor deve escutar na porta 80.
//
//    server_name app: Definimos o nome do servidor como "app".
//
//    location / { ... }: Definimos o comportamento do servidor para qualquer URL.
//
//    proxy_pass http://app:8080;: Indicamos que o NGINX deve encaminhar as requisições para a aplicação na porta 8080.
//
//    proxy_set_header ...: Configuramos os cabeçalhos das requisições para garantir que a aplicação receba as informações corretas.
//
//    Atualizamos o arquivo "docker-compose.yml":
//
//    volumes: - ./nginx:/etc/nginx/conf.d: Indicamos que a pasta "nginx" do nosso servidor deve ser mapeada para a pasta "/etc/nginx/conf.d" dentro do container do NGINX.
//            restart: unless-stopped: Configuramos o container do NGINX para reiniciar automaticamente caso ele pare, a menos que seja encerrado manualmente.
//    depends_on: - app: Indicamos que o container do NGINX depende do container da aplicação, garantindo que a aplicação seja iniciada antes do NGINX.
//
//    Executamos o Docker Compose:
//
//    docker-compose up: Iniciamos os containers do Docker.
//
//    Com essas configurações, o NGINX agora funciona como um proxy reverso, recebendo as requisições do navegador e encaminhando-as para a nossa aplicação Spring.


    //arquivo

//    //ngnix.conf
//
//    server {
//        listen 80;
//        server_name app;
//
//        location / {
//                proxy_pass http://app:8080;
//        proxy_set_header Host $host;
//        proxy_set_header X-Real-IP $remote_addr;
//        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
//        proxy_set_header X-Forwarded-Proto $scheme;
//    }
//    }


    //docker compose

//
//    nginx:
//    image: nginx:stable-alpine
//    ports:
//            - "80:80"
//    volumes:
//            - ./nginx:/etc/nginx/conf.d
//    restart: unless-stopped
//    depends_on:
//            - app




    //proxy saber mais

//    No curso, foi ensinado como configurar e utilizar o Nginx como uma ferramenta de proxy reverso para rotear as requisições de clientes para servidores backend. Vamos abordar neste para saber mais as diferenças entre um proxy comum e um proxy reverso.
//
//    O que é um proxy?
//    Um proxy é um intermediário entre um cliente e um servidor, atuando como um gateway que encaminha requisições do cliente para o servidor e, em seguida, retorna as respostas do servidor para o cliente. Os proxies são comumente usados para várias finalidades, incluindo anonimato na internet, controle de acesso, otimização de performance e segurança.
//
//    Quando um cliente envia uma requisição para um servidor por meio de um proxy, o proxy intercepta a requisição e a encaminha para o servidor. O servidor, por sua vez, processa a requisição e envia a resposta de volta ao proxy, que então a repassa para o cliente. O cliente geralmente não está ciente da presença do proxy e a comunicação entre o cliente e o servidor é transparente.
//
//    O que é um proxy reverso?
//    Um proxy reverso é um tipo específico de proxy que opera no lado do servidor, em vez do lado do cliente. Em vez de encaminhar requisições de clientes para servidores, um proxy reverso recebe requisições de clientes e as encaminha para servidores backend com base em regras de roteamento predefinidas. Depois que o servidor backend processa a requisição, o proxy reverso retorna a resposta ao cliente.
//
//    Diferenças entre proxy e proxy reverso
//    A principal diferença entre um proxy comum e um proxy reverso está na direção do tráfego. Um proxy convencional encaminha requisições de clientes para servidores, enquanto um proxy reverso recebe requisições de clientes e as encaminha para servidores backend. Além disso, os proxies convencionais são geralmente usados para finalidades como anonimato na internet e controle de acesso, enquanto os proxies reversos são comumente utilizados para balanceamento de carga, cache de conteúdo e segurança.




    //Para saber mais: HTTPS com certificado digital


//    No curso, aprendemos como configurar o Nginx como um proxy reverso para encaminhar todas as requisições na porta 80 do servidor EC2 para a aplicação Java que está rodando na porta 8080. No entanto, apenas o protocolo HTTP está sendo utilizado, o que significa que a comunicação entre o cliente e o servidor não está criptografada.
//
//    O que é HTTPS?
//    O HTTPS (Hypertext Transfer Protocol Secure) é uma extensão do protocolo HTTP que utiliza criptografia para proteger a comunicação entre o cliente e o servidor. Isso é feito por meio da utilização de um certificado digital SSL/TLS, que autentica o servidor para o cliente e estabelece uma conexão segura.
//
//    Como funciona o HTTPS com Certificado Digital?
//    Aquisição do certificado digital
//
//    Para habilitar o HTTPS em um servidor, é necessário adquirir um certificado digital SSL/TLS de uma Autoridade Certificadora (CA) confiável. Isso geralmente envolve a geração de uma solicitação de assinatura de certificado (CSR) e o envio desta solicitação para a CA, que então emite o certificado. É possível obter um certificado digital de maneira gratuita, utilizando o serviço Let's Encrypt. //https://letsencrypt.org/pt-br/
//    Configuração do servidor
//
//    Uma vez obtido o certificado digital, ele precisa ser instalado no servidor. Isso geralmente envolve a configuração do servidor web (como o Nginx) para utilizar o certificado e habilitar o HTTPS. O certificado digital contém informações sobre o domínio, a chave pública do servidor e outras informações necessárias para estabelecer uma comunicação segura.
//    Comunicação Segura
//
//    Quando um cliente faz uma requisição HTTPS para o servidor, o servidor responde com seu certificado digital. O cliente então verifica o certificado para garantir que ele seja válido e confiável. Em seguida, o cliente e o servidor negociam uma chave de sessão segura para criptografar toda a comunicação subsequente.
//    Implementação do HTTPS no Nginx
//    Para habilitar o HTTPS no Nginx e configurar o certificado digital, podemos seguir estes passos:
//
//    Instalação do certificado no Nginx
//
//    Configure o Nginx para usar o certificado digital e habilitar o HTTPS. Isso envolve a adição de diretivas de configuração no arquivo de configuração do Nginx para especificar o caminho para o certificado e a chave privada.
//    Redirecionamento de HTTP para HTTPS
//
//    Adicione uma regra de redirecionamento no Nginx para direcionar automaticamente todas as requisições HTTP para HTTPS, garantindo que toda a comunicação seja criptografada.
//    No caso do projeto utilizado no curso, aqui está um exemplo de como configurar o nginx para utilizar o HTTPS:

    //arquivo: ngnix.conf

//    server {
//        listen 80;
//        server_name app;
//
//        location / {
//        return 301 https://$host$request_uri;
//    }
//    }
//
//    server {
//        listen 443 ssl;
//        server_name app;
//
//        ssl_certificate /etc/nginx/certificates/certificado.crt;
//        ssl_certificate_key /etc/nginx/certificates/chave.key;
//
//        location / {
//                proxy_pass http://app:8080;
//        proxy_set_header Host $host;
//        proxy_set_header X-Real-IP $remote_addr;
//        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
//        proxy_set_header X-Forwarded-Proto $scheme;
//    }
//    }


    //explicação

//    No exemplo anterior, teremos o seguinte comportamento:
//
//    O primeiro bloco server redireciona todas as requisições HTTP para HTTPS utilizando um redirecionamento permanente (código de status 301);
//    O segundo bloco server escuta na porta 443 (porta padrão para HTTPS) e configura o certificado SSL/TLS e a chave privada para habilitar o HTTPS;
//    A diretiva proxy_pass, dentro da localização /, continua encaminhando as requisições para a aplicação Java que está rodando na porta 8080.
//    Com o HTTPS habilitado, toda a comunicação entre o cliente e o servidor será segura e criptografada, proporcionando maior segurança e privacidade para os usuários. Esta é a recomendação ao se realizar o deploy de uma aplicação em um ambiente de produção.

//    Caso você tenha criado uma instância EC2 na AWS, você pode acessá-la para adicionar um container nginx que vai atuar como proxy reverso da aplicação.
//
//    Execute os seguintes passos para tal objetivo:
//
//    Copie, via SCP, a pasta nginx, contendo o arquivo nginx.conf, para a sua instância EC2;
//    Acesse, via SSH, sua instância EC2;
//    Edite o arquivo docker-compose.yml adicionando o container nginx;
//    Reinicie o Docker Compose para que o container nginx seja criado.
//    Caso você tenha alguma dificuldade, veja na seção Opinião do instrutor o passo a passo de como realizar tais procedimentos.


//    Nesta aula, você aprendeu:
//    Como acessar a aplicação executando no servidor de produção, utilizando o navegador, por meio de seu endereço IP público;
//    Que a boa prática, no ambiente de produção, é não acessar a aplicação diretamente, mas sim via algum servidor configurado como proxy reverso;
//    A configurar o nginx como servidor de proxy reverso, executando na porta 80 e encaminhando as requisições para a aplicação, que está executando na porta 8080.



}
