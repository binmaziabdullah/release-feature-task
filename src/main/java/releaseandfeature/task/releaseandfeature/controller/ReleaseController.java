package releaseandfeature.task.releaseandfeature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import releaseandfeature.task.releaseandfeature.service.ReleaseService;
import releaseandfeature.task.releaseandfeature.enum_release.ReleaseStatus;
import releaseandfeature.task.releaseandfeature.model.Release;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/releases")
public class ReleaseController {

    @Autowired
    private ReleaseService releaseService;

    @PostMapping
    public ResponseEntity<Release> saveOrUpdate(@RequestBody Release release) {
        Release releases =  releaseService.saveOrUpdate(release);
        return ResponseEntity.ok(releases);
    }

    @GetMapping
    public ResponseEntity<List<Release>> getAllRelease() {
        List<Release> releaseList = releaseService.getAllReleases();
        return ResponseEntity.ok(releaseList);
    }

    @GetMapping("/findEnums")
    public List<Release> getALlReleaseByStatus(@PathParam(value = "status") ReleaseStatus status) {
        return releaseService.getReleaseByStatus(status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Release> getReleaseById(@PathVariable Long id) {
        Release release = releaseService.getById(id);
        return ResponseEntity.ok(release);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Release> deleteById(@PathVariable Long id) {
        Release release = releaseService.deleteById(id);
        return ResponseEntity.ok(release);
    }

}
