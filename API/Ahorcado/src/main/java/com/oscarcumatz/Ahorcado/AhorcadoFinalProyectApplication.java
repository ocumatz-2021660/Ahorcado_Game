package com.oscarcumatz.Ahorcado;

import com.oscarcumatz.Ahorcado.exception.ExcepcionEventos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AhorcadoFinalProyectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AhorcadoFinalProyectApplication.class);
        app.addListeners(new ExcepcionEventos());
        // Ejecuta la aplicación. El listener atrapará los errores de inicio.
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("UWU");
    }
}