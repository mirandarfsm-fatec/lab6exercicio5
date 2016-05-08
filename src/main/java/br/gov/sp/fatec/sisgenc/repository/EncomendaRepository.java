package br.gov.sp.fatec.sisgenc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.sisgenc.domain.Encomenda;

@Repository("encomendaRepository")
public interface EncomendaRepository extends CrudRepository<Encomenda, Long> {
	
	public Encomenda findByLocalizador(String localizador);


}
