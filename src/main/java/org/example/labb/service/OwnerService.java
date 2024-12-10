package org.example.labb.service;

import org.example.labb.entity.Jokey;
import org.example.labb.entity.Owner;
import org.example.labb.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public List<Owner> getAllOwners() {
        return (List<Owner>) ownerRepository.findAll();
    }

    public Optional<Owner> getOwnerById(long id) {
        return ownerRepository.findById(id);
    }

    public Owner updateOwner(long id, Owner newOwner) {
        Owner owner = ownerRepository.findById(id).orElseThrow(() -> new RuntimeException("Owner not found"));
        owner.setName(newOwner.getName());
        return ownerRepository.save(owner);
    }

    public void deleteOwner(long id) {
        ownerRepository.deleteById(id);
    }
}
