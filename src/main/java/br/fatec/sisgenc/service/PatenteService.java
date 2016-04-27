package br.fatec.sisgenc.service;

import java.util.List;

import br.fatec.sisgenc.dominio.Patente;
import br.fatec.sisgenc.framework.dao.EntidadeGenericaDAO;

public interface PatenteService extends EntidadeGenericaDAO<Patente> {

	public List<Patente> listarPatentesAtivas();
	
}
