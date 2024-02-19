package org.example.inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class InventarioApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Swagger UI: http://localhost:8080/swagger-ui/index.html#/");
    }


}
