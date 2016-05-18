package br.gov.sp.fatec.sisgenc.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.sisgenc.domain.Encomenda;
import br.gov.sp.fatec.sisgenc.repository.EncomendaRepository;

@ManagedBean(name = "localizadorEncomendaView")
@SessionScoped
public class LocalizadorEncomendaView {

	@Autowired
	private EncomendaRepository encomendaRepository;

	private Encomenda encomenda;
	private String localizador;

	public void localizarEncomenda() {
		encomenda = encomendaRepository.findByLocalizador(localizador);
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

}
