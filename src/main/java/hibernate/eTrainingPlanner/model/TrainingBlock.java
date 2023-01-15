package hibernate.eTrainingPlanner.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainingBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ToString.Exclude // łamie infinity loop
    @EqualsAndHashCode.Exclude // zawsze przy Set
    @OneToMany(mappedBy = "trainingBlock")
    private Set<Training> trainings;

    @ManyToOne
    private CourseEdition courseEdition;



}
