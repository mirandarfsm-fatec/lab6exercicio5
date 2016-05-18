package br.gov.sp.fatec.sisgenc.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.sisgenc.domain.Encomenda;
import br.gov.sp.fatec.sisgenc.repository.EncomendaRepository;

@Service("encomendaService")
public class EncomendaService {

	@Autowired
	private EncomendaRepository encomendaRepository;

	public String generateHashLocalizator() {
		return RandomStringUtils.randomAlphanumeric(17).toUpperCase();
	}

	public Iterable<Encomenda> findAll() {
		return encomendaRepository.findAll();
	}

	public Encomenda findOne(Long id) {
		return encomendaRepository.findOne(id);
	}

	public Encomenda mudarStatus(Encomenda encomenda) {
		encomenda.setAtivo(!encomenda.isAtivo());
		return encomendaRepository.save(encomenda);
	}

	public Encomenda save(Encomenda encomenda) {
		String localizador = encomenda.getLocalizador() == null ? generateHashLocalizator()
				: encomenda.getLocalizador();
		encomenda.setLocalizador(localizador);
		return encomendaRepository.save(encomenda);
	}

	public Encomenda findByLocalizador(String localizador) {
		return encomendaRepository.findByLocalizador(localizador);
	}
}
