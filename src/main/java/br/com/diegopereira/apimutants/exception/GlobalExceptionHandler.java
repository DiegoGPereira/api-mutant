package br.com.diegopereira.apimutants.exception;

import br.com.diegopereira.apimutants.dto.response.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(UnprocessableEntityException.class)
    protected ResponseEntity handleUnprocessableException(GlobalException simpleMutantGlobalException) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ErrorResponse.builder()
                        .code(simpleMutantGlobalException.getCode())
                        .message(simpleMutantGlobalException.getMessage())
                        .build());
    }

    @ExceptionHandler(PreConditionFailedException.class)
    protected ResponseEntity handlePreConditionException(GlobalException simpleMutantGlobalException) {
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                .body(ErrorResponse.builder()
                        .code(simpleMutantGlobalException.getCode())
                        .message(simpleMutantGlobalException.getMessage())
                        .build());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity handleDataIntegrityException() {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ErrorResponse.builder()
                        .code(String.valueOf(HttpStatus.CONFLICT.value()))
                        .message("This DNA already exists in database")
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity handleDataIntegrityException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        StringBuilder errors = new StringBuilder();
        fieldErrors.forEach(s -> {
            errors.append(s.getDefaultMessage());
            errors.append(System.getProperty("line.separator"));
        });

        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED)
                .body(ErrorResponse.builder()
                        .code(String.valueOf(HttpStatus.PRECONDITION_FAILED.value()))
                        .message(errors.toString())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity handleException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.builder()
                        .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                        .message("an unexpected error occurred")
                        .build());
    }

}

