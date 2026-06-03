package contatos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contatos.models.Contatos;
import contatos.repository.ContatosRepository;

@Service
public class ContatosServices {

  @Autowired
  private ContatosRepository contatosRepository;

  // Salvar contato
  public Contatos salvarContato(Contatos contato) {
    contatosRepository.save(contato);
    return contato;
  }

  // Buscar todos os contatos
  public List<Contatos> buscarTodosContatos() {
    return contatosRepository.findAll();
  }

  // Buscar contato por ID
  public Contatos buscarContatoPorId(Long id) {
    return contatosRepository.findById(id).orElse(null);
  }

  // Deletar Contatos
  public void deletarContato(Long id) {
    contatosRepository.deleteById(id);
  }

  // Atualizar contato
  public Contatos atualizarContato(Long id, Contatos contato) {
    Contatos contatoExistente = contatosRepository.findById(id).orElse(null);

    if (contatoExistente == null) {
      return null;
    }

    contatoExistente.setNome(contato.getNome());
    contatoExistente.setTelefone(contato.getTelefone());

    return contatosRepository.save(contatoExistente);
  }


}
