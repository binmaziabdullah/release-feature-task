package releaseandfeature.task.releaseandfeature.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "feature_task")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}
