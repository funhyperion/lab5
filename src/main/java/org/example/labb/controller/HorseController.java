package org.example.labb.controller;

import org.example.labb.entity.Horse;
import org.example.labb.service.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HorseController {
    @Autowired
    private HorseService horseService;

    @GetMapping("/horses")
    public String showHorses(Model model) {
        List<Horse> horses = horseService.getAllHorses();
        model.addAttribute("horses", horses);
        return "horses";
    }

    @GetMapping("/showNewHorseForm")
    public String showNewHorseForm(Model model) {
        Horse horse = new Horse();
        model.addAttribute("horse", horse);
        return "new_horse";
    }

    @PostMapping("/saveHorse")
    public String saveHorse(@ModelAttribute("horse") Horse horse) {
        horseService.createHorse(horse);
        return "redirect:/horses";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        Horse horse = horseService.getHorseById(id).orElseThrow(() -> new RuntimeException("Horse not found"));
        model.addAttribute("horse", horse);
        return "update_horse";
    }

    @PostMapping("/updateHorse/{id}")
    public String updateHorse(@PathVariable(value = "id") int id, @ModelAttribute("horse") Horse newHorse) {
        horseService.updateHorse(id, newHorse);
        return "redirect:/horses";
    }

    @GetMapping("/deleteHorse/{id}")
    public String deleteHorse(@PathVariable(value = "id") int id) {
        this.horseService.deleteHorse(id);
        return "redirect:/horses";
    }
}
