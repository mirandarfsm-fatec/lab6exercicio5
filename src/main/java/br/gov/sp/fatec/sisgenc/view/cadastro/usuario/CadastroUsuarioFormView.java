package br.gov.sp.fatec.sisgenc.view.cadastro.usuario;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.sisgenc.domain.Usuario;
import br.gov.sp.fatec.sisgenc.helper.ManagedBeanUtils;
import br.gov.sp.fatec.sisgenc.helper.Mensagem;
import br.gov.sp.fatec.sisgenc.repository.UsuarioRepository;

public class CadastroUsuarioFormView {

	@Autowired
	private UsuarioRepository usuarioRepository;

	private Usuario usuario;

	@PostConstruct
	public void init() {
		String id = ManagedBeanUtils.obterParametroRequest("id");
		setUsuario("novo".equals(id) ? new Usuario() : usuarioRepository.findOne(Long.valueOf(id)));
	}

	public void salvar() {
		usuarioRepository.save(getUsuario());
		Mensagem.informacao("Usuario salvo com sucesso!");
		ManagedBeanUtils.redirecionar("/administracao/cadastro/usuario/");
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
