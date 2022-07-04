package br.com.diegopereira.apimutants.service;

import br.com.diegopereira.apimutants.entities.Stats;
import br.com.diegopereira.apimutants.repository.MutantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StatsService {

    private final MutantRepository mutantRepository;

    public Stats findStats() {



        int mutantCount = mutantRepository.getMutantsCount();
        int humanCount = mutantRepository.getHumansCount();



        return new Stats(humanCount, mutantCount);
    }
}
