package br.gov.sp.fatec.sisgenc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.sisgenc.domain.Usuario;
import br.gov.sp.fatec.sisgenc.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario findOne(Long id) {
		return usuarioRepository.findOne(id);
	}

	public Usuario findByNome(String nome) {
		return usuarioRepository.findByNome(nome);
	}

	public Usuario mudarStatus(Usuario usuario) {
		usuario.setAtivo(!usuario.isAtivo());
		return save(usuario);
	}

	public Usuario findByLogin(String login) {
		return usuarioRepository.findByLogin(login);
	}

}
