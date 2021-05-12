package releaseandfeature.task.releaseandfeature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import releaseandfeature.task.releaseandfeature.repository.ReleaseRepository;
import releaseandfeature.task.releaseandfeature.custom_exception.PropertyNotFoundException;
import releaseandfeature.task.releaseandfeature.enum_release.ReleaseStatus;
import releaseandfeature.task.releaseandfeature.model.Release;

import java.util.List;

@Service
@Transactional
public class ReleaseService {
    @Autowired
    private ReleaseRepository releaseRepository;

    public Release saveOrUpdate(Release release) {
        if (release.getId() != null) {
            findEntityById(release.getId());
        }
        return releaseRepository.save(release);
    }

    public List<Release> getAllReleases() {
        return releaseRepository.findAll();
    }

    public Release getById(Long id) {
         return findEntityById(id);
    }

    public Release deleteById(Long id) {
        Release release = findEntityById(id);
        releaseRepository.deleteById(release.getId());
        return release;
    }

    public List<Release> getReleaseByStatus(ReleaseStatus status){
        return releaseRepository.findByStatus(status);
    }

    private Release findEntityById(Long id){
        return releaseRepository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("Release not found!"));
    }
}
