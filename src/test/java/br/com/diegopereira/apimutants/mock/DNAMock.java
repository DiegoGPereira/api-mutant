package br.com.diegopereira.apimutants.mock;

public class DNAMock {

    public static String[] mutantHorizontal() {
        return new String[]{"ATGCGA",
                "CAGTGC",
                "TTCTGT",
                "AGAATG",
                "CCCCTA",
                "TCACTG"};
    }

    public static String[] mutantVertical() {
        return new String[]{"ATGCGA",
                "CAGTGC",
                "TTCTGT",
                "AGAAGG",
                "CCTCTA",
                "TCACTG"};
    }

    public static String[] mutantDiagonalTopLeftToBottomRight() {
        return new String[]{"ATGCGA",
                "CAGTGC",
                "TTATTT",
                "AGAAGG",
                "CCTCTA",
                "TCACTG"};

    }

    public static String[] mutantDiagonalTopRightToBottomLeft() {
        return new String[]{"ATGCGA",
                "CTGTAC",
                "TTAAGT",
                "AGAATG",
                "CCGCTA",
                "TCACTG"};
    }

    public static String[] human() {
        return new String[]{"ATGCGA",
                "CAGTGC",
                "TTCTGT",
                "AGAATG",
                "CCCGTA",
                "TCACTG"};
    }

    public static String[] invalidDNA() {
        return new String[]{"ATGCGA",
                "CAGTGC",
                "123",
                "AGAATGX",
                "CCCGTA",
                "TCACTG"};
    }

}
