package br.fatec.sisgenc.dao;

import java.util.List;

import br.fatec.sisgenc.dominio.Patente;
import br.fatec.sisgenc.framework.dao.EntidadeGenericaDAO;

public interface PatenteDAO extends EntidadeGenericaDAO<Patente> {

	public List<Patente> listarPatentesAtivas();
	
}
