package releaseandfeature.task.releaseandfeature.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import releaseandfeature.task.releaseandfeature.Repository.ReleaseRepository;
import releaseandfeature.task.releaseandfeature.model.Release;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReleaseService {

    @Autowired
    private ReleaseRepository releaseRepository;

    public void createRelease(Release release){
        releaseRepository.save(release);
    }

    public List<Release> getAllReleases(){
        return releaseRepository.findAll();
    }
    public Optional<Release> getById(Long id){
        Optional<Release> optionalRelease =  releaseRepository.findById(id);
        if(!optionalRelease.isPresent())
            throw new RuntimeException("Id not exist");
        return optionalRelease;
    }
}
