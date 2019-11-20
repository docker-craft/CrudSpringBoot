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

import br.org.fema.model.Musica;
import br.org.fema.repository.MusicaRepository;

@RestController
@RequestMapping("/musicas")
public class MusicaResource {
	
	@Autowired
	private MusicaRepository musicaRepository;

	@GetMapping
	public List<Musica> listar() {
		return musicaRepository.findAll();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity findById(@PathVariable long id) {
		return musicaRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Musica create(@RequestBody Musica musica) {
		return musicaRepository.save(musica);
	}
	
	@PutMapping(path = {"/{id}"})
	public Musica UpdateMusica(@PathVariable("id") long id,@RequestBody Musica musica) {
		Musica musicaAtual = musicaRepository.findByCodigo(id);
		musicaAtual.setNome(musica.getNome());
		musicaAtual.setPreco(musica.getPreco());
		musicaAtual.setBanda(musica.getBanda());
		musicaAtual.setBanda(musica.getBanda());
		return musicaRepository.save(musicaAtual);
	}
	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {
		return musicaRepository.findById(id).map(record -> {
			musicaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
