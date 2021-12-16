package api.informatorio.prueba.service;


import api.informatorio.prueba.entity.User;
import api.informatorio.prueba.entity.UserDTO;

import java.util.Collection;
import java.util.Date;
import java.util.Set;


public interface IUserService {

    public void createUser(User user);


    public User modifyUser(Long id,User user);

    public UserDTO findUser(Long id);

    public Collection<UserDTO> getAll();

    public void deleteUser(Long id);

    Set<UserDTO> getUsersByCity(String city);

    Set<UserDTO> getUserByDate(Date creationDate);
}
