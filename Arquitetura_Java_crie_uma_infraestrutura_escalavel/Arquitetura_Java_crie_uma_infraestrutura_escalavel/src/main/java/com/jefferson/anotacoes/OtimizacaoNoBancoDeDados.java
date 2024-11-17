package com.jefferson.anotacoes;

public class OtimizacaoNoBancoDeDados {

    //Pool de conexão

//    A aplicação está funcionando bem, mas pode haver problemas de performance em momentos de pico de acesso ou sobrecarga do servidor.
//    Uma das áreas críticas para performance é o acesso ao banco de dados.
//            Normalmente, a aplicação abre e fecha conexões com o banco de dados a cada requisição, o que é um processo custoso.
//    Para evitar isso, é importante utilizar o conceito de pool de conexões, mantendo um conjunto de conexões pré-estabelecidas.
//    O Spring Boot já utiliza uma biblioteca chamada HikariCP para gerenciar o pool de conexões automaticamente.
//    Porém, é possível ajustar algumas configurações do pool, como o número mínimo e máximo de conexões, timeouts, etc.
//    Não existe um valor ideal para essas configurações, é necessário testar e monitorar a aplicação para encontrar os melhores valores.
//    Ajustar o pool de conexões é uma otimização importante na camada de persistência da aplicação.


    //Observabilidade: saber mais

//    No curso, aprendemos a realizar ajustes na aplicação Java para melhorar sua performance, especialmente em relação ao acesso ao banco de dados, como utilizar um pool de conexões e criar índices em tabelas. No entanto, não exploramos como realizar um monitoramento eficaz da aplicação para identificar gargalos e pontos de melhoria. Foi mencionado que é crucial monitorar a aplicação para detectar pontos de gargalo de forma precisa, permitindo ajustes embasados em dados concretos, em vez de suposições, evitando assim a otimização desnecessária de partes da aplicação.
//
//    O que é Observabilidade?
//    Observabilidade é a capacidade de entender o estado interno de um sistema com base em informações externas. Em outras palavras, é a capacidade de observar, medir e entender como um sistema está funcionando internamente, especialmente em ambientes de produção, onde a complexidade e as interações são mais difíceis de entender apenas analisando o código.
//
//    O que é SRE?
//    SRE (Site Reliability Engineering) é uma prática que visa criar sistemas altamente confiáveis e escaláveis. Desenvolvida pelo Google, a SRE combina princípios de engenharia de software e operações para criar sistemas que são fáceis de manter e operar, mesmo em escala global. A observabilidade é um dos pilares fundamentais da prática SRE.
//
//    Como Monitorar uma aplicação?
//    Para monitorar uma aplicação e detectar problemas de performance, podemos seguir estas práticas:
//
//    Instrumentação de Código
//
//    Adicionar métricas e logs relevantes ao código da aplicação para registrar o desempenho, tempos de resposta, erros e outros eventos importantes. Isso pode ser feito usando bibliotecas de monitoramento como o Micrometer ou o SLF4J.
//    Monitoramento de Infraestrutura
//
//    Monitorar a infraestrutura subjacente onde a aplicação está sendo executada, incluindo recursos de hardware (CPU, memória, disco) e serviços de infraestrutura (banco de dados, cache, filas). Ferramentas como o Prometheus e o Grafana podem ser úteis para isso.
//    Análise de Logs
//
//    Analisar os logs da aplicação e da infraestrutura para identificar padrões, erros e anomalias que possam indicar problemas de performance. Ferramentas de análise de logs como o ELK Stack (Elasticsearch, Logstash, Kibana) podem ser utilizadas para essa finalidade.
//    Tracing de Requests
//
//    Utilizar o tracing de requests para rastrear o caminho de execução de uma requisição pela aplicação e identificar possíveis gargalos e latências. O Jaeger e o Zipkin são ferramentas populares para tracing em aplicações.
//    Com a observabilidade implementada na aplicação, podemos obter insights valiosos sobre o seu desempenho e comportamento em produção, permitindo-nos identificar e resolver problemas de performance de forma proativa, garantindo uma melhor experiência para os usuários finais.
//
//    Caso queira aprender mais sobre observabilidade, recomendamos fazer a Formação SRE.


