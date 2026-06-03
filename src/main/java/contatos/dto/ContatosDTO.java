package contatos.dto;

import contatos.models.Contatos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContatosDTO {
  private Long id;
  private String nome;
  private String telefone;

  public ContatosDTO(Contatos contato) {
    this.id = contato.getId();
    this.nome = contato.getNome();
    this.telefone = contato.getTelefone();
  }
}
