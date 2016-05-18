package br.gov.sp.fatec.sisgenc.view.cadastro.usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.gov.sp.fatec.sisgenc.domain.Usuario;
import br.gov.sp.fatec.sisgenc.helper.ManagedBeanUtils;
import br.gov.sp.fatec.sisgenc.service.UsuarioService;

@ManagedBean(name = "cadastroUsuarioListaView")
@SessionScoped
public class CadastroUsuarioListaView {

	@ManagedProperty(value="#{usuarioService}")
	private UsuarioService usuarioService;

	private Usuario usuario;
	private Usuario usuarioSelecionado;
	private Iterable<Usuario> usuarios;

	@PostConstruct
	public void init() {
		usuarios = usuarioService.findAll();
	}

	public void selecionarUsuario(Usuario usuarioEdicao) {
		usuario = usuarioEdicao;
		ManagedBeanUtils.showDialog("mudarStatusUsuarioDialog");
	}

	public void remover(Long id) {
		usuarioService.mudarStatus(usuarioService.findOne(id));
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

	public Iterable<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Iterable<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	

}
