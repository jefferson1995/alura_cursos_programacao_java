package com.jefferson.aula_java_infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching //habilita o cache
public class AulaJavaInfraApplication {

	public static void main(String[] args) {
		SpringApplication.run(AulaJavaInfraApplication.class, args);
	}

}
