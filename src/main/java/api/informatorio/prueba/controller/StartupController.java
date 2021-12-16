package api.informatorio.prueba.controller;


import api.informatorio.prueba.entity.Startup;
import api.informatorio.prueba.entity.StartupDTO;
import api.informatorio.prueba.service.IStartupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/startup")
public class StartupController {
    @Autowired
    IStartupService iStartupService;


    @GetMapping("/{id}")
    public StartupDTO findStartup(@PathVariable Long id){
        return iStartupService.findStartup(id);
    }

    @GetMapping("/list")
    public Collection<StartupDTO> getAll(){
        return iStartupService.getAll();
    }


    @PutMapping("/deactivate/{id}")
    public ResponseEntity<?> deactivateStartup(@PathVariable Long id){
         iStartupService.deactivateStartup(id);
         return ResponseEntity.status(HttpStatus.OK).body("Startup successfully deactivate!");
    }

    @PutMapping("/activate/{id}")
    public ResponseEntity<?> activateStartup(@PathVariable Long id){
        iStartupService.activateStartup(id);
        return ResponseEntity.status(HttpStatus.OK).body("Startup successfully activate!");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStartup(@RequestBody Startup startup){
        iStartupService.updateStartup(startup);
        return ResponseEntity.status(HttpStatus.OK).body("Startup updated");
    }


    @GetMapping("/list/published")
    public Set<StartupDTO> getStartupByPublished(@RequestParam boolean published){
        return iStartupService.getStartupByPublished(published);
    }

    @PostMapping("/user/{id}/startup")
    public ResponseEntity<?> saveStartup(@PathVariable("id") Long userId, @RequestBody Startup startup){
        iStartupService.save(userId, startup);
        return ResponseEntity.status(HttpStatus.CREATED).body("CREATED");
    }



    @GetMapping("/likeTag")
    public Set<StartupDTO> getAllStartupByLike(@RequestParam("name") String name){
        return iStartupService.getByLike(name);
    }
}
