package hibernate.eTrainingPlanner.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseEdition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Date date_start;
    private Date data_end;
    private int price;

    @ToString.Exclude // łamie infinity loop
    @EqualsAndHashCode.Exclude // zawsze przy Set
    @OneToMany(mappedBy = "courseEdition")
    private Set<TrainingBlock> trainingBlocks;

    @ManyToOne
    private Course course;

    @ToString.Exclude // łamie infinity loop
    @EqualsAndHashCode.Exclude // zawsze przy Set
    @OneToMany(mappedBy = "courseEdition")
    private Set<Trainee> trainees;


}
