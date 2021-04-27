package releaseandfeature.task.releaseandfeature.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import releaseandfeature.task.releaseandfeature.Repository.FeatureRepository;
import releaseandfeature.task.releaseandfeature.model.Feature;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    public Feature saveOrUpdate(Feature feature) {
        Optional<Feature> optionalFeature = featureRepository.findById(feature.getId());
        if (!optionalFeature.isPresent()) {
            throw new RuntimeException("Can't update/save, id not found");
        }
        return featureRepository.save(feature);
    }

    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();
    }

    public Optional<Feature> getById(Long id) {
        Optional<Feature> optionalFeature = featureRepository.findById(id);
        if (!optionalFeature.isPresent())
            throw new RuntimeException("Id not exist");
        return optionalFeature;
    }

    public void deleteById(Long id) {
        Optional<Feature> optionalFeature = featureRepository.findById(id);
        if (!optionalFeature.isPresent())
            throw new RuntimeException("Can't delete Id not exist");
        featureRepository.deleteById(id);
    }
}