package br.org.fema.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.fema.model.Banda;
import br.org.fema.repository.BandaRepository;

@RestController
@RequestMapping("/bandas")
public class BandaResource {

	@Autowired
	private BandaRepository bandaRepository;

	@GetMapping
	public List<Banda> listar() {
		return bandaRepository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity findById(@PathVariable long id) {
		return bandaRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Banda create(@RequestBody Banda banda) {
		return bandaRepository.save(banda);
	}
	
	@PutMapping(path = {"/{id}"})
	public Banda UpdateBanda(@PathVariable("id") long id,@RequestBody Banda banda) {
		Banda bandaAtual = bandaRepository.findByCodigo(id);
		bandaAtual.setNome(banda.getNome());
		bandaAtual.setGenero(banda.getGenero());
		return bandaRepository.save(bandaAtual);

	}	
	
	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {
		return bandaRepository.findById(id).map(record -> {
			bandaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
