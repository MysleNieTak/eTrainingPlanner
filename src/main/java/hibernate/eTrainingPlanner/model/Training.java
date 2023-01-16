package hibernate.eTrainingPlanner.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDateTime dateOfTraining;
    private String script;
    private String materials;
    private String trainer;
    private String trainerExperience;

  @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private TrainingBlock trainingBlock;

}
