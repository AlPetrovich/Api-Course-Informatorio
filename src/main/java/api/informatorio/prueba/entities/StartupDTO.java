package api.informatorio.prueba.entities;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
public class StartupDTO {
    private Long id;
    private String name;
    private String description;
    private double objective;
    private boolean published;
    private Set<Url> urlSet = new HashSet<>();
    private Set<Tag> tagSet;
    private Date creationDate;
}
