package hibernate.eTrainingPlanner.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Zajęcia {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private String temat;

    @CreationTimestamp
    private LocalDate data;
    private String treść;

  @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Blok_Zajęć bloki_zajęć;

}
