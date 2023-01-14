package hibernate.eTrainingPlanner.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Kurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazwa;
    private String opis;

    @EqualsAndHashCode.Exclude // zawsze przy Set
    @ToString.Exclude // łamie infinity loop
    @OneToMany(mappedBy = "kurs")
    private Set<Edycja_kursu> edycjeKursów ;

}
