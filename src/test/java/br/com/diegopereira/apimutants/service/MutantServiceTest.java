package br.com.diegopereira.apimutants.service;

import br.com.diegopereira.apimutants.exception.UnprocessableEntityException;
import br.com.diegopereira.apimutants.mock.DNAMock;
import br.com.diegopereira.apimutants.repository.MutantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MutantServiceTest {

    @InjectMocks
    MutantService mutantService;

    @Mock
    MutantRepository mutantRepository;

    @Test
    public void shouldDnaIsMutantHorizontal() {
        String[] dna = DNAMock.mutantHorizontal();

        assertTrue(mutantService.isMutant(dna));
    }

    @Test
    public void shouldDnaIsMutantVertical() {
        String[] dna = DNAMock.mutantVertical();

        assertTrue(mutantService.isMutant(dna));
    }

    @Test
    public void shouldDnaIsMutantDiagonalTopLeftToBottomRight() {
        String[] dna = DNAMock.mutantDiagonalTopLeftToBottomRight();

        assertTrue(mutantService.isMutant(dna));
    }

    @Test
    public void shouldDnaIsMutantDiagonalTopRightToBottomLeft() {
        String[] dna = DNAMock.mutantDiagonalTopRightToBottomLeft();

        assertTrue(mutantService.isMutant(dna));
    }

    @Test
    public void shouldDnaIsHuman() {
        String[] dna = DNAMock.human();

        assertFalse(mutantService.isMutant(dna));
    }

    @Test
    public void shouldThrowArrayOutOfBoundsException() {

        String[] dna = DNAMock.invalidDNA();

        UnprocessableEntityException exception = assertThrows(UnprocessableEntityException.class,
                () -> mutantService.isMutant(dna));

        assertEquals("DNA is invalid", exception.getMessage());
        assertEquals("422.001", exception.getCode());
    }
}
