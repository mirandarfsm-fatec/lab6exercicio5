package br.gov.sp.fatec.sisgenc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.sisgenc.domain.Encomenda;
import br.gov.sp.fatec.sisgenc.domain.Percurso;

@Repository("percursoRepository")
public interface PercursoRepository extends CrudRepository<Percurso, Long> {

	public Iterable<Percurso> findByEncomenda(Encomenda encomenda);

}
