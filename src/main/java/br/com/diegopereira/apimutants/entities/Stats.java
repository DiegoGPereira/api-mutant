package br.com.diegopereira.apimutants.entities;

public class Stats {
    private int countMutantDna;
    private int countHumanDna;
    private double ratio;

    public Stats(int countHumanDna, int countMutantDna) {
        this.countMutantDna = countMutantDna;
        this.countHumanDna = countHumanDna;
        this.ratio = (this.countHumanDna != 0) ? this.countMutantDna / this.countHumanDna : 0;
        this.ratio = Math.abs(this.ratio);
    }
}
