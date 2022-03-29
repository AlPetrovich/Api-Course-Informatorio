package api.informatorio.prueba.services;
import api.informatorio.prueba.entities.Event;
import api.informatorio.prueba.entities.EventDTO;
import java.util.Optional;
import java.util.Set;

public interface IEventService {
    public void createEvent(Event event);
    public EventDTO findEventById(Long id);
    public Set<EventDTO> getAllEvents();
    public  void updateEvent(Event event);
    public void deleteEvent(Long id);
    public Set<Event> getEventsByPrize();
    public void deactivateEvent(Long id);
    public void activateEvent(Long id);
    public Optional<Event> ranking(Long id);
}
