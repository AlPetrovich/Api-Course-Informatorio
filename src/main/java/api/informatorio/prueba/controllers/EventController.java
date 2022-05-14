package api.informatorio.prueba.controllers;
import api.informatorio.prueba.entities.Event;
import api.informatorio.prueba.entities.EventDTO;
import api.informatorio.prueba.exceptions.CustomException;
import api.informatorio.prueba.services.IEventService;
import api.informatorio.prueba.services.IStartupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("api/events")
public class EventController {

    @Autowired
    IEventService iEventService;

    @Autowired
    IStartupService iStartupService;

    @PostMapping("/created")
    public ResponseEntity<?> addEvent(@Valid @RequestBody Event event, Errors errors){
        if (errors.hasErrors()){
            throwError(errors);
        }
        iEventService.createEvent(event);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<?> deactivateEvent(@PathVariable Long id){
        iEventService.deactivateEvent(id);
        return ResponseEntity.status(HttpStatus.OK).body("Event successfully deactivate!");
    }

    @PutMapping("/activate/{id}")
    public ResponseEntity<?> activateStartup(@PathVariable Long id){
        iEventService.activateEvent(id);
        return ResponseEntity.status(HttpStatus.OK).body("Event successfully activate!");
    }

    @GetMapping("/{id}")
    public EventDTO findEventById(@PathVariable("id") Long id){
        return iEventService.findEventById(id);
    }

    @GetMapping("/list")
    public Set<EventDTO> getAllEvents(){
        return iEventService.getAllEvents();
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEvent(@Valid @RequestBody Event event, Errors errors){
        if (errors.hasErrors()){
            throwError(errors);
        }
        iEventService.updateEvent(event);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long id){
        iEventService.deleteEvent(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/orderPrize")
    public Set<Event> getEventByPrize(){
        return iEventService.getEventsByPrize();
    }

    @GetMapping("/ranking/{id}")
    public ResponseEntity<?> ranking(@PathVariable("id") Long id){
        return new ResponseEntity<>(iEventService.ranking(id), HttpStatus.OK);
    }
    public void throwError(Errors errors){
        String message = "";
        int index = 0;
        for (ObjectError r: errors.getAllErrors()){
            if (index > 0){
                message += " | ";
            }
            message += String.format("Parametro: %s - Message: %s ", r.getObjectName(), r.getDefaultMessage());
        }
        throw new CustomException(message);
    }
}
