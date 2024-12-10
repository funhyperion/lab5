package org.example.labb.repository;

import org.example.labb.entity.Horse;
import org.springframework.data.repository.CrudRepository;


public interface HorseRepository extends  CrudRepository<Horse, Integer>{
}
