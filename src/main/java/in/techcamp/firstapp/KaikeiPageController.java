package in.techcamp.firstapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KaikeiPageController {
    @GetMapping("/kaikei")
    public String showTop(){
        return "kaikei";
    }
}
