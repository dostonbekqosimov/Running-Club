package doston.uz.repository;

import doston.uz.model.Club;
import doston.uz.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT c FROM Event c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Event> searchEvents(String name);
}
