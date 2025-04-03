package com.jefferson.anotacoes;

public class CacheComRegis {

    //Adicionando container REDIS

//    A aula abordou a adição de um container Redis para implementar um cache na aplicação.
//    O objetivo é melhorar a performance da aplicação, especialmente para consultas na tabela de eventos, que não são atualizadas com muita frequência.
//    O cache ajuda a otimizar a performance, pois consultas em memória são muito mais rápidas do que consultas no banco de dados.
//    Foi adicionado um novo container Redis no arquivo docker-compose.yml, seguindo a mesma estrutura dos outros containers.
//    Agora a aplicação possui uma nova camada de cache entre a API e o banco de dados, que será implementada no próximo vídeo.
//    A ideia é que, na primeira consulta de eventos, a aplicação carregue do banco de dados e armazene no cache. Nas próximas consultas, ela buscará primeiro no cache antes de ir ao banco de dados.
//    Em resumo, a aula preparou a infraestrutura para a implementação do cache usando o Redis na próxima etapa do curso.

    //
//    redis:
//    image: redis:7.2.4
//    restart: unless-stopped



    //Configurando cache aplicação

//    Adicionando novas dependências: Foi necessário adicionar duas dependências no arquivo pom.xml para integrar o Spring com o Redis:
//
//    spring-boot-starter-data-redis: Módulo de integração com o Redis.
//    spring-boot-starter-cache: Habilita os recursos de cache na aplicação.
//    Configurando o Redis:
//
//    No arquivo application.properties, foram adicionadas as propriedades spring.redis.host e spring.redis.port para informar o endereço e a porta do servidor Redis.
//    A classe principal CodechellaApplication foi anotada com @EnableCaching para habilitar o módulo de cache no projeto.
//            Conclusão:
//
//    Com essas configurações, o projeto está pronto para utilizar o Redis como ferramenta de cache.
//    No próximo vídeo, serão aprendidas as configurações de quais requisições devem ser armazenadas no cache, por quanto tempo e como invalidar os dados do cache.
//    O objetivo dessa aula foi configurar a integração da aplicação CodeChella com o Redis para utilizar cache em memória e melhorar o desempenho da aplicação.





    //Guardando dados cache

//    A aula teve como objetivo ensinar como configurar o cache na aplicação utilizando o Redis. Para isso, foi utilizada a anotação @Cacheable no método listarProximosEventos() da classe EventoService. Essa anotação indica ao Spring que o retorno desse método deve ser armazenado em cache, com o nome "proximosEventos".
//
//    Para que o cache funcione corretamente, foi necessário que a classe DadosEvento e seus atributos implementassem a interface Serializable. Isso porque o Spring usa o conceito de serialização para armazenar os objetos em cache.
//
//    Ao testar a aplicação, foi possível verificar que na primeira requisição os dados eram buscados do banco de dados, mas nas próximas requisições eles eram retornados diretamente do cache, o que melhora significativamente a performance da aplicação.
//
//    No entanto, o uso de cache traz um trade-off: embora melhore a performance, pode retornar informações desatualizadas, caso os dados no banco de dados sejam alterados. Para resolver esse problema, foi apresentada a anotação @CacheEvict, que deve ser usada em métodos que alteram os dados no banco, como o método cadastrar(), para limpar o cache.
//
//    Além disso, foi mencionada a possibilidade de configurar um timeout para o cache, de forma que as informações sejam atualizadas periodicamente, evitando que dados desatualizados sejam exibidos aos usuários.
//
//    Por fim, foi explicado que essa nova arquitetura com o Redis pode ser implantada no ambiente de produção, atualizando a imagem da aplicação no Docker Hub, o que trará benefícios em termos de performance e escalabilidade para a aplicação.


