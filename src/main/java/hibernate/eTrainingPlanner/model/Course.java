package hibernate.eTrainingPlanner.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @EqualsAndHashCode.Exclude // zawsze przy Set
    @ToString.Exclude // łamie infinity loop
    @OneToMany(mappedBy = "course")
    private Set<CourseEdition> courseEditions;

}
