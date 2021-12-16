package api.informatorio.prueba.service;

import api.informatorio.prueba.entity.*;
import api.informatorio.prueba.repository.IEventRepository;
import api.informatorio.prueba.repository.IStartupRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EventService implements IEventService{

    @Autowired
    IEventRepository iEventRepository;
    @Autowired
    IStartupRepository iStartupRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void createEvent(Event event) {
        iEventRepository.save(event);
    }

    @Override
    public EventDTO findEventById(Long id) {
        Optional<Event> event = iEventRepository.findById(id);
        EventDTO eventDTO= null;
        if (event.isPresent()){
            eventDTO = mapper.convertValue(event, EventDTO.class);
        }
        return eventDTO;

    }


    @Override
    public Set<EventDTO> getAllEvents() {
        List<Event> events=iEventRepository.findAll();
        Set<EventDTO> eventDTOSet = new HashSet<>();
        for (Event event: events){
            eventDTOSet.add(mapper.convertValue(event, EventDTO.class));
        }
        return eventDTOSet;
    }

    @Override
    public void updateEvent(Event event) {
        iEventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        iEventRepository.deleteById(id);
    }

    @Override
    public Set<Event> getEventsByPrize() {
        return iEventRepository.getEventByPrize();
    }

    @Override
    public void deactivateEvent(Long id) {
        Event event= iEventRepository.getById(id);
        event.setActive(false);
        iEventRepository.save(event);
    }

    @Override
    public void activateEvent(Long id) {
        Event event= iEventRepository.getById(id);
        event.setActive(true);
        iEventRepository.save(event);
    }

    @Override
    public Optional<Event> ranking(Long id) {
        return iEventRepository.findById(id);
    }

}
