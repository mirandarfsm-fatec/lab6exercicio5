package br.gov.sp.fatec.sisgenc.repository;

import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.sisgenc.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