    //Para saber mais: invalidação de cache

//    No curso, aprendemos como utilizar cache para armazenar dados lidos do banco de dados em memória, utilizando um container Redis. Também foi ensinado como configurar a aplicação Spring Boot para integrar-se ao Redis e armazenar informações em cache, além de invalidar o cache sempre que um novo registro é salvo na tabela.
//


//    Invalidação de cache
//    Além da invalidação de cache manual, ao inserir, atualizar ou excluir registros no banco de dados, existem outras estratégias de invalidação de cache:
//
//    Timeout: Definir um tempo de expiração para os objetos em cache. Após o tempo definido, os objetos são automaticamente removidos do cache e uma nova consulta ao banco de dados é feita para recuperar os dados atualizados.
//
//    Tamanho do cache: Limitar o número máximo de objetos que podem ser armazenados em cache. Quando o limite é atingido, os objetos menos utilizados são removidos para dar lugar aos novos.
//
//    Políticas de invalidação de Cache
//    As políticas de invalidação de cache determinam como os objetos são selecionados para remoção quando há necessidade de liberar espaço no cache. Duas das políticas mais comuns são:
//
//    Least Frequently Used (LFU - Menos Frequente Utilizado): Esta política remove os objetos que foram acessados com menos frequência. Ou seja, se um objeto não foi acessado recentemente, é mais provável que seja removido do cache.
//
//    Least Recently Used (LRU - Menos Recentemente Utilizado): Esta política remove os objetos que foram acessados menos recentemente. Ou seja, se um objeto não foi acessado por um longo período de tempo, é mais provável que seja removido do cache.
//
//    Ao escolher uma política de invalidação de cache, é importante considerar as características específicas da aplicação e dos dados em cache, garantindo que a política selecionada otimize a utilização de recursos e melhore o desempenho geral da aplicação.



    //Para saber mais: cuidados ao utilizar cache

//    Embora o cache seja um recurso valioso que pode melhorar significativamente o desempenho de uma aplicação, é importante tomar alguns cuidados ao utilizá-lo. Aplicar cache em todas as consultas da aplicação pode não ser a melhor abordagem, podendo inclusive prejudicar a performance dela.
//
//    Considerações para o uso de cache
//    Aqui estão alguns cuidados importantes a serem considerados ao utilizar cache:
//
//    Seleção de dados: Nem todas as consultas da aplicação se beneficiam do uso de cache. Consultas que retornam dados que mudam frequentemente ou consultas que envolvem operações de escrita não são bons candidatos para cache. É importante selecionar cuidadosamente quais consultas serão cacheadas para evitar inconsistências nos dados e sobrecarga desnecessária no sistema.
//
//    Tamanho e expiração do cache: É importante definir um tamanho máximo para o cache e um tempo de expiração adequado para os objetos em cache. Um cache muito grande pode consumir muita memória e afetar o desempenho do sistema, enquanto um tempo de expiração muito longo pode resultar em dados desatualizados sendo servidos aos usuários.
//
//    Monitoramento: Monitorar o uso do cache e sua eficácia é fundamental para garantir que ele esteja cumprindo seu propósito.
//
//    Testes: Realizar testes é essencial para determinar o impacto do cache na aplicação. Testar diferentes configurações de cache e cenários de uso pode ajudar a identificar problemas de desempenho e ajustar as configurações do cache conforme necessário.
//
//    O cache é uma ferramenta muito útil para melhorar a performance de uma aplicação, mas deve ser utilizado com cautela. É importante avaliar cuidadosamente quais consultas podem se beneficiar do cache e ajustar as configurações do cache de acordo com as necessidades específicas da aplicação.




//    Nesta aula, você aprendeu:
//    A utilizar o recurso de cache como mais uma ferramenta para melhorar a performance de uma aplicação, em relação ao acesso ao banco de dados;
//    A configurar um container Redis como ferramenta de cache da aplicação;
//    Como configurar o Redis em uma aplicação Java com Spring Boot;
//    Como adicionar e remover dados do cache na aplicação, via utilização das anotações @Cacheable e @CacheEvict.


}
