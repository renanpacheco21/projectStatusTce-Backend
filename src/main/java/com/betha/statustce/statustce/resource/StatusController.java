package com.betha.statustce.statustce.resource;
import com.betha.statustce.statustce.model.Status;
import com.betha.statustce.statustce.repository.StatusRepository;
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
@RequestMapping("/api/status")
public class StatusController {
    @Autowired
    private StatusRepository repository;

    @GetMapping
    public List<StatusDTO> getStatus(@QuerydslPredicate(root = Status.class) Predicate predicate){
        List<StatusDTO> result = new ArrayList<>();
        Iterable<Status> all = repository.findAll(predicate);
        all.forEach(f -> result.add(StatusDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public StatusDTO getStatusId(@PathVariable(value = "id") Long statusId) throws EntityNotFoundException {
        Status statusFind = repository.findById(statusId).orElseThrow(() -> new EntityNotFoundException("Status não encontado com o ID"+ statusId));
        return StatusDTO.toDTO(statusFind);
    }

    @PostMapping
    public StatusDTO create(@Valid @RequestBody Status status){
        return StatusDTO.toDTO(repository.save(status));
    }

    @PutMapping("/{id}")
    public StatusDTO update(@PathVariable(value = "id") Long statusId,
                            @RequestBody Status status) throws EntityNotFoundException {
        Status statusFind = repository.findById(statusId).orElseThrow(() -> new EntityNotFoundException("Status não encontrado com ID :: " + statusId));
        statusFind.setId(status.getId());
        statusFind.setDescricao(status.getDescricao());
        return StatusDTO.toDTO(repository.save(statusFind));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long statusId) throws EntityNotFoundException{
        Status statusFind = repository.findById(statusId).orElseThrow(() -> new EntityNotFoundException("Status não encontrado com o ID::"+ statusId));
        repository.delete(statusFind);
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
