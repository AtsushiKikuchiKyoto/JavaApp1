package in.techcamp.firstapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KaikeiPageController {
    @GetMapping("/kaikei")
    public String showTop(){
        return "kaikei";
    }

    @GetMapping("/kaikei/finbook")
    public String showFinbook(){
        return "finbook";
    }

    @GetMapping("/kaikei/finbookForm")
    public String showFinbookForm(){
        return "finbookForm";
    }

    @GetMapping("/kaikei/finsheet")
    public String showFinsheet(){
        return "finsheet";
    }

    @GetMapping("/kaikei/finsheetForm")
    public String showFinsheetForm(){
        return "finsheetForm";
    }
}
