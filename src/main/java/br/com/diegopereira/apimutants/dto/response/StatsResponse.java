package br.com.diegopereira.apimutants.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
public class StatsResponse {

    private int countMutantDna;
    private int countHumanDna;
    private double ratio;

}
