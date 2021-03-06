package br.gov.sp.fatec.sisgenc.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.sisgenc.domain.Encomenda;
import br.gov.sp.fatec.sisgenc.domain.Estado;

@Repository("encomendaRepository")
public interface EncomendaRepository extends CrudRepository<Encomenda, Long> {

	public Encomenda findByLocalizador(String localizador);

	public Iterable<Encomenda> findByEstado(Estado estado);
	
	public Iterable<Encomenda> findByEstadoNotIn(Collection<Estado> estados);
	//public Iterable<Encomenda> findByEstadoNotIn1(Estado... estados);
}
