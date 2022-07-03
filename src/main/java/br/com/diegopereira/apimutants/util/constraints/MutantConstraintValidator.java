package br.com.diegopereira.apimutants.util.constraints;

import br.com.diegopereira.apimutants.dto.request.MutantRequest;

import java.util.ArrayList;
import java.util.List;

public class MutantConstraintValidator {

    public static List<String> validate(MutantRequest mutantRequest) {
        List<String> errors = new ArrayList<>();

        if (mutantRequest.getDna() == null) {
            errors.add("DNA cannot be null");
        }

        if (mutantRequest.getDna() != null && mutantRequest.getDna().length == 0
                || mutantRequest.getDna()[0].length() == 0) {
            errors.add("DNA cannot be empty");
        }

        return errors;
    }
}
