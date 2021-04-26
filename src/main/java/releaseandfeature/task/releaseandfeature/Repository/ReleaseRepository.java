package releaseandfeature.task.releaseandfeature.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import releaseandfeature.task.releaseandfeature.model.Release;

@Repository
public interface ReleaseRepository extends JpaRepository<Release, Long> {
}
