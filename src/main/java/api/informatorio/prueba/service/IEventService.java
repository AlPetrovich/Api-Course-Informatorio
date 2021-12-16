package api.informatorio.prueba.service;

import api.informatorio.prueba.entity.Event;
import api.informatorio.prueba.entity.EventDTO;


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