    //Indices em tabelas

//    Aqui está um resumo da aula sobre otimizações no banco de dados:
//
//    Além do pool de conexões, outra forma de otimizar o acesso ao banco de dados é verificar se existem índices nas tabelas consultadas.
//    Índices em tabelas podem melhorar significativamente a performance de consultas, principalmente em tabelas com muitos registros.
//    No projeto da aplicação Codechella, a tabela de ingressos é uma boa candidata para adicionar índices, pois tende a ter muitos registros.
//    Analisando os métodos do IngressoRepository, identificamos que a coluna descricao pode ser uma boa candidata para criar um índice, pois é utilizada em consultas com filtros.
//    Criamos uma nova migração do Flyway para adicionar um índice na tabela de ingressos, usando as colunas evento_id e descricao.
//    Não existe uma resposta definitiva sobre onde criar índices, é necessário analisar o projeto, as consultas e o volume de dados para tomar essa decisão.
//    O monitoramento e testes de performance são essenciais para avaliar se a criação do índice realmente melhorou a performance da aplicação.

//    Quando criamos o índice na migração do Flyway, a estrutura da tabela de ingressos ficaria da seguinte forma:
//
//    sql
//     
//    CREATE TABLE ingressos (
//            id BIGINT AUTO_INCREMENT PRIMARY KEY,
//            evento_id BIGINT NOT NULL,
//            descricao VARCHAR(255) NOT NULL,
//    compra_id BIGINT,
//    FOREIGN KEY (evento_id) REFERENCES eventos(id),
//    FOREIGN KEY (compra_id) REFERENCES compras(id)
//            );
//
//    CREATE INDEX idx_ingressos_disponiveis ON ingressos(evento_id, descricao);
//    Nessa estrutura, temos:
//
//    A tabela ingressos com as colunas id, evento_id, descricao e compra_id.
//    As chaves estrangeiras evento_id e compra_id que fazem referência às tabelas eventos e compras, respectivamente.
//    O índice idx_ingressos_disponiveis criado na última linha, que abrange as colunas evento_id e descricao.
//    Esse índice vai ajudar a otimizar as consultas que filtram por evento_id e descricao, como os métodos temIngressoDisponivel() e buscarIngressosDisponiveis() do IngressoRepository.
//
//    Quando uma consulta for feita envolvendo essas colunas, o banco de dados poderá utilizar o índice para localizar os registros de forma mais eficiente, melhorando a performance da aplicação.


    //resumo chat
//
//    Um índice em um banco de dados é uma estrutura de dados que melhora a velocidade de consulta (leitura) ao permitir que o sistema de gerenciamento de banco de dados (SGBD) encontre dados mais rapidamente em uma tabela. Em essência, ele funciona como um índice em um livro: ao invés de procurar item por item no conteúdo da tabela, o índice permite encontrar rapidamente onde o dado está armazenado.
//
//    Como funciona o índice:
//    Estrutura de dados: Os índices são geralmente implementados usando estruturas de dados eficientes, como árvores B+ ou hashes. As mais comuns são as árvores B e árvores B+, pois elas permitem inserções, exclusões e buscas eficientes, mantendo o desempenho da consulta elevado.
//
//    Árvore B+: As chaves do índice são organizadas de maneira hierárquica. A cada consulta, o banco de dados percorre o índice da raiz até a folha para localizar o valor desejado.
//            Hashing: Os índices baseados em hash utilizam uma função de hash para mapear valores para locais específicos na memória, proporcionando uma busca muito rápida, mas não tão eficiente em casos onde a consulta envolve intervalos de valores.
//    Estrutura de um índice:
//
//    Chave: A chave do índice é baseada em uma ou mais colunas da tabela. Quando um índice é criado, o banco de dados armazena os valores dessas colunas junto com um ponteiro para a linha correspondente na tabela.
//            Ponteiros: São referências para as localizações físicas dos dados na tabela. Em vez de ter que procurar linha por linha na tabela, o índice permite acessar diretamente o local.
//            Benefícios do uso de índices:
//
//    Aumento de desempenho: Como mencionado, os índices tornam a busca de dados mais rápida, principalmente em tabelas grandes.
//    Busca rápida: Consultas com cláusulas WHERE, JOIN, ORDER BY e GROUP BY podem ser significativamente mais rápidas.
//    Facilidade em ordenação e filtragem: Índices são úteis quando há necessidade de ordenar ou filtrar dados frequentemente.
//    Desvantagens dos índices:
//
//    Uso de espaço: Índices ocupam espaço adicional no banco de dados, já que o SGBD precisa armazenar as chaves e os ponteiros.
//    Impacto na escrita: Cada vez que você insere, atualiza ou deleta uma linha na tabela, o índice também precisa ser atualizado. Isso pode levar a uma sobrecarga em operações de escrita (como inserções e deleções).
//    Exemplos de quando os índices são úteis:
//    Consulta de busca: Se você fizer uma consulta que envolve uma busca por um valor em uma coluna indexada, como:
//
//    sql
//     
//
//    SELECT * FROM clientes WHERE cpf = '12345678900';
//    O banco de dados pode usar o índice sobre a coluna cpf para localizar rapidamente a linha, em vez de percorrer todas as linhas da tabela.
//
//    Consultas com ORDER BY: Se você tiver um índice na coluna usada para ordenação, como:
//
//    sql
//     
//    SELECT * FROM produtos ORDER BY preco;
//    O banco de dados pode usar o índice para retornar os dados já ordenados, sem precisar ordenar as linhas manualmente após a leitura.
//
//    Como criar um índice:
//    Em bancos de dados relacionais como MySQL, PostgreSQL, Oracle, entre outros, um índice pode ser criado com a seguinte sintaxe SQL:
//
//    sql
//     
//    CREATE INDEX nome_do_indice
//    ON nome_da_tabela (coluna1, coluna2, ...);
//    Por exemplo, para criar um índice na coluna cpf da tabela clientes:
//
//    sql
//     
//
//    CREATE INDEX idx_cpf ON clientes (cpf);
//
//    Tipos comuns de índices:
//
//    Índice único (Unique Index): Garante que os valores em uma coluna ou combinação de colunas sejam exclusivos. Isso é útil para garantir integridade, como na coluna id de uma tabela.
//    Índice composto: É um índice que envolve múltiplas colunas. Pode ser usado quando você frequentemente faz consultas envolvendo várias colunas, como:
//
//    sql
//     
//    CREATE INDEX idx_nome_data ON clientes (nome, data_cadastro);
//    Índice full-text: Usado para buscas de texto completo, como quando você quer procurar palavras em colunas de texto grande (por exemplo, artigos ou posts).
//
//    Conclusão:
//    Índices são ferramentas poderosas para melhorar a performance de consultas em bancos de dados, mas é importante balancear o uso de índices com o custo em termos de armazenamento e performance de escrita. A escolha de quais colunas indexar depende do tipo de consultas que você costuma executar na tabela.





