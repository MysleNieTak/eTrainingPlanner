package hibernate.eTrainingPlanner.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private int price;
    private int numberOfAvailableSeats; // 10/15
    private boolean isFull; //


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
