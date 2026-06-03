package contatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import contatos.models.Contatos;

public interface ContatosRepository extends JpaRepository<Contatos, Long> {

}
