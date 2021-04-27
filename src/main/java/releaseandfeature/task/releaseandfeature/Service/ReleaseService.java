package releaseandfeature.task.releaseandfeature.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import releaseandfeature.task.releaseandfeature.Repository.ReleaseRepository;
import releaseandfeature.task.releaseandfeature.model.IdNotFoundException;
import releaseandfeature.task.releaseandfeature.model.Release;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReleaseService {

    @Autowired
    private ReleaseRepository releaseRepository;

    public Release saveOrUpdate(Release release) {
        releaseRepository.findById(release.getId())
                .orElseThrow(() -> new IdNotFoundException("Can't update, id not exist"));

        return releaseRepository.save(release);
    }


    public List<Release> getAllReleases() {
        return releaseRepository.findAll();
    }

    public Optional<Release> getById(Long id) {
        Optional<Release> optionalRelease = releaseRepository.findById(id);
        optionalRelease.filter(release -> optionalRelease.isPresent())
                .orElseThrow( () -> new IdNotFoundException("given id not exist"));
        return optionalRelease;
    }

    public void deleteById(Long id) {
        releaseRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Can't update, id not exist"));
        releaseRepository.deleteById(id);
    }
}
