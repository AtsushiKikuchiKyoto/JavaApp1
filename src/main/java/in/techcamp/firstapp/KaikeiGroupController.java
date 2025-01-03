package in.techcamp.firstapp;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class KaikeiGroupController {

    private final KaikeiGroupRepository kaikeiGroupRepository;

    @Autowired
    private KaikeiGroupService kaikeiGroupService;

    @GetMapping("/kaikei/group")
    public String showGroup(Model model){
        var groupList = kaikeiGroupRepository.findAll();
        model.addAttribute("groupList", groupList);
        return "group";
    }

    @GetMapping("/kaikei/groupForm")
    public String showGroupForm(@ModelAttribute("groupForm") KaikeiGroupForm form) {
        return "groupForm";
    }

    @PostMapping("/kaikei/groupForm")
    public String createGroup(KaikeiGroupForm kaikeiGroupForm, Model model){
        try {
            kaikeiGroupRepository.insert(kaikeiGroupForm.getName(), kaikeiGroupForm.getInfo());
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return  "redirect:/kaikei/group";
    }

    @GetMapping("/kaikei/groupForm/{id}")
    public String updateGroupForm(@PathVariable long id, Model model){
        KaikeiGroupDTO group = kaikeiGroupService.getGroupById(id);
        model.addAttribute("group", group);
        return "groupFormUpdate";
    }

    @PostMapping("/kaikei/group/{id}/update")
    public String updateGroup(@PathVariable long id, KaikeiGroupForm kaikeiGroupForm){
        kaikeiGroupRepository.update(id, kaikeiGroupForm.getName(), kaikeiGroupForm.getInfo());
        return  "redirect:/kaikei/finbook/" + id;
    }

    @PostMapping("/kaikei/group/{id}/delete")
    public String deleteGroup(@PathVariable Long id, Model model ){
        try {
            kaikeiGroupRepository.deleteById(id);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return  "redirect:/kaikei/group";
    }
}
