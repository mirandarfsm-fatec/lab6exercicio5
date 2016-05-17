package br.gov.sp.fatec.sisgenc.view.cadastro.encomenda;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.sisgenc.domain.Encomenda;
import br.gov.sp.fatec.sisgenc.helper.ManagedBeanUtils;
import br.gov.sp.fatec.sisgenc.helper.Mensagem;
import br.gov.sp.fatec.sisgenc.repository.EncomendaRepository;
import br.gov.sp.fatec.sisgenc.service.EncomendaService;

@ManagedBean(name = "cadastroEncomendaForm")
@SessionScoped
public class CadastroEncomendaFormView {

	@Autowired
	private EncomendaService encomendaService;

	@Autowired
	private EncomendaRepository encomendaRepository;

	private Encomenda encomenda;

	@PostConstruct
	public void init() {
		String id = ManagedBeanUtils.obterParametroRequest("id");
		encomenda = "novo".equals(id) ? new Encomenda() : encomendaRepository
				.findOne(Long.valueOf(id));
	}

	public void salvar() {
		String localizador = encomenda.getLocalizador() == null ? encomendaService.generateHashLocalizator() : encomenda.getLocalizador();
		encomenda.setLocalizador(localizador);
		encomendaRepository.save(encomenda);
		Mensagem.informacao("Encomenda salva com sucesso!");
		ManagedBeanUtils.redirecionar("/administracao/cadastro/encomenda/");
	}

}
