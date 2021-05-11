package releaseandfeature.task.releaseandfeature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import releaseandfeature.task.releaseandfeature.repository.FeatureRepository;
import releaseandfeature.task.releaseandfeature.model.Feature;
import releaseandfeature.task.releaseandfeature.custom_exception.PropertyNotFoundException;

import java.util.List;

@Service
@Transactional
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    public Feature saveOrUpdate(Feature feature) {
        if (feature.getId() != null) {
            findEntityById(feature.getId());
        }
        return featureRepository.save(feature);
    }

    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();
    }

    public Feature findById(Long id) {
        return findEntityById(id);
    }

    public void deleteById(Long id) {
        Feature feature = findEntityById(id);
        featureRepository.deleteById(id);
    }

    private Feature findEntityById(Long id){
        return featureRepository.findById(id)
                .orElseThrow(() -> new PropertyNotFoundException("Feature not found!"));

    }
}