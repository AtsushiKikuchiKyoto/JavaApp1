package in.techcamp.firstapp;

import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class KaikeiFinbookController {

    private final KaikeiGroupRepository kaikeiGroupRepository;

    @GetMapping("/kaikei/finbook/{id}")
    public String showGroupById(@PathVariable("id") Long id, Model model){
        var group = kaikeiGroupRepository.findById(id);
        model.addAttribute("group", group);
        return "finbook";
    }
}
