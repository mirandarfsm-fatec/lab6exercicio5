package br.gov.sp.fatec.sisgenc.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.sisgenc.domain.Encomenda;
import br.gov.sp.fatec.sisgenc.domain.Percurso;
import br.gov.sp.fatec.sisgenc.repository.PercursoRepository;

@Service("percursoService")
public class PercursoService {

	@Autowired
	private PercursoRepository percursoRepository;

	public Iterable<Percurso> findAll() {
		return percursoRepository.findAll();
	}

	public Percurso save(Percurso percurso, Encomenda encomenda) {
		percurso.setData(new Date());
		percurso.setEncomenda(encomenda);
		percurso.setEstado(encomenda.getEstado().getLabel());
		return percursoRepository.save(percurso);
	}

	public Iterable<Percurso> findByEncomenda(Encomenda encomenda) {
		return percursoRepository.findByEncomenda(encomenda);
	}
}
