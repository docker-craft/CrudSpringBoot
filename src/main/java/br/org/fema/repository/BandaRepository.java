package br.org.fema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.fema.model.Banda;

public interface BandaRepository extends JpaRepository<Banda, Long> {

	Banda findByCodigo(Long codigo);
}
