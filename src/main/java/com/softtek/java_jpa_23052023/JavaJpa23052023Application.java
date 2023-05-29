package com.softtek.java_jpa_23052023;

import com.softtek.java_jpa_23052023.controlador.servicio.NorthwindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaJpa23052023Application implements CommandLineRunner {

    @Autowired
    NorthwindService servicio;

    public static void main(String[] args) {
        SpringApplication.run(JavaJpa23052023Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
    }
}
