package br.com.diegopereira.apimutants.service;

import br.com.diegopereira.apimutants.entities.Mutant;
import br.com.diegopereira.apimutants.exception.ErrorCode;
import br.com.diegopereira.apimutants.exception.UnprocessableEntityException;
import br.com.diegopereira.apimutants.repository.MutantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MutantService {

    private static final int SIZE_SEQUENCE_MUTANT = 4;
    private final MutantRepository mutantRepository;

    public void save(Mutant mutant) {
        mutantRepository.save(mutant);
    }

    public boolean isMutant(String[] dna) {

        try {
            if (isMutantHorizontal(dna)) return true;
            if (isMutantVertical(dna)) return true;
            if (isMutantDiagonalTopLeftToBottomRight(dna)) return true;
            if (isMutantDiagonalTopRightToBottomLeft(dna)) return true;
        } catch (IndexOutOfBoundsException e) {
            throw new UnprocessableEntityException("DNA is invalid",
                    ErrorCode.ARRAY_OUT_OF_BOUNDS);
        }

        return false;

    }

    private boolean isMutantHorizontal(String[] dna) {

        for (int i = 0; i < dna.length; i++) {
            char[] charDnaArray = dna[i].toCharArray();
            char sequenceCharAux = '\0';
            int sequenceCharCount = 1;

            for (char it : charDnaArray) {
                if (sequenceCharAux == it) sequenceCharCount++;
                sequenceCharAux = it;
            }

            if (sequenceCharCount == SIZE_SEQUENCE_MUTANT) return true;

        }

        return false;
    }

    private boolean isMutantVertical(String[] dna) {

        int nrows = dna.length;
        int ncols = dna[0].length();
        char sequenceCharAux = '\0';
        int sequenceCharCount = 1;

        for (int i = 0; i < nrows; i++) {
            for (int j = 0; j < ncols; j++) {

                if (sequenceCharAux == dna[j].charAt(i)) sequenceCharCount++;
                else sequenceCharCount = 1;

                sequenceCharAux = dna[j].charAt(i);

                if (sequenceCharCount == SIZE_SEQUENCE_MUTANT) return true;

            }
        }

        return false;
    }

    private boolean isMutantDiagonalTopLeftToBottomRight(String[] dna) {

        int nrows = dna.length;
        int ncols = dna[0].length();
        char sequenceCharAux = '\0';
        int sequenceCharCount = 1;

        for (int i = 0; i < ncols; i++) {
            int n = Math.min(nrows, ncols - i);
            for (int j = 0; j < n; j++) {

                if (sequenceCharAux == dna[j].charAt(i + j)) sequenceCharCount++;
                else sequenceCharCount = 1;

                sequenceCharAux = dna[j].charAt(i + j);

                if (sequenceCharCount == SIZE_SEQUENCE_MUTANT) return true;
            }
        }

        for (int i = 1; i < nrows; i++) {
            int n = Math.min(ncols, nrows - i);
            for (int j = 0; j < n; j++) {

                if (sequenceCharAux == dna[i + j].charAt(j)) sequenceCharCount++;
                else sequenceCharCount = 1;

                sequenceCharAux = dna[i + j].charAt(j);

                if (sequenceCharCount == SIZE_SEQUENCE_MUTANT) return true;
            }
        }

        return false;
    }

    private boolean isMutantDiagonalTopRightToBottomLeft(String[] dna) {

        int nrows = dna.length;
        int ncols = dna[0].length();
        char sequenceCharAux = '\0';
        int sequenceCharCount = 1;

        for (int i = 0; i < ncols; i++) {
            int n = Math.min(nrows, ncols - i);
            for (int j = 0; j < n; j++) {

                if (sequenceCharAux == dna[j].charAt(n - j - 1)) sequenceCharCount++;
                else sequenceCharCount = 1;

                sequenceCharAux = dna[j].charAt(n - j - 1);

                if (sequenceCharCount == SIZE_SEQUENCE_MUTANT) return true;
            }
        }

        for (int i = 0; i < ncols; i++) {
            int n = Math.min(nrows, ncols - i);
            for (int j = 0; j < n - 1; j++) {

                if (sequenceCharAux == dna[j + i + 1].charAt(n - j + i - 1)) sequenceCharCount++;
                else sequenceCharCount = 1;

                sequenceCharAux = dna[j + i + 1].charAt(n - j + i - 1);

                if (sequenceCharCount == SIZE_SEQUENCE_MUTANT) return true;
            }
        }

        return false;
    }
}
