package br.com.diegopereira.apimutants.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stats {

    public Stats(int countHumanDna, int countMutantDna) {
        this.countMutantDna = countMutantDna;
        this.countHumanDna = countHumanDna;
        this.setRatio(countHumanDna, countMutantDna);
    }

    private int countMutantDna;
    private int countHumanDna;
    @Setter(AccessLevel.NONE)
    private double ratio;

    public void setRatio(int countHumanDna, int countMutantDna) {
        this.ratio = (countHumanDna != 0) ? (double) countMutantDna / countHumanDna : 0;
    }
}
