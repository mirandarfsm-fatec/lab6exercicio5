package br.gov.sp.fatec.sisgenc.view.cadastro.encomenda;

import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.gov.sp.fatec.sisgenc.domain.Encomenda;
import br.gov.sp.fatec.sisgenc.domain.Estado;
import br.gov.sp.fatec.sisgenc.service.EncomendaService;

@ManagedBean(name = "cadastroEncomendaListaView")
@ViewScoped
public class CadastroEncomendaListaView {

	@ManagedProperty(value = "#{encomendaService}")
	private EncomendaService encomendaService;

	private Iterable<Encomenda> encomendas;
	private Iterable<Encomenda> encomendasFinalizadas;
	private Iterable<Encomenda> encomendasCanceladas;
	private Encomenda encomenda;
	private Encomenda encomendaSelecionada;

	@PostConstruct
	public void init() {
		encomendas = encomendaService.findAll();
		final Iterator<Encomenda> iterator = encomendas.iterator();
		while (iterator.hasNext()) {
			final Encomenda encomenda = iterator.next();
			if ((encomenda.getEstado() == Estado.FINALIZADA)
					|| (encomenda.getEstado() == Estado.CANCELADA)) {
				iterator.remove();
			}
		}
		encomendasFinalizadas = encomendaService
				.findByEstado(Estado.FINALIZADA);
		encomendasCanceladas = encomendaService.findByEstado(Estado.CANCELADA);
	}

	public Iterable<Encomenda> getEncomendas() {
		return encomendas;
	}

	public void setEncomendas(Iterable<Encomenda> encomendas) {
		this.encomendas = encomendas;
	}

	public Iterable<Encomenda> getEncomendasFinalizadas() {
		return encomendasFinalizadas;
	}

	public void setEncomendasFinalizadas(
			Iterable<Encomenda> encomendasFinalizadas) {
		this.encomendasFinalizadas = encomendasFinalizadas;
	}

	public Iterable<Encomenda> getEncomendasCanceladas() {
		return encomendasCanceladas;
	}

	public void setEncomendasCanceladas(Iterable<Encomenda> encomendasCanceladas) {
		this.encomendasCanceladas = encomendasCanceladas;
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
