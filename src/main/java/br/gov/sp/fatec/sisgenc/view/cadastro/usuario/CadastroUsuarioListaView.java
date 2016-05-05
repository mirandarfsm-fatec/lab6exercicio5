package br.gov.sp.fatec.sisgenc.view.cadastro.usuario;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.sisgenc.domain.Usuario;
import br.gov.sp.fatec.sisgenc.repository.UsuarioRepository;

public class CadastroUsuarioListaView {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	private List<Usuario> usuarios;

	@PostConstruct
	public void listar() {
		setUsuarios((List<Usuario>) usuarioRepository.findAll());
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
