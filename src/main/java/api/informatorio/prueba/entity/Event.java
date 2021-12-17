package api.informatorio.prueba.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Getter @Setter
@Table(name = "Events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "the DESCRIPTION field cannot be empty")
    @Size(min=3, max = 255, message = "the descriptionEvent field must contain between 4 and 255 characters")
    private String descriptionEvent;


    private boolean active;

    @NotNull(message = "creationDate cannot be null")
    private Date creationDate;

    @NotNull(message = "closureDate cannot be null")
    private Date closureDate;

    @NotEmpty(message = "the STATE field cannot be empty")
    @Size(min=3, max = 255, message = "the state field must contain between 4 and 255 characters")
    private String state;

    @Min(value = 0, message = "the prize field must be greater or equal to zero")
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
