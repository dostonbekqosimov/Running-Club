package doston.uz.service.impl;

import doston.uz.dto.EventDTO;
import doston.uz.model.Club;
import doston.uz.model.Event;
import doston.uz.repository.ClubRepository;
import doston.uz.repository.EventRepository;
import doston.uz.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static doston.uz.mapper.EventMapper.mapToEvent;
import static doston.uz.mapper.EventMapper.mapToEventDTO;

@Service
public class EventServiceImpl implements EventService {


    private final EventRepository eventRepository;
    private final ClubRepository clubRepository;


    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDTO evenDTO) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(evenDTO);

        event.setClub(club);
        eventRepository.save(event);
    }


    @Override
    public void updateEvent(EventDTO evenDTO) {
        Event event = mapToEvent(evenDTO);
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {

        eventRepository.deleteById(id);

    }

    @Override
    public EventDTO findEventById(Long id) {
        Event event = eventRepository.findById(id).get();
        return mapToEventDTO(event);
    }

    @Override
    public List<EventDTO> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map((event -> mapToEventDTO(event))).collect(Collectors.toList());
    }

    @Override
    public List<EventDTO> searchEvents(String name) {

        List<Event> events = eventRepository.searchEvents(name);
        return events.stream().map((event -> mapToEventDTO(event))).collect(Collectors.toList());
    }


}
