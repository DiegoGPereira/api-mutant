package br.com.diegopereira.apimutants.repository;

import br.com.diegopereira.apimutants.entities.Mutant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MutantRepository extends JpaRepository<Mutant, Long> {

    @Query(value = "SELECT COUNT(*) filter (where not is_mutant) as countHumanDna" +
            " FROM Mutant", nativeQuery = true)
    int getHumansCount();

    @Query(value = "SELECT COUNT(*) filter (where is_mutant) as countMutantDna " +
            " FROM Mutant", nativeQuery = true)
    int getMutantsCount();
}
