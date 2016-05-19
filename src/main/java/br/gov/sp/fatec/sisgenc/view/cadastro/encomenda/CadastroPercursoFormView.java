package br.gov.sp.fatec.sisgenc.view.cadastro.encomenda;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.gov.sp.fatec.sisgenc.domain.Encomenda;
import br.gov.sp.fatec.sisgenc.domain.Estado;
import br.gov.sp.fatec.sisgenc.domain.Percurso;
import br.gov.sp.fatec.sisgenc.helper.ManagedBeanUtils;
import br.gov.sp.fatec.sisgenc.helper.Mensagem;
import br.gov.sp.fatec.sisgenc.service.EncomendaService;
import br.gov.sp.fatec.sisgenc.service.PercursoService;

@ManagedBean(name = "cadastroPercursoFormView")
@ViewScoped
public class CadastroPercursoFormView {

	@ManagedProperty(value = "#{encomendaService}")
	private EncomendaService encomendaService;
	@ManagedProperty(value = "#{percursoService}")
	private PercursoService percursoService;

	private Encomenda encomenda;
	private Percurso percurso;
	private Estado[] estados;

	@PostConstruct
	public void init() {
		String id = ManagedBeanUtils.obterParametroRequest("id");
		encomenda = encomendaService.findOne(Long.valueOf(id));
		percurso = new Percurso();
	}

	public void salvar() {
		encomendaService.save(encomenda);
		percursoService.save(percurso, encomenda);
		Mensagem.informacao("Encomenda atualizada com sucesso!");
		ManagedBeanUtils.redirecionar("/administracao/cadastro/encomenda/");
	}

	public EncomendaService getEncomendaService() {
		return encomendaService;
	}

	public void setEncomendaService(EncomendaService encomendaService) {
		this.encomendaService = encomendaService;
	}

	public PercursoService getPercursoService() {
		return percursoService;
	}

	public void setPercursoService(PercursoService percursoService) {
		this.percursoService = percursoService;
	}

	public Encomenda getEncomenda() {
		return encomenda;
	}

	public void setEncomenda(Encomenda encomenda) {
		this.encomenda = encomenda;
	}

	public Percurso getPercurso() {
		return percurso;
	}

	public void setPercurso(Percurso percurso) {
		this.percurso = percurso;
	}

	public Estado[] getEstados() {
		return Estado.values();
	}

	public void setEstados(Estado[] estados) {
		this.estados = estados;
	}
}