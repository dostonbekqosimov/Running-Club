package doston.uz.controller;

import doston.uz.dto.ClubDTO;
import doston.uz.model.Club;
import doston.uz.service.ClubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("")
    public String getClubPage(Model model) {
        List<ClubDTO> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        model.addAttribute("title", "Clubs");
        return "clubs-list";
    }

    @GetMapping("/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        model.addAttribute("title", "Create Club");
        return "clubs-form";
    }

    @GetMapping("/{clubId}")
    public String clubDetail(@PathVariable("clubId") Long id, Model model) {
        ClubDTO clubDTO = clubService.findClubById(id);
        model.addAttribute("club", clubDTO);
        model.addAttribute("title", "Club Detail");
        return "clubs-detail";
    }


    @GetMapping("/{id}/edit")
    public String editClubForm(Model model, @PathVariable("id") Long id) {
        ClubDTO clubDTO = clubService.findClubById(id);
        model.addAttribute("club", clubDTO);
        model.addAttribute("title", "Edit Club");
        return "clubs-edit";
    }

    @GetMapping("/search")
    public String searchClub(@RequestParam(value = "title") String title, Model model){
        List<ClubDTO> clubs = clubService.searchClubs(title);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") Long id){
        clubService.deleteClubById(id);
        return "redirect:/clubs";
    }

    @PostMapping("/save")
    public String saveClub(@Valid @ModelAttribute("club") ClubDTO club,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "clubs-form";
        }
        clubService.saveClub(club);
        return "redirect:/clubs";
    }

    @PostMapping("/{id}/edit")
    public String updateClub(@PathVariable("id") Long id,
                             @Valid @ModelAttribute("club") ClubDTO clubDTO,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "clubs-edit";
        }
        clubDTO.setId(id);
        clubService.updateClub(clubDTO);

        return "redirect:/clubs";
    }
}


