package api.informatorio.prueba.services;
import api.informatorio.prueba.entities.Startup;
import api.informatorio.prueba.entities.StartupDTO;
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
