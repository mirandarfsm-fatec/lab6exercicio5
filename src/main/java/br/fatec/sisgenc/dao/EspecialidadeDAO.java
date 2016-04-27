package br.fatec.sisgenc.dao;

import java.util.List;

import br.fatec.sisgenc.dominio.Especialidade;
import br.fatec.sisgenc.framework.dao.EntidadeGenericaDAO;

public interface EspecialidadeDAO extends EntidadeGenericaDAO<Especialidade> {

	public List<Especialidade> listarEspecialidadesAtivas();
	
}
