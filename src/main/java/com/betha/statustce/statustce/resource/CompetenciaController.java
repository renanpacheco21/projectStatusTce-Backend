package com.betha.statustce.statustce.resource;

import com.betha.statustce.statustce.model.Competencia;
import com.betha.statustce.statustce.repository.CompetenciaRepository;
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
@RequestMapping("/api/competencia")
public class CompetenciaController {
    @Autowired
    private CompetenciaRepository repository;

    @GetMapping
    public List<CompetenciaDTO> getCompetencia(@QuerydslPredicate(root = Competencia.class) Predicate predicate){
        List<CompetenciaDTO> result = new ArrayList<>();
        Iterable<Competencia> all = repository.findAll(predicate);
        all.forEach(f -> result.add(CompetenciaDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public CompetenciaDTO getCompetenciaId(@PathVariable(value = "id") Long competenciaId) throws EntityNotFoundException {
        Competencia competenciaFind = repository.findById(competenciaId).orElseThrow(() -> new EntityNotFoundException("Competência não encontado com o ID"+ competenciaId));
        return CompetenciaDTO.toDTO(competenciaFind);
    }

    @PostMapping
    public CompetenciaDTO create(@Valid @RequestBody Competencia competencia){
        return CompetenciaDTO.toDTO(repository.save(competencia));
    }

    @PutMapping("/{id}")
    public CompetenciaDTO update(@PathVariable(value = "id") Long competenciaId,
                             @RequestBody Competencia competencia) throws EntityNotFoundException{
        Competencia competenciaFind = repository.findById(competenciaId).orElseThrow(() -> new EntityNotFoundException("Competência não encontrado com Id:: "+ competenciaId));
        competenciaFind.setId(competencia.getId());

        return CompetenciaDTO.toDTO(repository.save(competenciaFind));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long competenciaId) throws EntityNotFoundException{
        Competencia competenciaFind = repository.findById(competenciaId).orElseThrow(() -> new EntityNotFoundException("Competência não encontrado com o ID::"+ competenciaId));
        repository.delete(competenciaFind);
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