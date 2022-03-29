package api.informatorio.prueba.entities;
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
    @NotEmpty(message = "the NAME field cannot be empty")
    @Size(min=3, max = 255, message = "the name field must contain between 4 and 255 characters")
    private String name;
    @NotEmpty(message = "the DESCRIPTION field cannot be empty")
    @Size(min=3, max = 255, message = "the description field must contain between 4 and 255 characters")
    private String description;
    @NotEmpty(message = "the CONTENT field cannot be empty")
    @Size(min=3, max = 255, message = "the content field must contain between 4 and 255 characters")
    private String content;
    private Date creationDate;
    @Min(value = 0, message = "the objective field must be greater or equal to zero")
    private double objective;
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
    private Set<Url> urlSet;
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Event> eventSet;
    public void addUrl(Url url){
        urlSet.add(url);
        url.setStartup(this);
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
