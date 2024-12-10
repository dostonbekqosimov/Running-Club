package doston.uz.service;

import doston.uz.dto.EventDTO;

import java.util.List;


public interface EventService {
    void createEvent(Long clubId, EventDTO evenDTO);

    void updateEvent( EventDTO evenDTO);

    void deleteEvent(Long id);

    EventDTO findEventById(Long id);

    List<EventDTO> findAllEvents();

    List<EventDTO> searchEvents(String name);


}
