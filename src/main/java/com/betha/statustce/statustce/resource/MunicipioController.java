package com.betha.statustce.statustce.resource;

import com.betha.statustce.statustce.model.Municipio;
import com.betha.statustce.statustce.repository.MunicipioRepository;
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
@RequestMapping("/api/municipios")
public class MunicipioController {
    @Autowired
    private MunicipioRepository repository;

    @GetMapping
    public List<MunicipioDTO> getMunicipio(@QuerydslPredicate(root = Municipio.class) Predicate predicate){
        List<MunicipioDTO> result = new ArrayList<>();
        Iterable<Municipio> all = repository.findAll(predicate);
        all.forEach(f -> result.add(MunicipioDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public MunicipioDTO getMunicipioId(@PathVariable(value = "id") Long municipioId) throws EntityNotFoundException{
        Municipio municipioFind = repository.findById(municipioId).orElseThrow(() -> new EntityNotFoundException("Município não encontado com o ID"+ municipioId));
        return MunicipioDTO.toDTO(municipioFind);
    }

    @PostMapping
    public MunicipioDTO create(@Valid @RequestBody Municipio municipio){
        return MunicipioDTO.toDTO(repository.save(municipio));
    }

    @PutMapping("/{id}")
    public MunicipioDTO update(@PathVariable(value = "id") Long municipioId,
                               @RequestBody Municipio municipio) throws EntityNotFoundException{
        Municipio municipioFind = repository.findById(municipioId).orElseThrow(() -> new EntityNotFoundException("Municipio não encontrado com Id:: "+municipioId));
        municipioFind.setId(municipio.getId());
        municipioFind.setNome(municipio.getNome());
        municipioFind.setPopulacao(municipio.getNome());
        return MunicipioDTO.toDTO(repository.save(municipioFind));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long municipioId) throws EntityNotFoundException{
        Municipio municipioFind = repository.findById(municipioId).orElseThrow(() -> new EntityNotFoundException("Municipio não encontrado com o ID::"+ municipioId));
        repository.delete(municipioFind);
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