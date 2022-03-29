package api.informatorio.prueba.controllers;
import api.informatorio.prueba.entities.Vote;
import api.informatorio.prueba.services.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    IVoteService iVoteService;

    @PostMapping("/create/user/{idUser}/startup/{idSt}")
    public ResponseEntity<?> createVote (@PathVariable("idUser") Long userId,@PathVariable("idSt") Long startupId,@Valid @RequestBody Vote vote){
        iVoteService.createVote(userId,startupId,vote);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Vote getVoteById(@PathVariable Long id){
        return iVoteService.findById(id);
    }

    @GetMapping("/voteUser/{id}")
    public Set<Vote> getVotesByUser(@PathVariable("id") Long id){
        return iVoteService.getVotesByUser(id);
    }

}
