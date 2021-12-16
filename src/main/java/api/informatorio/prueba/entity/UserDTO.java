package api.informatorio.prueba.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;


@Getter @Setter
public class UserDTO {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String city;
    private String province;
    private String country;
    private Type type;
    private Date creationDate;
    private Set<Vote> voteSet;
}
