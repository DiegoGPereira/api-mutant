package br.com.diegopereira.apimutants.controller;

import br.com.diegopereira.apimutants.dto.request.MutantRequest;
import br.com.diegopereira.apimutants.entities.Mutant;
import br.com.diegopereira.apimutants.service.MutantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
@Slf4j
public class MutantController {

    private final MutantService mutantService;
    private final ModelMapper modelMapper;

    @PostMapping("/mutant")
    public ResponseEntity<Void> isMutant(@Valid @RequestBody MutantRequest mutantRequest) {

        Mutant mutant = modelMapper.map(mutantRequest, Mutant.class);

        boolean isMutant = mutantService.isMutant(mutant.getDna());

        mutant.setMutant(isMutant);

        mutantService.save(mutant);

        return isMutant ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.FORBIDDEN).build();

    }

}
