package com.betha.statustce.statustce.resource;

import com.betha.statustce.statustce.model.Assunto;
import com.betha.statustce.statustce.repository.AssuntoRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/api/assunto")
public class AssuntoController {
    @Autowired
    private AssuntoRepository repository;

    @GetMapping
    public List<AssuntoDTO> getAssunto(@QuerydslPredicate(root = Assunto.class) Predicate predicate){
        List<AssuntoDTO> result = new ArrayList<>();
        Iterable<Assunto> all = repository.findAll(predicate);
        all.forEach(f -> result.add(AssuntoDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public AssuntoDTO getAssuntoId(@PathVariable(value = "id") Long assuntoId) throws EntityNotFoundException {
        Assunto assuntoFind = repository.findById(assuntoId).orElseThrow(() -> new EntityNotFoundException("Assunto não encontado com o ID"+ assuntoId));
        return AssuntoDTO.toDTO(assuntoFind);
    }

    @PostMapping
    public AssuntoDTO create(@Valid @RequestBody Assunto assunto){
        return AssuntoDTO.toDTO(repository.save(assunto));
    }

    @PutMapping("/{id}")
    public AssuntoDTO update(@PathVariable(value = "id") Long assuntoId,
                               @RequestBody Assunto assunto) throws EntityNotFoundException{
        Assunto assuntoFind = repository.findById(assuntoId).orElseThrow(() -> new EntityNotFoundException("Assunto não encontrado com Id:: "+assuntoId));
        assuntoFind.setId(assunto.getId());

        return AssuntoDTO.toDTO(repository.save(assuntoFind));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long assuntoId) throws EntityNotFoundException{
        Assunto assuntoFind = repository.findById(assuntoId).orElseThrow(() -> new EntityNotFoundException("Assunto não encontrado com o ID::"+ assuntoId));
        repository.delete(assuntoFind);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
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