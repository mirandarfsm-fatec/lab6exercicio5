package br.gov.sp.fatec.sisgenc.rest;

import java.util.List;

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

import br.gov.sp.fatec.sisgenc.domain.Usuario;
import br.gov.sp.fatec.sisgenc.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listAllUsers() {
		Iterable<Usuario> usuarios = usuarioService.findAll();
		if (!usuarios.iterator().hasNext()) {
			return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Usuario>>((List<Usuario>) usuarios, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> getUser(@PathVariable("id") long id) {
		Usuario usuario = usuarioService.findOne(id);
		if (usuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody Usuario usuario,
			UriComponentsBuilder ucBuilder) {
		if (usuarioService.findByLogin(usuario.getLogin()) != null) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		usuarioService.save(usuario);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}")
				.buildAndExpand(usuario.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Usuario> updateUser(@PathVariable("id") long id,
			@RequestBody Usuario usuario) {
		Usuario currentUser = usuarioService.findOne(id);

		if (currentUser == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		currentUser.setNome(usuario.getNome());
		currentUser.setEmail(usuario.getEmail());
		currentUser.setAtivo(usuario.isAtivo());

		usuarioService.save(currentUser);
		return new ResponseEntity<Usuario>(currentUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Usuario> deleteUser(@PathVariable("id") long id) {
		Usuario usuario = usuarioService.findOne(id);
		if (usuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}
		usuarioService.mudarStatus(usuarioService.findOne(id));
		return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
	}
}
