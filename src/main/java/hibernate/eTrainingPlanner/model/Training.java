package hibernate.eTrainingPlanner.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Training {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private String subject;

    @CreationTimestamp
    private LocalDate dateOfTraining;
    private String script;

  @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private TrainingBlock trainingBlock;

}
