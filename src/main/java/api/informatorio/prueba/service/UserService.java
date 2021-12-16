package api.informatorio.prueba.service;

import api.informatorio.prueba.entity.User;
import api.informatorio.prueba.entity.UserDTO;
import api.informatorio.prueba.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User modifyUser(Long id,User user) {
        User userM= userRepository.getById(id);
        if (!user.getName().trim().isEmpty()) { userM.setName(user.getName());}
        if (!user.getLastname().trim().isEmpty()) { userM.setLastname(user.getLastname()); }
        if (!user.getEmail().trim().isEmpty()){userM.setEmail(user.getEmail());}
        if (!user.getPassword().trim().isEmpty()){userM.setPassword(user.getPassword());}
        if (!user.getCity().trim().isEmpty()){userM.setCity(user.getCity());}
        if (!user.getProvince().trim().isEmpty()){userM.setProvince(user.getProvince());}
        if (!user.getCountry().trim().isEmpty()){userM.setCountry(user.getCountry());}
        if (user.getType() != null){ userM.setType(user.getType());}
        userM.setCreationDate(user.getCreationDate());
        return userRepository.save(userM);
    }

    @Override
    public UserDTO findUser(Long id) {
        UserDTO userDTO= null;
        Optional<User> user=userRepository.findById(id);
        if (user.isPresent()){
            userDTO= mapper.convertValue(user, UserDTO.class);
        }
        return userDTO;
    }

    @Override
    public Collection<UserDTO> getAll() {
        List<User> userList=userRepository.findAll();
        Set<UserDTO> userDTOSet= new HashSet<>();
        for (User user: userList){
            userDTOSet.add(mapper.convertValue(user, UserDTO.class));
        }
        return userDTOSet;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Set<UserDTO> getUsersByCity(String city) {
        Set<User> userSet=userRepository.getUserByCity(city);
        Set<UserDTO> userDTOSet= new HashSet<>();
        for(User user: userSet){
            userDTOSet.add(mapper.convertValue(user, UserDTO.class));
        }
        return userDTOSet;
    }

    @Override
    public Set<UserDTO> getUserByDate(Date creationDate) {
        Set<User> userSet=userRepository.getUserbyDate(creationDate);
        Set<UserDTO> userDTOSet= new HashSet<>();
        for (User user: userSet){
            userDTOSet.add(mapper.convertValue(user,UserDTO.class));
        }
        return userDTOSet;
    }
}
