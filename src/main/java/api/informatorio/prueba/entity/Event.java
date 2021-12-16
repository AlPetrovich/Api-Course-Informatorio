package api.informatorio.prueba.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Getter @Setter
@Table(name = "Events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "el descriptionEvent nombre no puede estar vacio")
    @Size(min=3, max = 255, message = "el campo descriptionEvent debe tener entre 4 y 255 caracteres")
    private String descriptionEvent;

    private boolean active;

    private Date creationDate;

    private Date closureDate;

    @NotEmpty(message = "el campo state no puede estar vacio")
    @Size(min=3, max = 255, message = "el campo state debe tener entre 4 y 255 caracteres")
    private String state; //abierto - en curso - finalizado

    @Min(value = 0, message = "El campo prize debe ser mayor o igual a cero")
    private double prize;


    @ManyToMany(mappedBy ="eventSet")
    @JsonIgnoreProperties({"creator","tagSet"})
    @OrderBy("counterVote DESC")
    private Set<Startup> startupSet;


    public void addStartup(Startup startup){
        startupSet.add(startup);
        startup.addEvent(this);
    }
    public void removeStartup(Startup startup){
        startupSet.remove(startup);
        startup.addEvent(null);
    }

}
