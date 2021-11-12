package com.betha.statustce.statustce.resource;
import com.betha.statustce.statustce.model.EmpresaAtendimento;
import com.betha.statustce.statustce.repository.EmpresaAtendimentoRepository;
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
@RequestMapping("/api/empresaatendimento")
public class EmpresaAtendimentoController {
    @Autowired
    private EmpresaAtendimentoRepository repository;

    @GetMapping
    public List<EmpresaAtendimentoDTO> getEmpresaAtendimento(@QuerydslPredicate(root = EmpresaAtendimento.class) Predicate predicate){
        List<EmpresaAtendimentoDTO> result = new ArrayList<>();
        Iterable<EmpresaAtendimento> all = repository.findAll(predicate);
        all.forEach(f -> result.add(EmpresaAtendimentoDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public EmpresaAtendimentoDTO getEmpresaAtendimentoId(@PathVariable(value = "id") Long empresaAtendimentoId) throws EntityNotFoundException {
        EmpresaAtendimento empresaAtendimentoFind = repository.findById(empresaAtendimentoId).orElseThrow(() -> new EntityNotFoundException("Empresa não encontada com o ID"+ empresaAtendimentoId));
        return EmpresaAtendimentoDTO.toDTO(empresaAtendimentoFind);
    }

    @PostMapping
    public EmpresaAtendimentoDTO create(@Valid @RequestBody EmpresaAtendimento empresaAtendimento){
        return EmpresaAtendimentoDTO.toDTO(repository.save(empresaAtendimento));
    }

    @PutMapping("/{id}")
    public EmpresaAtendimentoDTO update(@PathVariable(value = "id") Long empresaAtendimentoId,
                             @RequestBody EmpresaAtendimento empresaAtendimento) throws EntityNotFoundException{
        EmpresaAtendimento empresaAtendimentoFind = repository.findById(empresaAtendimentoId).orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada com Id:: "+ empresaAtendimentoId));
        empresaAtendimentoFind.setId(empresaAtendimento.getId());

        return EmpresaAtendimentoDTO.toDTO(repository.save(empresaAtendimentoFind));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long empresaAtendimentoId) throws EntityNotFoundException{
        EmpresaAtendimento empresaAtendimentoFind = repository.findById(empresaAtendimentoId).orElseThrow(() -> new EntityNotFoundException("Empresa não encontrado com o ID::"+ empresaAtendimentoId));
        repository.delete(empresaAtendimentoFind);
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
