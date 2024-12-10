package org.example.labb.repository;

import org.example.labb.entity.Horse;
import org.example.labb.entity.Jokey;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface HorseRepository extends  CrudRepository<Horse, Integer>{
    List<Horse> findByJokeysContains(Jokey jokey);
}
