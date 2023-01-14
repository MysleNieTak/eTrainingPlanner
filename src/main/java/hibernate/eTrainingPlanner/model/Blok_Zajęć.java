package hibernate.eTrainingPlanner.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Blok_Zajęć {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazwa;

    @ToString.Exclude // łamie infinity loop
    @EqualsAndHashCode.Exclude // zawsze przy Set
    @OneToMany(mappedBy = "bloki_zajęć")
    private Set<Zajęcia> zajęciaSet;

    @ManyToOne
    private Edycja_kursu edycja_kursu;



}
