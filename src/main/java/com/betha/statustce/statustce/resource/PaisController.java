package com.betha.statustce.statustce.resource;

import com.betha.statustce.statustce.model.Estado;
import com.betha.statustce.statustce.model.Pais;
import com.betha.statustce.statustce.repository.PaisRepository;
import com.querydsl.core.types.Predicate;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @GetMapping
    public List<PaisDTO> getPais(@QuerydslPredicate(root = Pais.class) Predicate predicate){
        List<PaisDTO> result = new ArrayList<>();
        Iterable<Pais> all = repository.findAll(predicate);
        all.forEach(f -> result.add(PaisDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public PaisDTO getPaisesId(@PathVariable(value = "id") Long paisId) throws EntityNotFoundException{
        Pais paisFind = repository.findById(paisId).orElseThrow(() -> new EntityNotFoundException("País não encontado com o ID"+ paisId));
        return PaisDTO.toDTO(paisFind);
    }

    @PostMapping
    public PaisDTO create(@Valid @RequestBody Pais pais){
        return PaisDTO.toDTO(repository.save(pais));
    }

    @PutMapping("/{id}")
    public PaisDTO update(@PathVariable(value = "id") Long paisId,
                          @RequestBody Pais pais) throws EntityNotFoundException{
     Pais paisFind = repository.findById(paisId).orElseThrow(() -> new EntityNotFoundException("Pais não encontrado com Id:: "+paisId));
     paisFind.setId(pais.getId());

     return PaisDTO.toDTO(repository.save(paisFind));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long paisId) throws EntityNotFoundException{
        Pais paisFind = repository.findById(paisId).orElseThrow(() -> new EntityNotFoundException("País não encontrado com o ID::"+paisId));
        repository.delete(paisFind);
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