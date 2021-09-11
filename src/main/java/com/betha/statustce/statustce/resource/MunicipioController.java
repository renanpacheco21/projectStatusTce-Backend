package com.betha.statustce.statustce.resource;


import com.betha.statustce.statustce.model.Estado;
import com.betha.statustce.statustce.model.Municipio;
import com.betha.statustce.statustce.model.Pais;
import com.betha.statustce.statustce.repository.EstadoRepository;
import com.betha.statustce.statustce.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/municipios")
public class MunicipioController {
    @Autowired
    private MunicipioRepository repository;

    @GetMapping
    public List<Municipio> getMunicipio(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Municipio getEstadosId(@PathVariable(value = "id") Long municipioId) throws EntityNotFoundException {
        Municipio municipioFind = repository.findById(municipioId).orElseThrow(() -> new EntityNotFoundException("Município não encontado com o ID"+ municipioId));
        return municipioFind;
    }

    @PostMapping
    public Municipio create(@RequestBody Municipio municipio){
        return repository.save(municipio);
    }

    @PutMapping("/{id}")
    public Municipio update(@PathVariable(value = "id") Long municipioId, @RequestBody Municipio pais) throws EntityNotFoundException{
        Municipio municipioFind = repository.findById(municipioId).orElseThrow(() -> new EntityNotFoundException("Município não encontrado com Id:: "+ municipioId));
        municipioFind.setId(pais.getId());
        municipioFind.setNome(pais.getNome());
        municipioFind.setPopulacao(pais.getPopulacao());

        return repository.save(municipioFind);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long municipioId) throws EntityNotFoundException{
        Municipio municipioFind = repository.findById(municipioId).orElseThrow(() -> new EntityNotFoundException("Municipio não encontrado com o ID::"+ municipioId));
        repository.delete(municipioFind);
        return ResponseEntity.noContent().build();
    }
}