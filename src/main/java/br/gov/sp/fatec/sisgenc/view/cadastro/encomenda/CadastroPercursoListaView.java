package br.gov.sp.fatec.sisgenc.view.cadastro.encomenda;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.gov.sp.fatec.sisgenc.domain.Encomenda;
import br.gov.sp.fatec.sisgenc.domain.Percurso;
import br.gov.sp.fatec.sisgenc.service.EncomendaService;
import br.gov.sp.fatec.sisgenc.service.PercursoService;

@ManagedBean(name = "cadastroPercursoListaView")
@ViewScoped
public class CadastroPercursoListaView {

	@ManagedProperty(value = "#{percursoService}")
	private PercursoService percursoService;
	@ManagedProperty(value = "#{encomendaService}")
	private EncomendaService encomendaService;

	private Iterable<Percurso> percursos;
	private Encomenda encomenda;
	private Percurso percurso;
	// TODO - não ta pegando o valor que é passado pelo usuário
	private String localizador;

	public void localizar() {
		encomenda = encomendaService.findByLocalizador(localizador);
		//CORRETO
		//percursos = percursoService.findByEncomenda(encomenda);
		//TESTE
		percursos = percursoService.findAll();
	}

	public Iterable<Percurso> getPercursos() {
		return percursos;
	}

	public void setPercursos(Iterable<Percurso> percursos) {
		this.percursos = percursos;
	}

	public PercursoService getPercursoService() {
		return percursoService;
	}

	public void setPercursoService(PercursoService percursoService) {
		this.percursoService = percursoService;
	}

	public EncomendaService getEncomendaService() {
		return encomendaService;
	}

	public void setEncomendaService(EncomendaService encomendaService) {
		this.encomendaService = encomendaService;
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

	public String getLocalizador() {
		return localizador;
	}

	public void setLocalizador(String localizador) {
		this.localizador = localizador;
	}
}
