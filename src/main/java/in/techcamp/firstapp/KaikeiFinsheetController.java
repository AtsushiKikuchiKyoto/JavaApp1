package in.techcamp.firstapp;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class KaikeiFinsheetController {

    private final KaikeiFinbookRepository kaikeiFinbookRepository;

    @Autowired
    private FinbookService service;

    @GetMapping("/kaikei/finsheet/{id}")
    public String showFinsheetById(@PathVariable("id") Long id, Model model){
        FinbookWithGroupDTO finbook = service.getFinbookWithGroupName(id);
//        var finbook = kaikeiFinbookRepository.findByIdBindGroupName(id);
        model.addAttribute("finbook", finbook);
        return "finsheet";
    }
}
