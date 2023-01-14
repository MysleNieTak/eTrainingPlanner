package hibernate.eTrainingPlanner.model;

import com.mysql.cj.conf.PropertyDefinitions;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Edycja_kursu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazwa;
    private Date data_rozpoczęcia;
    private Date data_zakończenia;
    private int cena;

    @ToString.Exclude // łamie infinity loop
    @EqualsAndHashCode.Exclude // zawsze przy Set
    @OneToMany(mappedBy = "edycja_kursu")
    private Set<Blok_Zajęć> bloki_zajęćSet;

    @ManyToOne
    private Kurs kurs;

    @ToString.Exclude // łamie infinity loop
    @EqualsAndHashCode.Exclude // zawsze przy Set
    @OneToMany(mappedBy = "edycja_kursu")
    private Set<Uczestnik> uczestnicy;


}
