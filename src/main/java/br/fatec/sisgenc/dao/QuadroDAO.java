package br.fatec.sisgenc.dao;

import java.util.List;

import br.fatec.sisgenc.dominio.Quadro;
import br.fatec.sisgenc.framework.dao.EntidadeGenericaDAO;

public interface QuadroDAO extends EntidadeGenericaDAO<Quadro> {

	public List<Quadro> listarQuadrosAtivos();

}
