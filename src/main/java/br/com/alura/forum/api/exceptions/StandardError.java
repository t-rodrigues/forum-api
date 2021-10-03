package br.com.alura.forum.api.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class StandardError {

    private LocalDateTime timestamp = LocalDateTime.now();

    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError(String error, String message, Integer status, String path) {
        this.error = error;
        this.message = message;
        this.status = status;
        this.path = path;
    }

}
