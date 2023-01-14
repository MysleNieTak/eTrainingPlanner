package hibernate.eTrainingPlanner.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Uczestnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imię;
    private String nazwisko;
    private boolean czyAktywny;

@ManyToOne
    private Edycja_kursu edycja_kursu;


}
