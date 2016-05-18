package br.gov.sp.fatec.sisgenc.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.gov.sp.fatec.sisgenc.domain.Encomenda;
import br.gov.sp.fatec.sisgenc.service.EncomendaService;

@ManagedBean(name = "localizadorEncomendaView")
@SessionScoped
public class LocalizadorEncomendaView {

	@ManagedProperty(value = "#{encomendaService}")
	private EncomendaService encomendaService;

	private Encomenda encomenda;
	private String localizador;

	public void localizarEncomenda() {
		encomenda = encomendaService.findByLocalizador(localizador);
	}

	public Encomenda getEncomenda() {
		return encomenda;
	}

	public void setEncomenda(Encomenda encomenda) {
		this.encomenda = encomenda;
	}

	public String getLocalizador() {
		return localizador;
	}

	public void setLocalizador(String localizador) {
		this.localizador = localizador;
	}

	public EncomendaService getEncomendaService() {
		return encomendaService;
	}

	public void setEncomendaService(EncomendaService encomendaService) {
		this.encomendaService = encomendaService;
	}

}
