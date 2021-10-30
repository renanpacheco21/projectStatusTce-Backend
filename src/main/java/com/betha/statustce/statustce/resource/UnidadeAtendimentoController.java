package com.betha.statustce.statustce.resource;


import com.betha.statustce.statustce.model.Estado;
import com.betha.statustce.statustce.model.UnidadeAtendimento;
import com.betha.statustce.statustce.repository.EstadoRepository;
import com.betha.statustce.statustce.repository.UnidadeAtendimentoRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/unidadeatendimento")

public class UnidadeAtendimentoController {
    @Autowired
    private UnidadeAtendimentoRepository repository;

    @GetMapping
    public  List<UnidadeAtendimentoDTO> getUnidadeAtendimento(@QuerydslPredicate(root = UnidadeAtendimento.class) Predicate predicate){
        List<UnidadeAtendimentoDTO> result = new ArrayList<>();
        Iterable<UnidadeAtendimento> all = repository.findAll(predicate);
        all.forEach(f-> result.add(UnidadeAtendimentoDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public UnidadeAtendimentoDTO getUnidadeAtendimentoId(@PathVariable(value = "id") Long unidadeAtendimentoId) throws EntityNotFoundException {
        UnidadeAtendimento unidadeAtendimentoFind = repository.findById(unidadeAtendimentoId).orElseThrow(() -> new EntityNotFoundException("Unidade de atendimento não encontrado com o ID: "+unidadeAtendimentoId));
        return UnidadeAtendimentoDTO.toDTO(unidadeAtendimentoFind);
    }

    @PostMapping
    public UnidadeAtendimentoDTO create(@Valid @RequestBody UnidadeAtendimento unidadeAtendimento){
        return UnidadeAtendimentoDTO.toDTO(repository.save(unidadeAtendimento));
    }

    @PutMapping("/{id}")
    public UnidadeAtendimentoDTO update(@PathVariable(value = "id") Long unidadeAtendimentoId,
                            @RequestBody UnidadeAtendimento unidadeatendimento) throws EntityNotFoundException {
        UnidadeAtendimento unidadeAtendimentoFind = repository.findById(unidadeAtendimentoId).orElseThrow(() -> new EntityNotFoundException("Unidade de atendimento não encontrado com ID :: " +unidadeAtendimentoId));
        unidadeAtendimentoFind.setId(unidadeatendimento.getId());

        return UnidadeAtendimentoDTO.toDTO(repository.save(unidadeAtendimentoFind));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long unidadeAtendimentoId) throws EntityNotFoundException{
        UnidadeAtendimento unidadeAtendimentoFind = repository.findById(unidadeAtendimentoId).orElseThrow(() -> new EntityNotFoundException("Unidade de atendimento não encontrado com ID :: " +unidadeAtendimentoId));
        repository.delete(unidadeAtendimentoFind);
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

