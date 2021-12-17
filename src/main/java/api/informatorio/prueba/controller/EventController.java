package api.informatorio.prueba.controller;


import api.informatorio.prueba.entity.Event;
import api.informatorio.prueba.entity.EventDTO;
import api.informatorio.prueba.entity.Startup;
import api.informatorio.prueba.entity.StartupDTO;
import api.informatorio.prueba.exception.CustomException;
import api.informatorio.prueba.service.IEventService;
import api.informatorio.prueba.service.IStartupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/events")
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

    //Ranking
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
