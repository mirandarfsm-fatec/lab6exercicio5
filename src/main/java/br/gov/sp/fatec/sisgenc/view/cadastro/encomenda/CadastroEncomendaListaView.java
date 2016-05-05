package br.gov.sp.fatec.sisgenc.view.cadastro.encomenda;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.sisgenc.domain.Encomenda;
import br.gov.sp.fatec.sisgenc.repository.EncomendaRepository;

@ManagedBean(name = "cadastroEncomendaLista")
@SessionScoped
public class CadastroEncomendaListaView {

	@Autowired
	private EncomendaRepository encomendaRepository;

	private List<Encomenda> encomendas;

	@PostConstruct
	public void listar() {
		setEncomendas((List<Encomenda>) encomendaRepository.findAll());
	}

	public List<Encomenda> getEncomendas() {
		return encomendas;
	}

	public void setEncomendas(List<Encomenda> encomendas) {
		this.encomendas = encomendas;
	}


}
