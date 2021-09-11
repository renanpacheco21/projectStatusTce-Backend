package com.betha.statustce.statustce.resource;


import com.betha.statustce.statustce.model.Estado;
import com.betha.statustce.statustce.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/municipios")
public class MunicipioController {
    @Autowired
    private EstadoRepository repository;

    @GetMapping
    public List<Estado> getMunicipio(){
        return repository.findAll();
    }
}
