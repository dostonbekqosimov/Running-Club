package doston.uz.service.impl;

import doston.uz.dto.ClubDTO;
import doston.uz.model.Club;
import doston.uz.model.UserEntity;
import doston.uz.repository.ClubRepository;
import doston.uz.repository.UserRepository;
import doston.uz.security.SecurityUtil;
import doston.uz.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static doston.uz.mapper.ClubMapper.*;

@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    private final UserRepository userRepository;


    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository, UserRepository userRepository) {
        this.clubRepository = clubRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ClubDTO> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club -> mapToClubDTO(club))).collect(Collectors.toList());
    }

    // There is a bug
    @Override
    public Club saveClub(ClubDTO clubDTO) {

        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByEmail(username);
        Club club = mapToClub(clubDTO);
        club.setCreatedBy(user);
        return clubRepository.save(club);
    }

    @Override
    public ClubDTO findClubById(Long id) {
        Club club = clubRepository.findById(id).orElse(null);
        if (club != null) {
            return mapToClubDTO(club);
        }
        return null;
    }

    @Override
    public void updateClub(ClubDTO clubDTO) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user = userRepository.findByUsername(username);
        Club club = mapToClub(clubDTO);
        club.setCreatedBy(user);
        clubRepository.save(club);

    }

    @Override
    public void deleteClubById(Long id) {
        Club club = clubRepository.findById(id).get();
        clubRepository.delete(club
        );
    }

    @Override
    public List<ClubDTO> searchClubs(String title) {
        List<Club> clubs = clubRepository.searchClubs(title);

        return clubs.stream().map((club -> mapToClubDTO(club))).collect(Collectors.toList());

    }


}
