package br.com.diegopereira.apimutants.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class PreConditionFailedException extends GlobalException {

    public PreConditionFailedException(String message, String code) {
        super(message, code);
    }
}
