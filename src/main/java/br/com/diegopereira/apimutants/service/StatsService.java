package br.com.diegopereira.apimutants.service;

import br.com.diegopereira.apimutants.entities.Stats;
import br.com.diegopereira.apimutants.repository.MutantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class StatsService {

    private final MutantRepository mutantRepository;

    public Stats findStats() {

        log.info("Starting fetch stats from database!");

        int mutantCount = mutantRepository.getMutantsCount();
        int humanCount = mutantRepository.getHumansCount();

        log.info("Finished fetch stats from database!");

        return new Stats(humanCount, mutantCount);
    }
}
