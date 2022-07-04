package br.com.diegopereira.apimutants.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Stats {

    private int countMutantDna;
    private int countHumanDna;
    private double ratio;

}
