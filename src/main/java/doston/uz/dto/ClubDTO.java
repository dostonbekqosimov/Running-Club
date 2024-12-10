package doston.uz.dto;

import doston.uz.model.UserEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClubDTO {

    private Long id;
    @NotEmpty(message = "Club title should not be empty")
    private String title;
    @NotEmpty(message = "photoUrl should not be empty")
    private String photoUrl;
    @NotEmpty(message = "Content should not be empty")
    private String content;
    private UserEntity createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<EventDTO> events;
}
