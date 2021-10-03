package br.com.alura.forum.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FieldMessage {

    private String field;
    private String message;

}
