package api.informatorio.prueba.controllers;
import api.informatorio.prueba.entities.Startup;
import api.informatorio.prueba.entities.StartupDTO;
import api.informatorio.prueba.exceptions.CustomException;
import api.informatorio.prueba.services.IStartupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("api/startup")
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/deactivate/{id}")
    public ResponseEntity<?> deactivateStartup(@PathVariable Long id){
         iStartupService.deactivateStartup(id);
         return ResponseEntity.status(HttpStatus.OK).body("Startup successfully deactivate!");
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/activate/{id}")
    public ResponseEntity<?> activateStartup(@PathVariable Long id){
        iStartupService.activateStartup(id);
        return ResponseEntity.status(HttpStatus.OK).body("Startup successfully activate!");
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
