package br.org.fema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.fema.model.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
	Musica findByCodigo(Long codigo);
}