    //Para saber mais: analisando queries com explain analyze

//    Uma outra maneira de avaliar consultas no banco de dados é com a utilização dos comandos explain e explain analyze, que são suportados pelo MySQL e tem como objetivo fornecer informações sobre uma determinada query SQL.
//
//    O comando explain
//
//    O comando explain é uma ferramenta do MySQL, que também é suportada por alguns outros bancos de dados, que fornece informações detalhadas sobre como o otimizador de consultas do banco de dados executa uma determinada consulta SQL. Ao usar o comando explain, podemos visualizar o plano de execução de uma determinada consulta, incluindo quais índices estão sendo usados, quantas linhas estão sendo examinadas e outras métricas importantes.
//
//    Para utilizar esse comando, basta preceder a consulta que deseja analisar com a palavra-chave explain. Por exemplo:
//
//    explain select * from ingressos where descricao = 'CADEIRA';
//    Após executar o comando explain, o MySQL retornará uma tabela com várias colunas, cada uma fornecendo informações específicas sobre como a consulta será executada. Alguns dos campos mais importantes incluem:
//
//    select_type: O tipo de consulta que está sendo executada (por exemplo, SIMPLE para uma consulta simples ou SUBQUERY para uma subconsulta);
//    type: O tipo de junção usado para acessar a tabela (por exemplo, ALL para uma varredura de tabela completa ou INDEX para um acesso de índice);
//    rows: O número estimado de linhas que serão examinadas para executar a consulta;
//    key: O índice usado para acessar a tabela (se aplicável).
//    Ao analisar o resultado do comando explain, podemos identificar consultas que estão consumindo muitos recursos ou que poderiam ser executadas de forma mais eficiente. Por exemplo, consultas que exigem uma varredura de tabela completa (type = ALL) ou um número muito grande de linhas examinadas podem indicar oportunidades de otimização, como a criação de novos índices ou a revisão da estrutura da consulta.
//
//    O comando explain analyze
//
//    Outro comando complementar ao explain é o explain analyze, que executa a consulta e fornece informações sobre o tempo de execução de cada etapa do plano de execução. Isso permite uma análise mais detalhada do desempenho da consulta e pode nos ajudar a identificar gargalos de desempenho e otimizar consultas de forma mais eficaz.
//
//    explain analyze select * from ingressos where descricao = 'CADEIRA';
//
//    A diferença em relação a executar o comando apenas com o explain, é que ao utilizar o analyze, o MySQL executa a consulta e registra estatísticas detalhadas sobre cada etapa do plano de execução. Isso inclui informações como o tempo gasto em cada etapa, o número de linhas processadas e quaisquer operações adicionais realizadas, como classificações ou junções.
//
//    Podemos com isso identificar pontos críticos que afetam o desempenho da consulta, o que pode incluir operações de join ou classificação que exigem uma quantidade significativa de recursos, ou varreduras de tabela que processam um grande número de linhas desnecessariamente.
//
//    Ambos os comandos são excelentes ferramentas que podemos utilizar para analisar o desempenho de determinadas queries de nossa aplicação, nos auxiliando a identificar possíveis problemas que podem impactar a performance da aplicação.



