package doston.uz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String photoUrl;

    private String type;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(columnDefinition = "timestamp(6)")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

}
