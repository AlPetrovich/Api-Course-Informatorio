package api.informatorio.prueba.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter
@Table(name = "Urls")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "the url field cannot be empty")
    @Size(min=3, max = 255, message = "the url field must contain between 3 and 255 characters")
    private String url;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "startup_id", nullable = false)
    @JsonIgnore
    private Startup startup;
}
