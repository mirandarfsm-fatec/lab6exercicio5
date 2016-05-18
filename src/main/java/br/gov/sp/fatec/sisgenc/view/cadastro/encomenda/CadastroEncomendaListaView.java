package br.gov.sp.fatec.sisgenc.view.cadastro.encomenda;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.gov.sp.fatec.sisgenc.domain.Encomenda;
import br.gov.sp.fatec.sisgenc.domain.Usuario;
import br.gov.sp.fatec.sisgenc.helper.ManagedBeanUtils;
import br.gov.sp.fatec.sisgenc.service.EncomendaService;

@ManagedBean(name = "cadastroEncomendaListaView")
@SessionScoped
public class CadastroEncomendaListaView {

	@ManagedProperty(value = "#{encomendaService}")
	private EncomendaService encomendaService;

	private Iterable<Encomenda> encomendas;
	private Encomenda encomenda;
	private Encomenda encomendaSelecionada;

	@PostConstruct
	public void init() {
		encomendas = encomendaService.findAll();
	}

	public void selecionarEncomenda(Encomenda encomendaEdicao) {
		encomenda = encomendaEdicao;
		ManagedBeanUtils.showDialog("mudarStatusEncomendaDialog");
	}
	
	public void remover(Long id) {
		encomendaService.mudarStatus(encomendaService.findOne(id));
	}

	public Iterable<Encomenda> getEncomendas() {
		return encomendas;
	}

	public void setEncomendas(Iterable<Encomenda> encomendas) {
		this.encomendas = encomendas;
	}

	public EncomendaService getEncomendaService() {
		return encomendaService;
	}

	public void setEncomendaService(EncomendaService encomendaService) {
		this.encomendaService = encomendaService;
	}

	public Encomenda getEncomendaSelecionada() {
		return encomendaSelecionada;
	}

	public void setEncomendaSelecionada(Encomenda encomendaSelecionada) {
		this.encomendaSelecionada = encomendaSelecionada;
	}

	public Encomenda getEncomenda() {
		return encomenda;
	}

	public void setEncomenda(Encomenda encomenda) {
		this.encomenda = encomenda;
	}

}