    //ORM E SQL

//    Quando usamos frameworks como Spring Boot e JPA, eles abstraem o acesso ao banco de dados, então não precisamos mais escrever SQL manualmente.
//    Isso pode ser perigoso, pois não sabemos exatamente o que o framework está fazendo internamente em termos de consultas ao banco.
//    É importante habilitar os logs de SQL no application.properties para visualizar as consultas que estão sendo disparadas.
//    No exemplo da aula, ao fazer uma requisição para listar as compras de um usuário, foram disparadas 7 consultas SQL diferentes no banco de dados.
//    Isso pode ser um problema de performance, principalmente em ambientes de produção com muitos dados.
//    Nem sempre é possível trazer todos os dados em uma única consulta, mas é importante tentar minimizar o número de idas ao banco de dados.
//    Em desenvolvimento, pode parecer que tudo está funcionando bem, mas em produção, com mais dados, essas consultas podem ficar muito lentas.
//    O conselho é sempre avaliar as consultas nos logs e pensar em otimizações, como melhorar os relacionamentos entre as entidades.
//    O curso de Otimização de Aplicações Java na Alura aborda mais sobre como lidar com esses problemas de performance relacionados à persistência.




    //Para saber mais: consultas com operador like


//    No curso, aprendemos que algumas consultas SQL feitas pela aplicação podem causar problemas de performance, sendo crucial analisar as queries e realizar ajustes, se necessário. Especialmente quando se utiliza frameworks ORM, como o Hibernate e o Spring Data, que abstraem bastante o acesso ao banco de dados, gerando automaticamente as queries SQL.
//
//    Um exemplo comum de consulta que pode gerar problemas de performance são aquelas que utilizam o operador LIKE para filtrar por colunas do tipo VARCHAR. O operador LIKE é utilizado para buscar por padrões em strings, permitindo consultas flexíveis, mas pode ser custoso em termos de desempenho quando não utilizado de forma otimizada.
//
//    Problemas de performance com o operador LIKE
//    Consultas que utilizam o operador LIKE podem enfrentar os seguintes problemas de performance:
//
//    Escaneamento de Tabela Completa
//
//    Quando uma consulta utiliza o LIKE, o banco de dados pode ser forçado a realizar um escaneamento completo da tabela para buscar todas as linhas que correspondem ao padrão especificado, o que pode ser extremamente lento em tabelas com grande volume de dados.
//    Ausência de índices
//
//    Consultas com o operador LIKE podem não se beneficiar de índices existentes nas colunas, especialmente quando o padrão de busca começa com o caractere coringa %. Isso pode resultar em varreduras de tabela ineficientes.
//    Otimização de consultas com operador LIKE
//    Para otimizar consultas que utilizam o operador LIKE, podemos seguir estas práticas:
//
//    Utilizar prefixo adequado
//
//    Sempre que possível, evitar o uso do caractere coringa % no início do padrão de busca. Isso permite que o banco de dados utilize índices existentes para acelerar a busca.
//    Usar índices de texto completo
//
//    Em bancos de dados que suportam índices de texto completo, considerar a utilização desses índices para consultas que envolvem operações de busca de texto.
//    Limitar o escopo da consulta
//
//    Quando aplicável, limitar o escopo da consulta utilizando outras cláusulas de filtro para reduzir o número de linhas verificadas pelo operador LIKE.
//    Uma outra alternativa eficaz é criar uma nova coluna no banco de dados que armazena uma versão concatenada das colunas que são alvo da pesquisa. Por exemplo, se estivermos buscando por padrões nas colunas nome e email, podemos criar uma nova coluna busca_nome_email que contém a concatenação dessas duas colunas:
//
//    ALTER TABLE tabela ADD busca_nome_email VARCHAR(255) AS (CONCAT(nome, ' ', email)) STORED;
//     
//    Após criar essa nova coluna, podemos então criar um índice nela para acelerar as consultas que utilizam o operador LIKE:
//
//    CREATE INDEX idx_busca_nome_email ON tabela(busca_nome_email);
//     
//    Com essa nova coluna e o índice associado, podemos reformular a consulta para buscar diretamente na coluna concatenada, aproveitando os benefícios do índice:
//
//    SELECT *
//    FROM tabela
//    WHERE busca_nome_email LIKE '%termo_buscado%';
//    
//    Essa abordagem pode resultar em ganhos significativos de desempenho, especialmente em tabelas grandes, onde o escaneamento completo das colunas originais seria muito custoso em termos de desempenho.
//
//    Em alguns casos, pode ser mais eficiente utilizar outras técnicas de busca, como busca textual, dependendo dos requisitos da aplicação.
//
//    Com essas práticas de otimização, podemos melhorar significativamente o desempenho de consultas SQL que utilizam o operador LIKE, garantindo uma melhor experiência para os usuários finais e evitando problemas de escalabilidade em aplicações com grande volume de dados.



