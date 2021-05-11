package releaseandfeature.task.releaseandfeature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import releaseandfeature.task.releaseandfeature.model.Release;
import releaseandfeature.task.releaseandfeature.service.FeatureService;
import releaseandfeature.task.releaseandfeature.model.Feature;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/feature")
public class FeatureController {
    @Autowired
    private FeatureService featureService;

    @GetMapping
    public ResponseEntity<List<Feature>> getAllFeature() {
        List<Feature> featureList = featureService.getAllFeatures();
        return new ResponseEntity<>(featureList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feature> getFeatureById(@PathVariable Long id) {
        Feature feature = featureService.findById(id);
        return new ResponseEntity<Feature>(feature,HttpStatus.OK);
    }

    @PostMapping
    public Feature saveOrUpdate(@RequestBody Feature feature) {
        return featureService.saveOrUpdate(feature);
    }

    @DeleteMapping("/{id}")
    public String deleteFeature(@PathVariable Long id) {
        featureService.deleteById(id);
        return "data deleted successfully!";
    }

}
