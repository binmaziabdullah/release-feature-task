package releaseandfeature.task.releaseandfeature.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import releaseandfeature.task.releaseandfeature.model.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
