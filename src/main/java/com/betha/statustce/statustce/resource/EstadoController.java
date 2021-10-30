package com.betha.statustce.statustce.resource;

import com.betha.statustce.statustce.model.Estado;
import com.betha.statustce.statustce.model.Pais;
import com.betha.statustce.statustce.repository.EstadoRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {
    @Autowired
    private EstadoRepository repository;

    @GetMapping
    public List<EstadoDTO> getEstado(@QuerydslPredicate(root = Estado.class) Predicate predicate){
        List<EstadoDTO> result = new ArrayList<>();
        Iterable<Estado> all = repository.findAll(predicate);
        all.forEach(f -> result.add(EstadoDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public EstadoDTO getEstadosId(@PathVariable(value = "id") Long estadoId) throws EntityNotFoundException {
        Estado estadoFind = repository.findById(estadoId).orElseThrow(() -> new EntityNotFoundException("Estado não encontado com o ID"+ estadoId));
        return EstadoDTO.toDTO(estadoFind);
    }

    @PostMapping
    public EstadoDTO create(@Valid @RequestBody Estado estado){
        return EstadoDTO.toDTO(repository.save(estado));
    }

    @PutMapping("/{id}")
    public EstadoDTO update(@PathVariable(value = "id") Long estadoId,
                             @RequestBody Estado estado) throws EntityNotFoundException {
        Estado estadoFind = repository.findById(estadoId).orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID :: " + estadoId));
        estadoFind.setId(estado.getId());

        return EstadoDTO.toDTO(repository.save(estadoFind));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long estadoID) throws EntityNotFoundException{
        Estado estadoFind = repository.findById(estadoID).orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com o ID::"+estadoID));
        repository.delete(estadoFind);
        return ResponseEntity.noContent().build();
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
