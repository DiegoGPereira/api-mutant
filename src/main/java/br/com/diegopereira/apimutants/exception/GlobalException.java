package br.com.diegopereira.apimutants.exception;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class GlobalException extends RuntimeException {

    private final String code;
    private final String message;

}
