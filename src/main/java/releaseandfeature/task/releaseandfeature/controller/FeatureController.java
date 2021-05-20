package releaseandfeature.task.releaseandfeature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import releaseandfeature.task.releaseandfeature.service.FeatureService;
import releaseandfeature.task.releaseandfeature.model.Feature;

import java.util.List;

@RestController
@RequestMapping("/features")
public class FeatureController {
    @Autowired
    private FeatureService featureService;

    @PostMapping
    public Feature saveOrUpdate(@RequestBody Feature feature) {
        return featureService.saveOrUpdate(feature);
    }

    @GetMapping
    public ResponseEntity<List<Feature>> getAllFeature() {
        List<Feature> featureList = featureService.getAllFeatures();
        return ResponseEntity.ok(featureList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feature> getFeatureById(@PathVariable Long id) {
        Feature feature = featureService.findById(id);
        return ResponseEntity.ok(feature);
    }

    @DeleteMapping("/{id}")
    public String deleteFeature(@PathVariable Long id) {
        featureService.deleteById(id);
        return "data deleted successfully!";
    }

}
