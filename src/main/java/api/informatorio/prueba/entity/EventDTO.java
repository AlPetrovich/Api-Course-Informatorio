package api.informatorio.prueba.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter @Setter
public class EventDTO {
    private Long id;
    private String state;
    private String descriptionEvent;
    private Date creationDate;
    private Date closureDate;
    private double prize;
    private Set<Startup> startupSet;
}
