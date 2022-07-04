package br.com.diegopereira.apimutants.service;

import br.com.diegopereira.apimutants.entities.Stats;
import br.com.diegopereira.apimutants.repository.MutantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StatsService {

    private final MutantRepository mutantRepository;

    @Cacheable(value= "Stats")
    public Stats findStats() {

        int humansCount = mutantRepository.getHumansCount();
        int mutantsCount = mutantRepository.getMutantsCount();

        double ratio = (humansCount != 0) ? (double) mutantsCount / humansCount : 0;

        return Stats.builder()
                .countMutantDna(mutantsCount)
                .countHumanDna(humansCount)
                .ratio(ratio)
                .build();
    }
}
