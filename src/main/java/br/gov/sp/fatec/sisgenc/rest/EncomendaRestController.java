package br.gov.sp.fatec.sisgenc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.gov.sp.fatec.sisgenc.domain.Encomenda;
import br.gov.sp.fatec.sisgenc.helper.RestUtil;
import br.gov.sp.fatec.sisgenc.repository.EncomendaRepository;

@RestController
@RequestMapping(value = RestUtil.URL_REST + "/encomenda")
public class EncomendaRestController {

	@Autowired
	private EncomendaRepository encomendaRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Encomenda>> listAllUsers() {
		Iterable<Encomenda> encomendas = encomendaRepository.findAll();
		if (!encomendas.iterator().hasNext()) {
			return new ResponseEntity<Iterable<Encomenda>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Iterable<Encomenda>>(encomendas, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Encomenda> getUser(@PathVariable("id") long id) {
		Encomenda encomenda = encomendaRepository.findOne(id);
		if (encomenda == null) {
			return new ResponseEntity<Encomenda>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Encomenda>(encomenda, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody Encomenda encomenda,UriComponentsBuilder ucBuilder) {
//		if (encomendaRepository.findByLogin(usuario.getLogin()) != null) {
//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		}
		encomendaRepository.save(encomenda);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/{id}")
				.buildAndExpand(encomenda.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Encomenda> updateUser(@PathVariable("id") long id, @RequestBody Encomenda encomenda) {
		Encomenda currentEncomenda = encomendaRepository.findOne(id);

		if (currentEncomenda == null) {
			return new ResponseEntity<Encomenda>(HttpStatus.NOT_FOUND);
		}
		//currentEncomenda.setNome(encomenda.getNome());
		//currentEncomenda.setEmail(encomenda.getEmail());
		currentEncomenda.setAtivo(encomenda.isAtivo());

		encomendaRepository.save(currentEncomenda);
		return new ResponseEntity<Encomenda>(currentEncomenda, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Encomenda> deleteUser(@PathVariable("id") long id) {
		Encomenda encomenda = encomendaRepository.findOne(id);
		if (encomenda == null) {
			return new ResponseEntity<Encomenda>(HttpStatus.NOT_FOUND);
		}

		encomendaRepository.delete(id);
		return new ResponseEntity<Encomenda>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public ResponseEntity<Encomenda> deleteAllUsers() {

		encomendaRepository.deleteAll();
		return new ResponseEntity<Encomenda>(HttpStatus.NO_CONTENT);
	}
	
}
