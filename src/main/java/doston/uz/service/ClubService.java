package doston.uz.service;

import doston.uz.dto.ClubDTO;
import doston.uz.model.Club;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClubService {
    public List<ClubDTO> findAllClubs(); // <1>

    Club saveClub(ClubDTO club);

    ClubDTO findClubById(Long id);

    void updateClub( ClubDTO clubDTO);

    void deleteClubById(Long id);

    List<ClubDTO> searchClubs(String title);
}
