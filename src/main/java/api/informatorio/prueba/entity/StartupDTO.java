package api.informatorio.prueba.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter @Setter
public class StartupDTO {

    private Long id;
    private String name;
    private String description;
    private double objective;
    private boolean published;
    private Set<Url> urlSet;
    private Set<Tag> tagSet;
    private Date creationDate;
}
