package contatos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import contatos.dto.ContatosDTO;
import contatos.models.Contatos;
import contatos.services.ContatosServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/contatos")
@Tag(name = "Contatos", description = "API REST de Contatos")
public class ContatoController {

  @Autowired
  private ContatosServices contatosServices;

  // Criar
  @PostMapping
  public ResponseEntity<ContatosDTO> criarContato(@RequestBody @Valid Contatos contato) {
    Contatos salvo = contatosServices.salvarContato(contato);
    return ResponseEntity.status(HttpStatus.CREATED).body(new ContatosDTO(salvo));
  }

  // Listar todos
  @GetMapping
  public ResponseEntity<List<ContatosDTO>> listarContatos() {
    List<ContatosDTO> contatos = contatosServices.buscarTodosContatos()
        .stream()
        .map(ContatosDTO::new)
        .toList();
    return ResponseEntity.ok(contatos);
  }

  // Buscar por ID
  @GetMapping("/{id}")
  public ResponseEntity<ContatosDTO> buscarPorId(@PathVariable Long id) {
    Contatos contato = contatosServices.buscarContatoPorId(id);
    if (contato == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(new ContatosDTO(contato));
  }

  // Atualizar
  @PutMapping("/{id}")
  public ResponseEntity<ContatosDTO> atualizarContato(@PathVariable Long id,
      @RequestBody @Valid Contatos contato) {
    Contatos atualizado = contatosServices.atualizarContato(id, contato);
    if (atualizado == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(new ContatosDTO(atualizado));
  }

  // Deletar
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarContato(@PathVariable Long id) {
    contatosServices.deletarContato(id);
    return ResponseEntity.noContent().build();
  }

}