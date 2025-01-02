package in.techcamp.firstapp;

import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
@AllArgsConstructor
public class KaikeiFinbookController {

    private final KaikeiGroupRepository kaikeiGroupRepository;
    private final KaikeiFinbookRepository kaikeiFinbookRepository;

    @GetMapping("/kaikei/finbook/{id}")
    public String showGroupById(@PathVariable("id") Long id, Model model){
        var group = kaikeiGroupRepository.findById(id);
        model.addAttribute("group", group);
        return "finbook";
    }

    @GetMapping("/kaikei/finbookForm")
    public String showFinbookForm(@ModelAttribute("finbookForm") KaikeiFinbookForm form ){
        return "finbookForm";
    }

    @PostMapping("/kaikei/finbookForm")
    public String createFinbook(KaikeiFinbookForm kaikeiFinbookForm, Model model){
        try {
            kaikeiFinbookRepository.insert(
                    kaikeiFinbookForm.getName(),
                    kaikeiFinbookForm.getFiscalYear(),
                    kaikeiFinbookForm.getStartDate(),
                    kaikeiFinbookForm.getEndDate(),
                    kaikeiFinbookForm.getGroupId()
            );
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return  "redirect:/kaikei";
    }
}
