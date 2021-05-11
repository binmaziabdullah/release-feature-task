package releaseandfeature.task.releaseandfeature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import releaseandfeature.task.releaseandfeature.model.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
