package org.example.labb.repository;

import org.example.labb.entity.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository  extends CrudRepository<Owner, Long> {
}
