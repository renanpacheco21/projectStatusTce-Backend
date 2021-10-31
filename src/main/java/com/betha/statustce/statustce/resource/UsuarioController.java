package com.betha.statustce.statustce.resource;

import com.betha.statustce.statustce.model.Usuario;
import com.betha.statustce.statustce.repository.UsuarioRepository;
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
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<UsuarioDTO> getUsuario(@QuerydslPredicate(root = Usuario.class) Predicate predicate){
        List<UsuarioDTO> result = new ArrayList<>();
        Iterable<Usuario> all = repository.findAll(predicate);
        all.forEach(f -> result.add(UsuarioDTO.toDTO(f)));
        return result;
    }

    @GetMapping("/{id}")
    public UsuarioDTO getUsuarioId(@PathVariable(value = "id") Long usuarioId) throws EntityNotFoundException {
        Usuario usuarioFind = repository.findById(usuarioId).orElseThrow(() -> new EntityNotFoundException("Usuario não encontado com o ID"+ usuarioId));
        return UsuarioDTO.toDTO(usuarioFind);
    }

    @PostMapping
    public UsuarioDTO create(@Valid @RequestBody Usuario usuario){
        return UsuarioDTO.toDTO(repository.save(usuario));
    }

    @PutMapping("/{id}")
    public UsuarioDTO update(@PathVariable(value = "id") Long usuarioId,
                             @RequestBody Usuario usuario) throws EntityNotFoundException{
        Usuario usuarioFind = repository.findById(usuarioId).orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado com Id:: "+ usuarioId));
        usuarioFind.setId(usuario.getId());

        return UsuarioDTO.toDTO(repository.save(usuarioFind));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long usuarioId) throws EntityNotFoundException{
        Usuario usuarioFind = repository.findById(usuarioId).orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado com o ID::"+ assuntoId));
        repository.delete(usuarioFind);
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