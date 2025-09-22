package com.oscarcumatz.Ahorcado.exception;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import java.net.BindException;

public class ExcepcionEventos implements ApplicationListener<ApplicationFailedEvent> {

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        Throwable cause = event.getException().getCause();

        if (cause instanceof BindException) {
            System.err.println("\n¡ERROR! El puerto de la aplicación ya está en uso.");
        } else if (cause != null && cause.getMessage().contains("Public Key Retrieval is not allowed")) {
            System.err.println("\n¡ERROR! No se pudo conectar a la base de datos.");}
        else if (cause instanceof CannotGetJdbcConnectionException || cause instanceof DataAccessException) {
            System.err.println("\n¡ERROR! No se pudo conectar a la base de datos.");
            System.err.println("Por favor, revise el usuario, contraseña o la URL en 'application.properties'.");
            System.err.println("Asegúrese de que el servidor de la base de datos esté en ejecución.");
        }
        ConfigurableApplicationContext context = event.getApplicationContext();
        if (context != null) {
            context.close();
        }
    }


    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
