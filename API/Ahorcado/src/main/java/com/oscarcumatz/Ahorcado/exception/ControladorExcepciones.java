package com.oscarcumatz.Ahorcado.exception;

import com.oscarcumatz.Ahorcado.model.Usuarios;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControladorExcepciones {

    @ExceptionHandler (NoHandlerFoundException.class) //indica al metodo reaccionar solo si no se encuentra la ruta api
    public ResponseEntity<Map<String, Object>> ApiIncorrectaUsuarios(NoHandlerFoundException badApi){
        Map<String, Object> mensaje = new HashMap<>();
        mensaje.put("status", HttpStatus.NOT_FOUND.value()); // 404 no encontrado, la rutaxd
        mensaje.put("error: ", "No se encontro la ruta (404)");
        mensaje.put("mensaje:","Verifique la ruta de la api porfavor");
        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler (HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> metodoIncorrecto(HttpRequestMethodNotSupportedException error){
        Map<String, Object> mensaje = new HashMap<>();
        mensaje.put("status", HttpStatus.METHOD_NOT_ALLOWED.value()); // 405 slicitud invalida waos
        mensaje.put("error: ","Parametros incorrectos (400)");
        mensaje.put("mensaje: ", "Verifique los parametros porfavor");
        return new ResponseEntity<>(mensaje, HttpStatus.METHOD_NOT_ALLOWED);
    }
    @ExceptionHandler (MethodArgumentTypeMismatchException.class)
        public ResponseEntity<Map<String, Object>> parametroIncorrecto(MethodArgumentTypeMismatchException error){
        Map<String, Object> mensaje = new HashMap<>();
        mensaje.put("status", HttpStatus.METHOD_NOT_ALLOWED.value());
        mensaje.put("errro:","tipo de dato incorrecto (400)");
        mensaje.put("mensaje:", "Verificar los parametros porfavor");
        return new ResponseEntity<>(mensaje, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
