package com.betha.statustce.statustce.resource;

import com.betha.statustce.statustce.model.Pais;
import com.betha.statustce.statustce.repository.PaisRepository;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @GetMapping
    public List<Pais> getPaises(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Pais getPaisesId(@PathVariable(value = "id") Long paisId) throws EntityNotFoundException{
        Pais paisFind = repository.findById(paisId).orElseThrow(() -> new EntityNotFoundException("País não encontado com o ID"+ paisId));
        return paisFind;
    }

    @PostMapping
    public Pais create(@RequestBody Pais pais){
        return repository.save(pais);
    }

}
