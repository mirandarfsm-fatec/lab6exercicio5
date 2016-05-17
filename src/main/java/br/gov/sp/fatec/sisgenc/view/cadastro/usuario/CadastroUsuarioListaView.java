package br.gov.sp.fatec.sisgenc.view.cadastro.usuario;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.sisgenc.domain.Usuario;
import br.gov.sp.fatec.sisgenc.helper.ManagedBeanUtils;
import br.gov.sp.fatec.sisgenc.repository.UsuarioRepository;

@ManagedBean(name = "cadastroUsuarioLista")
@SessionScoped
public class CadastroUsuarioListaView {

	@Autowired
	private UsuarioRepository usuarioRepository;

	private Usuario usuario;
	private Usuario usuarioSelecionado;
	private List<Usuario> usuarios;

	@PostConstruct
	public void init() {
		usuarios = (List<Usuario>) usuarioRepository.findAll();
	}

	public void selecionarUsuario(Usuario usuarioEdicao) {
		usuario = usuarioEdicao;
		ManagedBeanUtils.showDialog("mudarStatusUsuarioDialog");
	}

	public void remover(Long id) {
		usuarioRepository.delete(usuarioRepository.findOne(id));
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
