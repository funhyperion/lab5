package org.example.labb.service;

import org.example.labb.entity.Horse;
import org.example.labb.entity.Jokey;
import org.example.labb.repository.JokeyRepository;
import org.example.labb.repository.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JokeyService {

    @Autowired
    private JokeyRepository jokeyRepository;
    @Autowired
    private HorseRepository horseRepository;

    public Jokey createJokey(Jokey jokey) {
        return jokeyRepository.save(jokey);
    }

    public List<Jokey> getAllJokeys() {
        return (List<Jokey>) jokeyRepository.findAll();
    }

    public Optional<Jokey> getJokeyById(long id) {
        return jokeyRepository.findById(id);
    }

    public Jokey updateJokey(long id, Jokey jokey) {
        Jokey existingJokey = jokeyRepository.findById(id).orElseThrow(() -> new RuntimeException("Jokey not found"));
        existingJokey.setName(jokey.getName());
        return jokeyRepository.save(existingJokey);
    }

    public void deleteJokey(long id) {
        jokeyRepository.deleteById(id);
    }


    public Jokey getJokeyById(Long id) {
        return jokeyRepository.findById(id).orElseThrow(() -> new RuntimeException("Jokey not found"));
    }

    public void addHorseToJokey(Long jokeyId, int horseId) {
        Jokey jokey = jokeyRepository.findById(jokeyId).orElseThrow(() -> new RuntimeException("Jokey not found"));
        Horse horse = horseRepository.findById(horseId).orElseThrow(() -> new RuntimeException("Horse not found"));

        jokey.getHorses().add(horse);
        horse.getJokey().add(jokey);

        jokeyRepository.save(jokey);
        horseRepository.save(horse);
    }

    public void removeHorseFromJokey(Long jokeyId, int horseId) {
        Jokey jokey = jokeyRepository.findById(jokeyId).orElseThrow(() -> new RuntimeException("Jokey not found"));
        Horse horse = horseRepository.findById(horseId).orElseThrow(() -> new RuntimeException("Horse not found"));

        jokey.getHorses().remove(horse);
        horse.getJokey().remove(jokey);

        jokeyRepository.save(jokey);
        horseRepository.save(horse);
    }

}

