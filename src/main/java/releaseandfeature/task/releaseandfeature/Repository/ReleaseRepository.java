package releaseandfeature.task.releaseandfeature.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import releaseandfeature.task.releaseandfeature.model.Release;


@Repository
public interface ReleaseRepository extends JpaRepository<Release, Long> {

    @Modifying
    @Query("delete Release r where id = :id")
    int deleteFeatureById(@Param("id") Long id);
}
