package api.informatorio.prueba.controller;


import api.informatorio.prueba.entity.Startup;
import api.informatorio.prueba.entity.StartupDTO;
import api.informatorio.prueba.exception.CustomException;
import api.informatorio.prueba.service.IStartupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<?> updateStartup(@Valid @RequestBody Startup startup, Errors errors){
        if (errors.hasErrors()){
            throwError(errors);
        }
        iStartupService.updateStartup(startup);
        return ResponseEntity.status(HttpStatus.OK).body("Startup updated");
    }
    @GetMapping("/list/published")
    public Set<StartupDTO> getStartupByPublished(@RequestParam boolean published){
        return iStartupService.getStartupByPublished(published);
    }
    @PostMapping("/user/{id}/startup")
    public ResponseEntity<?> saveStartup(@PathVariable("id") Long userId,@Valid @RequestBody Startup startup, Errors errors){
        if (errors.hasErrors()){
            throwError(errors);
        }
        iStartupService.save(userId, startup);
        return ResponseEntity.status(HttpStatus.CREATED).body("CREATED");

    }
    @GetMapping("/likeTag")
    public Set<StartupDTO> getAllStartupByLike(@RequestParam("name") String name){
        return iStartupService.getByLike(name);
    }
    public void throwError(Errors errors){
        String message = "";
        int index = 0;
        for (ObjectError r: errors.getAllErrors()){
            if (index > 0){
                message += " | ";
            }
            message += String.format("Parameter: %s - Message: %s ", r.getObjectName(), r.getDefaultMessage());
        }
        throw new CustomException(message);
    }

}
