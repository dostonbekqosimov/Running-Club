package doston.uz.repository;

import doston.uz.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClubRepository extends JpaRepository<Club, Long> {

    @Query("SELECT c FROM Club c WHERE LOWER(c.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Club> searchClubs(String title);
}
