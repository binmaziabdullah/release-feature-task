package releaseandfeature.task.releaseandfeature.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import releaseandfeature.task.releaseandfeature.Repository.FeatureRepository;
import releaseandfeature.task.releaseandfeature.model.Feature;
import releaseandfeature.task.releaseandfeature.model.IdNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    public Feature saveOrUpdate(Feature feature) {
        if (feature.getId()!=null) {
            featureRepository.findById(feature.getId())
                    .orElseThrow(() -> new IdNotFoundException("Can't update, id not exist"));
        }
        return featureRepository.save(feature);
    }

    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();
    }

    public Optional<Feature> getById(Long id) {
        featureRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Id not exist"));
        return featureRepository.findById(id);
    }

    public void deleteById(Long id) {
       featureRepository.findById(id)
               .orElseThrow(() -> new IdNotFoundException("Can't update, id not exist"));
        featureRepository.deleteById(id);
    }
}