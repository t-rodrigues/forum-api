package br.com.alura.forum.infra.handlers;

import br.com.alura.forum.api.exceptions.StandardError;
import br.com.alura.forum.api.exceptions.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
            HttpServletRequest request) {
        var validationErro = new ValidationError(ex.getClass().getSimpleName(), ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(), request.getRequestURI());

        ex.getFieldErrors().forEach(f -> validationErro.addErrors(f.getField(), f.getDefaultMessage()));

        return ResponseEntity.badRequest().body(validationErro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> handleException(Exception ex, HttpServletRequest request) {
        var error = getError(ex.getClass().getSimpleName(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
                request.getRequestURI());

        return ResponseEntity.internalServerError().body(error);
    }

    private StandardError getError(String error, String message, Integer status, String path) {
        return new StandardError(error, message, status, path);
    }

}