    //Para saber mais: réplica do banco para leitura

//    Já aprendemos algumas otimizações para melhorar o desempenho do banco de dados; no entanto, existe uma alternativa comum adicional para melhorar a performance: configurar uma réplica do banco de dados que será utilizada exclusivamente para leitura.
//
//    O que é uma réplica para leitura?
//    Uma réplica de banco de dados para leitura, também conhecida como réplica de leitura ou replicação de leitura, é uma cópia do banco de dados principal que é configurada especificamente para suportar operações de leitura, ou seja, consultas SQL utilizando a cláusula select.
//
//    Enquanto o banco de dados principal é responsável por lidar com operações de escrita, como inserções, atualizações e exclusões, a réplica de leitura é utilizada apenas para consultas de leitura, aliviando a carga do banco de dados principal e melhorando o desempenho geral do sistema.
//
//    Cenários de uso
//    As réplicas de leitura são recomendadas em diversos cenários, incluindo:
//
//    Aplicações com alto volume de leitura
//
//    Em aplicações onde a maioria das operações são de leitura, como blogs, portais de notícias e aplicativos de análise, uma réplica de leitura pode distribuir a carga de consultas entre várias réplicas, melhorando o desempenho geral do sistema.
//            Escalabilidade horizontal
//
//    Réplicas de leitura permitem escalar horizontalmente a capacidade de leitura do sistema, adicionando réplicas adicionais conforme necessário para lidar com aumentos de tráfego e carga.
//    Relatórios e análises
//
//    Para aplicações que exigem relatórios e análises em tempo real de grandes conjuntos de dados, réplicas de leitura podem fornecer uma fonte dedicada para consultas analíticas sem afetar o desempenho das operações de escrita.
//    Leitura em regiões geográficas distintas
//
//    Em aplicações distribuídas globalmente, réplicas de leitura podem ser configuradas em regiões geográficas distintas para reduzir a latência e melhorar a experiência do usuário final em diferentes localidades.
//            Considerações importantes
//    Ao configurar réplicas de leitura, é importante considerar:
//
//    Sincronização de dados: Assegurar que os dados nas réplicas de leitura estejam sempre sincronizados com o banco de dados principal.
//
//    Consistência dos dados: Garantir que as operações de leitura nas réplicas de leitura retornem dados consistentes e atualizados.
//
//    Overhead de manutenção: Realizar manutenção regular nas réplicas de leitura, incluindo monitoramento de desempenho, aplicação de patches e atualizações, e escalonamento conforme necessário.
//
//            Custo: Avaliar os custos associados à configuração e manutenção de réplicas de leitura, incluindo custos de hardware, armazenamento e largura de banda de rede.
//
//    Ao considerar esses aspectos, réplicas de leitura podem ser uma excelente ferramenta para melhorar o desempenho e a escalabilidade de aplicações baseadas em banco de dados, especialmente em ambientes de alta demanda e volume de dados.



    
//    Nesta aula, você aprendeu:
//    Que após realizar o deploy de uma aplicação em ambiente de produção é importante utilizar ferramentas de monitoramento, para acompanhar a saúde da aplicação e identificar possíveis problemas;
//    Que, no geral, um ponto comum de apresentar problemas de performance em uma aplicação é no acesso ao banco de dados;
//    O que é um pool de conexões e como configurar o pool de conexões em uma aplicação JAva que utiliza o Spring Boot;
//    A criar índices em tabelas no banco de dados, para melhorar a performance em determinadas consultas que utilizam filtros;
//    Que embora a utilização de frameworks ORM, com o Hibernate, e de bibliotecas que abstraem as consultas ao banco de dados, como o Spring Data, simplifique bastante a integração da aplicação com o banco de dados, é importante conhecer e analisar os comandos SQL sendo disparados automaticamente por tais ferramentas, para evitar problemas de performance.

}
