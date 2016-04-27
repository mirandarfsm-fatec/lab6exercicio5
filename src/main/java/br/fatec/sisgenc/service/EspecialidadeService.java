package br.fatec.sisgenc.service;

import java.util.List;

import br.fatec.sisgenc.dominio.Especialidade;
import br.fatec.sisgenc.framework.dao.EntidadeGenericaDAO;

public interface EspecialidadeService extends EntidadeGenericaDAO<Especialidade> {

	public List<Especialidade> listarEspecialidadesAtivas();
	
}
