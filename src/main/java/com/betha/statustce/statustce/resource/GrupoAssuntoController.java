package com.betha.statustce.statustce.resource;
import com.betha.statustce.statustce.model.GrupoAssunto;
import com.betha.statustce.statustce.repository.GrupoAssuntoRepository;
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
@RequestMapping("/api/grupoassunto")
public class GrupoAssuntoController {
    @Autowired
    private GrupoAssuntoRepository repository;

    @GetMapping
    public List<GrupoAssuntoDTO> getGrupoAssunto(@QuerydslPredicate(root = GrupoAssunto.class) Predicate predicate){
        List<GrupoAssuntoDTO> result = new ArrayList<>();
        Iterable<GrupoAssunto> all = repository.findAll(predicate);
        all.forEach(f -> result.add(GrupoAssuntoDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public GrupoAssuntoDTO getGrupoAssuntoId(@PathVariable(value = "id") Long grupoAssuntoId) throws EntityNotFoundException {
        GrupoAssunto grupoAssuntoFind = repository.findById(grupoAssuntoId).orElseThrow(() -> new EntityNotFoundException("Grupo de Assunto não encontado com o ID"+ grupoAssuntoId));
        return GrupoAssuntoDTO.toDTO(grupoAssuntoFind);
    }

    @PostMapping
    public GrupoAssuntoDTO create(@Valid @RequestBody GrupoAssunto grupoAssunto){
        return GrupoAssuntoDTO.toDTO(repository.save(grupoAssunto));
    }

    @PutMapping("/{id}")
    public GrupoAssuntoDTO update(@PathVariable(value = "id") Long grupoAssuntoId,
                            @RequestBody GrupoAssunto grupoAssunto) throws EntityNotFoundException {
        GrupoAssunto grupoAssuntoFind = repository.findById(grupoAssuntoId).orElseThrow(() -> new EntityNotFoundException("Grupo de Assunto não encontado com o ID"+ grupoAssuntoId));
        grupoAssuntoFind.setId(grupoAssunto.getId());
        grupoAssuntoFind.setDescricao(grupoAssunto.getDescricao());
        return GrupoAssuntoDTO.toDTO(repository.save(grupoAssuntoFind));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long grupoAssuntoId) throws EntityNotFoundException{
        GrupoAssunto grupoAssuntoFind = repository.findById(grupoAssuntoId).orElseThrow(() -> new EntityNotFoundException("Grupo de Assunto não encontado com o ID"+ grupoAssuntoId));
        repository.delete(grupoAssuntoFind);
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
