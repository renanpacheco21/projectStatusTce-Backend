package com.betha.statustce.statustce.resource;


import com.betha.statustce.statustce.model.Estado;
import com.betha.statustce.statustce.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {
    @Autowired
    private EstadoRepository repository;

    @GetMapping
    public List<EstadoDTO> getEstado(){
        return repository.findAll().stream().map(e-> EstadoDTO.toDTO(e)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Estado getEstadosId(@PathVariable(value = "id") Long estadoId) throws EntityNotFoundException {
        Estado estadoFind = repository.findById(estadoId).orElseThrow(() -> new EntityNotFoundException("Estado não encontado com o ID"+ estadoId));
        return estadoFind;
    }

    @PostMapping
    public Estado create(@Valid @RequestBody Estado estado){
        return repository.save(estado);
    }

    @PutMapping("/{id}")
    public Estado update(@PathVariable(value = "id") Long estadoID, @RequestBody Estado estado) throws EntityNotFoundException{
        Estado estadoFind = repository.findById(estadoID).orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com Id:: "+estadoID));
        estadoFind.setId(estado.getId());
        estadoFind.setNome(estado.getNome());
        estadoFind.setPopulacao(estado.getPopulacao());

        return repository.save(estadoFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long estadoID) throws EntityNotFoundException{
        Estado estadoFind = repository.findById(estadoID).orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com o ID::"+estadoID));
        repository.delete(estadoFind);
        return ResponseEntity.noContent().build();
    }

}
