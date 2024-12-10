package doston.uz.mapper;

import doston.uz.dto.ClubDTO;
import doston.uz.model.Club;

import java.util.stream.Collectors;

public class ClubMapper {

    public static ClubDTO mapToClubDTO(Club club) {
        return ClubDTO.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdBy(club.getCreatedBy())
                .createdAt(club.getCreatedAt())
                .updatedAt(club.getUpdatedAt())
                .events(club.getEvents().stream().map(EventMapper::mapToEventDTO).collect(Collectors.toList()))
                .build();
    }

    public static Club mapToClub(ClubDTO club) {
        return Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdBy(club.getCreatedBy())
                .createdAt(club.getCreatedAt())
                .updatedAt(club.getUpdatedAt())
                .build();
    }
}
