package api.informatorio.prueba.entity;




import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "Startups")

public class Startup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "el campo name no puede estar vacio")
    @Size(min=3, max = 255, message = "el campo name debe tener entre 4 y 255 caracteres")
    private String name;

    @NotEmpty(message = "el campo description no puede estar vacio")
    @Size(min=3, max = 255, message = "el description name debe tener entre 4 y 255 caracteres")
    private String description;

    @NotEmpty(message = "el campo content no puede estar vacio")
    @Size(min=3, max = 255, message = "el campo content debe tener entre 4 y 255 caracteres")
    private String content;

    private Date creationDate;

    @Min(value = 0, message = "El campo objective debe ser mayor o igual a cero")
    private double objective;

    //@NotEmpty(message = "el campo published no puede estar vacio")
    private boolean published;

    private int counterVote;

    @ManyToOne(fetch = FetchType.LAZY)
    private User creator;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Tag> tagSet = new HashSet<Tag>();


    @OneToMany(mappedBy = "startup")
    @JsonIgnore
    private Set<Vote> voteSet;


    @OneToMany(mappedBy = "startup")
    @JsonIgnore
    private Set<Url> urlSet;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Event> eventSet;

    public void addUrl(Url url){
        urlSet.add(url);
        url.setStartup(this);
    }
    public void removeUrl(Url url){
        urlSet.remove(url);
        url.setStartup(null);
    }
    public void addEvent(Event event) {
        if (this.eventSet == null) {
            this.eventSet = new HashSet<>();
        }
        this.eventSet.add(event);
    }
    public void addTags(Tag tag) {
        tagSet.add(tag);
        tag.getStartupSet().add(this);
    }

}
