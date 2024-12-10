package doston.uz.mapper;

import doston.uz.dto.EventDTO;
import doston.uz.model.Event;

public class EventMapper {

    public static EventDTO mapToEventDTO(Event event) {
        return EventDTO.builder()
                .id(event.getId())
                .name(event.getName())
                .photoUrl(event.getPhotoUrl())
                .type(event.getType())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .createdAt(event.getCreatedAt())
                .updatedAt(event.getUpdatedAt())
                .club(event.getClub())
                .build();
    }

    public static Event mapToEvent(EventDTO evenDTO) {
        return Event.builder()
                .id(evenDTO.getId())
                .name(evenDTO.getName())
                .photoUrl(evenDTO.getPhotoUrl())
                .type(evenDTO.getType())
                .startTime(evenDTO.getStartTime())
                .endTime(evenDTO.getEndTime())
                .createdAt(evenDTO.getCreatedAt())
                .updatedAt(evenDTO.getUpdatedAt())
                .club(evenDTO.getClub())
                .build();
    }
}
