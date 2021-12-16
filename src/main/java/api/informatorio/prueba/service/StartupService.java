package api.informatorio.prueba.service;

import api.informatorio.prueba.entity.Startup;
import api.informatorio.prueba.entity.StartupDTO;
import api.informatorio.prueba.entity.Tag;
import api.informatorio.prueba.entity.User;
import api.informatorio.prueba.repository.IStartupRepository;
import api.informatorio.prueba.repository.ITagRepository;
import api.informatorio.prueba.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StartupService implements IStartupService{

    @Autowired
    IStartupRepository startupRepository;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    ITagRepository tagRepository;
    @Autowired
    ObjectMapper mapper;


    @Override
    public StartupDTO findStartup(Long id) {
        Optional<Startup> startup =startupRepository.findById(id);
        StartupDTO startupDTO= null;
        if (startup.isPresent()){
            startupDTO = mapper.convertValue(startup, StartupDTO.class);
        }
        return startupDTO;
    }

    @Override
    public Collection<StartupDTO> getAll() {
        List<Startup> startupList=startupRepository.findAll();
        Set<StartupDTO> startupDTOSet= new HashSet<>();
        for (Startup startup: startupList){
            startupDTOSet.add(mapper.convertValue(startup, StartupDTO.class));
        }
        return startupDTOSet;
    }

    @Override
    public void deactivateStartup(Long id) {
        Startup startup= startupRepository.getById(id);
        startup.setPublished(false);
        startupRepository.save(startup);
    }

    @Override
    public void activateStartup(Long id) {
        Startup startup= startupRepository.getById(id);
        startup.setPublished(true);
        startupRepository.save(startup);
    }

    @Override
    public void updateStartup(Startup startup) {
        startupRepository.save(startup);
    }


    @Override
    public Set<StartupDTO> getStartupByPublished(boolean published) {
        Set<Startup> startupSet=startupRepository.getStartupByPublished(published);
        Set<StartupDTO> startupDTOSet= new HashSet<>();

        for (Startup startup: startupSet){
            startupDTOSet.add(mapper.convertValue(startup,StartupDTO.class));
        }
        return startupDTOSet;
    }

    @Override
    public Set<StartupDTO> getByLike(String name) {
        Tag tag= tagRepository.getByTag(name);
        Set<Startup> startupSet=tag.getStartupSet();
        Set<StartupDTO> startupDTOSet= new HashSet<>();
        for (Startup startup: startupSet){
            startupDTOSet.add(mapper.convertValue(startup, StartupDTO.class));
        }
        return startupDTOSet;
    }

    @Override
    public Startup save(Long userId, Startup startup) {
        User user = userRepository.getById(userId);
        startup.setCreator(user);
        return startupRepository.save(startup);
    }

}
