package releaseandfeature.task.releaseandfeature.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import releaseandfeature.task.releaseandfeature.Service.FeatureService;
import releaseandfeature.task.releaseandfeature.model.Feature;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/feature")
public class FeatureController {
    @Autowired
    private FeatureService featureService;

    @GetMapping
    public List<Feature> getAllFeature(){
        return featureService.getAllFeatures();
    }
    @GetMapping("/{id}")
    public Optional<Feature> getFeatureById(@PathVariable Long id){
        return featureService.getById(id);
    }
    @PostMapping
    public String createFeature(@RequestBody Feature feature){
        featureService.createFeature(feature);
        return "Feature Created";
    }
    @PutMapping
    public Feature updateFeature(@RequestBody Feature feature){
        return featureService.updateFeature(feature);
    }
    @DeleteMapping("/{id}")
    public String deleteFeature(@PathVariable Long id){
        featureService.deleteById(id);
        return "data deleted";
    }

}