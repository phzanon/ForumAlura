package br.com.pedrozanon.forum.repository;

import br.com.pedrozanon.forum.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
