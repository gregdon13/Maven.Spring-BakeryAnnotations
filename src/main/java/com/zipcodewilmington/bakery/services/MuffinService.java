package com.zipcodewilmington.bakery.services;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.repositories.MuffinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MuffinService {
    @Autowired
    private MuffinRepository repository;

    public MuffinService(MuffinRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/muffin")
    public Iterable<Muffin> index() {
        return repository.findAll();
    }

    @GetMapping("/muffin/{id}")
    public Muffin show(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/muffin")
    public Muffin create(Muffin baker) {
        return repository.save(baker);
    }

    @PutMapping("/muffin/{id}")
    public Muffin update(Long id, Muffin newMuffinData) {
        Muffin originalMuffin = repository.findById(id).get();
        originalMuffin.setFlavor(newMuffinData.getFlavor());
        return repository.save(originalMuffin);
    }

    @DeleteMapping("/muffin/{id}")
    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
