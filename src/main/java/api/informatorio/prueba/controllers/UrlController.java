package api.informatorio.prueba.controllers;
import api.informatorio.prueba.entities.Url;
import api.informatorio.prueba.entities.UrlDTO;
import api.informatorio.prueba.services.IUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/url")
public class UrlController {
    @Autowired
    IUrlService iUrlService;
    @PostMapping
    public ResponseEntity<?> createUrl(Url url){
        iUrlService.createUrl(url);
        return ResponseEntity.status(HttpStatus.OK).body("Url created");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUrl(@PathVariable("id") Long id){
        iUrlService.deleteUrl(id);
        return ResponseEntity.status(HttpStatus.OK).body("Url eliminated");
    }
    @GetMapping("/{id}")
    public UrlDTO findUrl(@PathVariable("id") Long id){
        return iUrlService.findUrl(id);
    }
}
