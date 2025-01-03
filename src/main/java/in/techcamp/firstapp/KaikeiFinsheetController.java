package in.techcamp.firstapp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class KaikeiFinsheetController {

    private final KaikeiGroupRepository kaikeiGroupRepository;
    private final KaikeiFinbookRepository kaikeiFinbookRepository;


    @GetMapping("/kaikei/finsheet/{id}")
    public String showFinsheetById(@PathVariable("id") Long id, Model model){

        return "finsheet";
    }
}
