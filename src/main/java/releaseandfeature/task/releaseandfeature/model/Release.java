package releaseandfeature.task.releaseandfeature.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "release_task")
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String buildNumber;

    @Temporal(TemporalType.DATE)
    private Date buildDate;
    
    private String version;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @Enumerated(EnumType.STRING)
    private ReleaseStatus status;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "release_id", referencedColumnName = "id")
    private List<Feature> features;


}
