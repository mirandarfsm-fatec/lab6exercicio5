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
		gerarPrimeiraSenha(usuario);
		return usuarioRepository.save(usuario);
	}
	
	public void gerarPrimeiraSenha(Usuario usuario) {
		if (usuario.getSenha() == null) {
			usuario.setSenha("698dc19d489c4e4db73e28a713eab07b");
		}
	}
	
	public Usuario resetarSenha(Long id) {
		Usuario usuario = findOne(id);
		usuario.setSenha("698dc19d489c4e4db73e28a713eab07b");
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
