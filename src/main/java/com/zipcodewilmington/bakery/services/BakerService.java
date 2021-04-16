package com.zipcodewilmington.bakery.services;

import com.zipcodewilmington.bakery.models.Baker;
import com.zipcodewilmington.bakery.repositories.BakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BakerService {
    @Autowired
    private BakerRepository repository;

    public BakerService(BakerRepository repository) {
        this.repository = repository;
    }

    public Iterable<Baker> index() {
        return repository.findAll();
    }

    public Baker show(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    public Baker create(Baker baker) {
        return repository.save(baker);
    }

    public Baker update(@PathVariable Long id, Baker newBakerData) {
        Baker originalBaker = repository.findById(id).get();
        originalBaker.setName(newBakerData.getName());
        originalBaker.setSpecialty(newBakerData.getSpecialty());
        return repository.save(originalBaker);
    }

    public Boolean delete(@PathVariable Long id) {
        repository.deleteById(id);
        return true;
    }
}
