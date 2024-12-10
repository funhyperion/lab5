package org.example.labb.controller;

import org.example.labb.entity.Owner;
import org.example.labb.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/owners")
    public String showOwners(Model model) {
        List<Owner> owners = ownerService.getAllOwners();
        model.addAttribute("owners", owners);
        return "owners";
    }

    @GetMapping("/showNewOwnerForm")
    public String showNewOwnerForm(Model model) {
        Owner owner = new Owner();
        model.addAttribute("owner", owner);
        return "new_owner";
    }

    @PostMapping("/saveOwner")
    public String saveOwner(@ModelAttribute("owner") Owner owner) {
        ownerService.createOwner(owner);
        return "redirect:/owners";
    }

    @GetMapping("/showFormForUpdateOwner/{id}")
    public String showFormForUpdateOwner(@PathVariable(value = "id") long id, Model model) {
        Owner owner = ownerService.getOwnerById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
        model.addAttribute("owner", owner);
        return "update_owner";
    }

    @PostMapping("/updateOwner/{id}")
    public String updateOwner(@PathVariable(value = "id") int id, @ModelAttribute("owner") Owner newOwner) {
        ownerService.updateOwner(id, newOwner);
        return "redirect:/owners";
    }

    @GetMapping("/deleteOwner/{id}")
    public String deleteOwner(@PathVariable(value = "id") int id) {
        this.ownerService.deleteOwner(id);
        return "redirect:/owners";
    }
}
