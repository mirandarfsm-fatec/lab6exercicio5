package br.gov.sp.fatec.sisgenc.view.cadastro.encomenda;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.gov.sp.fatec.sisgenc.domain.Encomenda;
import br.gov.sp.fatec.sisgenc.helper.ManagedBeanUtils;
import br.gov.sp.fatec.sisgenc.helper.Mensagem;
import br.gov.sp.fatec.sisgenc.service.EncomendaService;

@ManagedBean(name = "cadastroEncomendaFormView")
@ViewScoped
public class CadastroEncomendaFormView {

	@ManagedProperty(value = "#{encomendaService}")
	private EncomendaService encomendaService;

	private Encomenda encomenda;

	@PostConstruct
	public void init() {
		String id = ManagedBeanUtils.obterParametroRequest("id");
		encomenda = "novo".equals(id) ? new Encomenda() : encomendaService
				.findOne(Long.valueOf(id));
	}

	public void salvar() {
		encomendaService.save(encomenda);
		Mensagem.informacao("Encomenda salva com sucesso!");
		ManagedBeanUtils.redirecionar("/administracao/cadastro/encomenda/");
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

}
