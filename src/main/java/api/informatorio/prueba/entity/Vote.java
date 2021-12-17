package api.informatorio.prueba.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "Votes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vote{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "the generatedBy field cannot be empty")
    @Size(min=3, max = 255, message = "the generatedBy field must contain between 3 and 255 characters")
    private String generatedBy;
    private Date creationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "startup_id", nullable = false)
    @JsonIgnore
    private Startup startup;
}
