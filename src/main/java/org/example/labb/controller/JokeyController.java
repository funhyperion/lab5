package org.example.labb.controller;

import org.example.labb.entity.Horse;
import org.example.labb.entity.Jokey;
import org.example.labb.service.HorseService;
import org.example.labb.service.JokeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class JokeyController {

    @Autowired
    private JokeyService jokeyService;
    @Autowired
    private HorseService horseService;

    @GetMapping("/jokeys")
    public String showJokeys(Model model) {
        List<Jokey> jokeys = jokeyService.getAllJokeys();
        model.addAttribute("jokeys", jokeys);
        return "jokeys";
    }

    @GetMapping("/showNewJokeyForm")
    public String showNewJokeyForm(Model model) {
        Jokey jokey = new Jokey();
        model.addAttribute("jokey", jokey);
        return "new_jokey";
    }

    @PostMapping("/saveJokey")
    public String saveJokey(@ModelAttribute("jokey") Jokey jokey) {
        jokeyService.createJokey(jokey);
        return "redirect:/jokeys";
    }

    @GetMapping("/showFormForUpdateJokey/{id}")
    public String showFormForUpdateJokey(@PathVariable(value = "id") int id, Model model) {
        Jokey jokey = jokeyService.getJokeyById(id).orElseThrow(() -> new RuntimeException("Jokey not found"));
        model.addAttribute("jokey", jokey);
        return "update_jokey";
    }

    @PostMapping("/updateJokey/{id}")
    public String updateJokey(@PathVariable(value = "id") int id, @ModelAttribute("jokey") Jokey newJokey) {
        jokeyService.updateJokey(id, newJokey);
        return "redirect:/jokeys";
    }

    @GetMapping("/deleteJokey/{id}")
    public String deleteJokey(@PathVariable(value = "id") int id) {
        this.jokeyService.deleteJokey(id);
        return "redirect:/jokeys";
    }

    @GetMapping("/jokey/{jokeyId}/horses")
    public String showJokeyHorses(@PathVariable Long jokeyId, Model model) {
        Jokey jokey = jokeyService.getJokeyById(jokeyId);
        List<Horse> horses = horseService.getHorsesByJokey(jokey);
        model.addAttribute("jokey", jokey);
        model.addAttribute("horses", horses);
        return "jokeyHorses";
    }

    // Добавление лошади к жокею
    @PostMapping("/jokey/{jokeyId}/addHorse")
    public String addHorseToJokey(@PathVariable Long jokeyId, @RequestParam int horseId) {
        jokeyService.addHorseToJokey(jokeyId, horseId);
        return "redirect:/jokey/" + jokeyId + "/horses";
    }

    // Удаление лошади от жокея
    @PostMapping("/jokey/{jokeyId}/removeHorse")
    public String removeHorseFromJokey(@PathVariable Long jokeyId, @RequestParam int horseId) {
        jokeyService.removeHorseFromJokey(jokeyId, horseId);
        return "redirect:/jokey/" + jokeyId + "/horses";
    }

}
