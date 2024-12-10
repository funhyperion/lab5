package org.example.labb.service;

import org.example.labb.entity.Horse;
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

    public Horse createHorse(Horse horse) {
        return horseRepository.save(horse);
    };

    public List<Horse> getAllHorses() {
        List<Horse> horses = new ArrayList<>();
        try{
            Iterable<Horse> iterable = horseRepository.findAll();
            for (Horse horse : iterable) {
                horses.add(horse);
            }
        }
        catch (Exception e) {
            System.out.println("Помилка при отриманні коней: " + e.getMessage());
        }
        return horses;
    }

    public Optional<Horse> getHorseById(int id) {
        return horseRepository.findById(id);
    }

    public Horse updateHorse(int id,Horse newHorse) {
        Horse horse = horseRepository.findById(id).orElseThrow(() -> new RuntimeException("dfsdfsdf"));
        horse.setNickname(newHorse.getNickname());
        return horseRepository.save(horse);
    }

    public void deleteHorse(int id) {
        horseRepository.deleteById(id);
    }
}
