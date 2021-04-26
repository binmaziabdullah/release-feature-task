package releaseandfeature.task.releaseandfeature.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import releaseandfeature.task.releaseandfeature.Service.ReleaseService;
import releaseandfeature.task.releaseandfeature.model.Release;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/release")
public class ReleaseController {

    @Autowired
    private ReleaseService releaseService;

    @GetMapping
    public List<Release> getAllRelease(){
        return releaseService.getAllReleases();
    }
    @GetMapping("/{id}")
    public Optional<Release> getReleaseById(@PathVariable Long id){
        return releaseService.getById(id);
    }
    @PostMapping
    public String createRelease(@RequestBody Release release){
        releaseService.createRelease(release);
        return "Release Created";
    }


}
