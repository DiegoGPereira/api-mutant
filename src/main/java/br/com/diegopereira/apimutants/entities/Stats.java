package br.com.diegopereira.apimutants.entities;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class Stats implements Serializable {

    private int countMutantDna;
    private int countHumanDna;
    private double ratio;

}
