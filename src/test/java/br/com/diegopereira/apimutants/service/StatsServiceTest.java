package br.com.diegopereira.apimutants.service;

import br.com.diegopereira.apimutants.entities.Stats;
import br.com.diegopereira.apimutants.repository.MutantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatsServiceTest {

    @InjectMocks
    StatsService statsService;

    @Mock
    MutantRepository mutantRepository;

    @Test
    public void shouldReturnStatsSucessfully() {

        int humansCount = 100;
        int mutantsCount = 40;

        Stats expected = Stats.builder()
                .countMutantDna(mutantsCount)
                .countHumanDna(humansCount)
                .ratio(0.4)
                .build();

        when(mutantRepository.getMutantsCount()).thenReturn(mutantsCount);
        when(mutantRepository.getHumansCount()).thenReturn(humansCount);

        Stats actual = statsService.findStats();

        assertEquals(expected.getCountHumanDna(), actual.getCountHumanDna());
        assertEquals(expected.getCountMutantDna(), actual.getCountMutantDna());
        assertEquals(expected.getRatio(), actual.getRatio());
    }

}