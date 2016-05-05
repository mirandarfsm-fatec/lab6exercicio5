package br.gov.sp.fatec.sisgenc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.sisgenc.domain.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	public Usuario findByNome(String nome);
	
	public Usuario findByLogin(String login);

}
