package br.com.diegopereira.apimutants.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Mutant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String[] dna;

    private boolean isMutant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Mutant mutant = (Mutant) o;
        return id != null && Objects.equals(id, mutant.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}

