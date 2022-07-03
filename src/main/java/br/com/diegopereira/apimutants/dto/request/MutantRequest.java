package br.com.diegopereira.apimutants.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MutantRequest {

    @NotNull(message = "DNA is mandatory")
    private String[] dna;
}
