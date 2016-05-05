package br.gov.sp.fatec.sisgenc.view.cadastro.usuario;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.sisgenc.domain.Usuario;
import br.gov.sp.fatec.sisgenc.repository.UsuarioRepository;

@ManagedBean(name="cadastroUsuarioLista")
@SessionScoped
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
