package org.example.labb.service;

import org.example.labb.entity.Horse;
import org.example.labb.entity.Jokey;
import org.example.labb.repository.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HorseService {

    @Autowired
    private HorseRepository horseRepository;

    public List<Horse> getHorsesByJokey(Jokey jokey) {
        return horseRepository.findByJokeysContains(jokey);
    }

    public Horse createHorse(Horse horse) {
        return horseRepository.save(horse);
    }

    public List<Horse> getAllHorses() {
        return (List<Horse>) horseRepository.findAll();
    }

    public Optional<Horse> getHorseById(int id) {
        return horseRepository.findById(id);
    }

    public Horse updateHorse(int id, Horse horse) {
        Horse existingHorse = horseRepository.findById(id).orElseThrow(() -> new RuntimeException("Horse not found"));
        existingHorse.setNickname(horse.getNickname());
        return horseRepository.save(existingHorse);
    }

    public void deleteHorse(int id) {
        horseRepository.deleteById(id);
    }

}
