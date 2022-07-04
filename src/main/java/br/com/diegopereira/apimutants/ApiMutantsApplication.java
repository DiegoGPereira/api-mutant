package br.com.diegopereira.apimutants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiMutantsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiMutantsApplication.class, args);
    }

}
