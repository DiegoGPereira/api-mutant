package br.com.diegopereira.apimutants.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends GlobalException {
    public UnprocessableEntityException(String message, String code) {
        super(message, code);
    }
}
