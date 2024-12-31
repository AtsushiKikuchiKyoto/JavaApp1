package in.techcamp.firstapp;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class KaikeiGroupController {

    private final KaikeiGroupRepository kaikeiGroupRepository;

    @GetMapping("/kaikei/group")
    public String showGroup(Model model){
        var groupList = kaikeiGroupRepository.findAll();
        model.addAttribute("groupList", groupList);
        return "group";
    }

    @GetMapping("/kaikei/groupForm")
    public String showGroupForm(@ModelAttribute("groupForm") GroupForm form){
        return "groupForm";
    }

    @PostMapping("/kaikei/groupForm")
    public String createGroup(GroupForm groupForm, Model model){
        try {
            kaikeiGroupRepository.insert(groupForm.getName(), groupForm.getInfo());
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return  "redirect:/kaikei/group";
    };
}
