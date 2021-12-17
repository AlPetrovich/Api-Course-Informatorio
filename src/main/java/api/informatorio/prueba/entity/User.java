package api.informatorio.prueba.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Getter @Setter
@Table(name = "Users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "the NAME field cannot be empty")
    @Size(min=3, max = 255, message = "the name field must contain between 4 and 255 characters")
    private String name;
    @NotEmpty(message = "the LASTNAME field cannot be empty")
    @Size(min=2, max = 255, message = "the lastname field must contain between 4 and 255 characters")
    private String lastname;
    @NotEmpty(message = "the EMAIL field cannot be empty")
    @Column(unique = true, length = 255)
    @Email(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    //@Size(min=4, max = 255, message = "the email field must contain between 4 and 255 characters")
    private String email;
    @NotEmpty(message = "the PASSWORD field cannot be empty")
    @Size(min=4, max = 255, message = "the password field must contain between 4 and 255 characters")
    private String password;
    @NotNull(message = "the Date field cannot be null")
    private Date creationDate;
    @NotEmpty(message = "the CITY field cannot be empty")
    @Size(min=4, max = 255, message = "the city field must contain between 4 and 255 characters")
    private String city;
    @NotEmpty(message = "the PROVINCE field cannot be empty")
    @Size(min=4, max = 255, message = "the province field must contain between 4 and 255 characters")
    private String province;
    @NotEmpty(message = "the COUNTRY field cannot be empty")
    @Size(min=4, max = 255, message = "the country field must contain between 4 and 255 characters")
    private String country;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Type type;
    @OneToMany(mappedBy = "user")
    private Set<Vote> voteSet= new HashSet<>();
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Startup> startupSet = new HashSet<>();
     public void addVote(Vote vote){
       voteSet.add(vote);
       vote.setUser(this);
    }
    public void removeVote(Vote vote){
        voteSet.remove(vote);
        vote.setUser(this);
    }
    public void addStartup(Startup startup) {
        startupSet.add(startup);
        startup.setCreator(this);
    }
    public void removeStartup(Startup startup) {
        startupSet.remove(startup);
        startup.setCreator(null);
    }

}

