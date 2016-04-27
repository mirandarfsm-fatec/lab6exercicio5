package br.fatec.sisgenc.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.fatec.sisgenc.dominio.Projeto;
import br.fatec.sisgenc.framework.faces.ManagedBeanUtils;
import br.fatec.sisgenc.framework.faces.Mensagem;
import br.fatec.sisgenc.service.ProjetoService;

@Scope(value = "view")
@Service(value = "cadastroProjetoListaBean")
public class CadastroProjetoListaBean {

	@Autowired
	private ProjetoService projetoService;

	private Projeto projeto;
	private List<Projeto> projetos;

	@PostConstruct
	public void listar() {
		projetos = projetoService.listar();
	}

	public void selecionarProjeto(Projeto projetoEdicao) {
		projeto = projetoEdicao;
		ManagedBeanUtils.showDialog("mudarStatusProjetoDialog");
	}

	public void mudarStatusAtivoProjeto() {
		projetoService.mudarStatusAtivoProjeto(projeto.getId(),
				!projeto.isAtivo());
		projetos = projetoService.listar();
		String message = "Projeto status com sucesso";
		Mensagem.informacao(message.replace("status",
				projeto.isAtivo() ? "desativado" : "ativado"));
		ManagedBeanUtils.hideDialog("mudarStatusProjetoDialog");
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

}