package in.techcamp.firstapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
@AllArgsConstructor
public class KaikeiFinbookController {

    private static final Logger log = LoggerFactory.getLogger(KaikeiFinbookController.class);
    private final KaikeiGroupRepository kaikeiGroupRepository;
    private final KaikeiFinbookRepository kaikeiFinbookRepository;

    @GetMapping("/kaikei/finbook/{id}")
    public String showGroupById(@PathVariable("id") Long id, Model model){
        try {
            var group = kaikeiGroupRepository.findById(id);
            model.addAttribute("group", group);
            var finbookList = kaikeiFinbookRepository.findByGroupId(id);
            model.addAttribute("finbookList", finbookList);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
        return "error";
        }
        return "finbook";
    }

    @GetMapping("/kaikei/finbookForm/{id}")
    public String showFinbookForm(@PathVariable("id") Long id, Model model ){
        var group = kaikeiGroupRepository.findById(id);

        LocalDate today = LocalDate.now();
        int currentYear = today.getYear();

        var form = new KaikeiFinbookForm();
        form.setName(group.getName());
        form.setGroupId(group.getId());
        form.setFiscalYear(currentYear);
        form.setStartDate(LocalDate.of(currentYear, 4, 1));
        form.setEndDate(LocalDate.of(currentYear + 1, 3, 31));

        log.info("Start Date: {}", form.getStartDate());
        log.info("End Date: {}", form.getEndDate());

        model.addAttribute("group", group);
        model.addAttribute("finbookForm", form);
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

    @PostMapping("/kaikei/finbook/{id}/delete")
    public String deleteFinbook(@PathVariable Long id, Model model ){
        try {
            kaikeiFinbookRepository.deleteById(id);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return  "redirect:/kaikei/group";
    }

}
