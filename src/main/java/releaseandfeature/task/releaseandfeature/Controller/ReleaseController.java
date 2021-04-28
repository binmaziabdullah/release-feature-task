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

    @PostMapping
    public Release saveOrUpdate(@RequestBody Release release) {
        return releaseService.saveOrUpdate(release);
    }

    @GetMapping
    public List<Release> getAllRelease() {
        return releaseService.getAllReleases();
    }

    @GetMapping("/{id}")
    public Optional<Release> getReleaseById(@PathVariable Long id) {
        return releaseService.getById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        releaseService.deleteById(id);
        return "Data deleted successfully!";
    }

}
