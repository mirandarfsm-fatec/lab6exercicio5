package br.gov.sp.fatec.sisgenc.view.cadastro.usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.gov.sp.fatec.sisgenc.domain.Perfil;
import br.gov.sp.fatec.sisgenc.domain.Usuario;
import br.gov.sp.fatec.sisgenc.helper.ManagedBeanUtils;
import br.gov.sp.fatec.sisgenc.helper.Mensagem;
import br.gov.sp.fatec.sisgenc.service.UsuarioService;

@ManagedBean(name = "cadastroUsuarioFormView")
@SessionScoped
public class CadastroUsuarioFormView {

	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	private Usuario usuario;
	private List<Perfil> perfis;

	@PostConstruct
	public void init() {
		String id = ManagedBeanUtils.obterParametroRequest("id");
		setUsuario("novo".equals(id) ? new Usuario() : usuarioService
				.findOne(Long.valueOf(id)));
		setPerfis(new ArrayList<Perfil>(Arrays.asList(Perfil.values())));
		getPerfis().remove(Perfil.ROLE_USER);
	}

	public void salvar() {
		usuarioService.save(usuario);
		Mensagem.informacao("Usuario salvo com sucesso!");
		ManagedBeanUtils.redirecionar("/administracao/cadastro/usuario/");
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}
