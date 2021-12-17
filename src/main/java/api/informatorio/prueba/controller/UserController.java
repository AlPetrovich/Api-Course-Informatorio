package api.informatorio.prueba.controller;

import api.informatorio.prueba.entity.User;
import api.informatorio.prueba.entity.UserDTO;
import api.informatorio.prueba.exception.CustomException;
import api.informatorio.prueba.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/users") //localhost:8080/users
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/add")  //localhost:8080/users
    public ResponseEntity<?> addUser(@Valid @RequestBody User user, Errors errors){
        if (errors.hasErrors()){
            throwError(errors);
        }
        iUserService.createUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/list") //localhost:8080/users/list
    public Collection<UserDTO> listUsers(){
        return iUserService.getAll();
    }

    @GetMapping("/{id}")  //localhost:8080/users/1
    public UserDTO getUser(@PathVariable Long id){
        return iUserService.findUser(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        iUserService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User eliminated");
    }

    @PutMapping("/{id}")
    public User modifyUser(@PathVariable("id") Long id,@Valid @RequestBody User user,Errors errors){
        if (errors.hasErrors()){
            throwError(errors);
        }
        return iUserService.modifyUser(id,user);
    }

    @GetMapping("/list/city")
    public Set<UserDTO> getUsersByCity(@RequestParam String city){
        return iUserService.getUsersByCity(city);
    }

    @GetMapping("list/date")
    public Set<UserDTO> getUserByDate(@RequestParam Date creationDate){
        return iUserService.getUserByDate(creationDate);
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
