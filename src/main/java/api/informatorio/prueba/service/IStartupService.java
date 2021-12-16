package api.informatorio.prueba.service;

import api.informatorio.prueba.entity.Startup;
import api.informatorio.prueba.entity.StartupDTO;

import java.util.Collection;
import java.util.Set;

public interface IStartupService {

    public StartupDTO findStartup(Long id);

    public Collection<StartupDTO> getAll();

    public void deactivateStartup(Long id);

    public void activateStartup(Long id);

    public void updateStartup(Startup startup);

    public Set<StartupDTO> getStartupByPublished(boolean published);

    Set<StartupDTO> getByLike(String name);

   Startup save(Long userId, Startup startup);


}
