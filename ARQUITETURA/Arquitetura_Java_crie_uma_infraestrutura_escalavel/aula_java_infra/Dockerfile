# Usa a imagem base `openjdk:21` para criar um estágio de build nomeado `builder`, onde o aplicativo será construído.
FROM openjdk:21 as builder

# Define o diretório de trabalho no container como `application`.
WORKDIR application

# Copia o wrapper Maven (`mvnw`) para o diretório de trabalho no container.
COPY mvnw .

# Copia o diretório `.mvn`, que contém arquivos necessários para o wrapper Maven.
COPY .mvn .mvn

# Copia o arquivo `pom.xml` para o diretório de trabalho, contendo as dependências do projeto.
COPY pom.xml .

# Copia o diretório `src`, onde está o código-fonte da aplicação.
COPY src src

# Executa o comando `mvnw package` para compilar e empacotar a aplicação, ignorando os testes.
RUN ./mvnw package -DskipTests

# Define uma variável de ambiente `JAR_FILE` que aponta para o JAR resultante do processo de build na pasta `target`.
ARG JAR_FILE=target/*.jar

# Copia o JAR gerado para o container e o renomeia para `application.jar`.
COPY ${JAR_FILE} application.jar

# Extrai o JAR usando a opção `layertools` do Spring Boot para dividir o aplicativo em camadas reutilizáveis (dependências, classes do Spring Boot e a aplicação).
RUN java -Djarmode=layertools -jar application.jar extract






# Inicia um segundo estágio a partir da imagem base `openjdk:21` para o contêiner final.
FROM openjdk:21

# Define o diretório de trabalho como `application` no container final.
WORKDIR application

# Copia as dependências extraídas no estágio de build para o container final.
COPY --from=builder application/dependencies/ ./

# Copia o loader do Spring Boot.
COPY --from=builder application/spring-boot-loader/ ./

# Copia as dependências de snapshot do projeto.
COPY --from=builder application/snapshot-dependencies/ ./

# Copia o código da aplicação para o container final.
COPY --from=builder application/application/ ./

# Define o comando de entrada, que inicia a aplicação usando o `JarLauncher` do Spring Boot.
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
