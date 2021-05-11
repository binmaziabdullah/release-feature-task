package releaseandfeature.task.releaseandfeature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import releaseandfeature.task.releaseandfeature.enum_release.ReleaseStatus;
import releaseandfeature.task.releaseandfeature.model.Release;

import java.util.List;


@Repository
public interface ReleaseRepository extends JpaRepository<Release, Long> {

    /*@Query("select r from Release r where r.status = :status")
    List<Release> getReleaseByStatus(@Param("status") ReleaseStatus status)*/;

    List<Release> findByStatus(ReleaseStatus status);

    @Modifying
    @Query("delete Release r where id = :id")
    int deleteFeatureById(@Param("id") Long id);

}
