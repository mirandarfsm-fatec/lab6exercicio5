package br.fatec.sisgenc.service;

import java.util.List;

import br.fatec.sisgenc.dominio.Quadro;
import br.fatec.sisgenc.framework.dao.EntidadeGenericaDAO;

public interface QuadroService extends EntidadeGenericaDAO<Quadro> {

	public List<Quadro> listarQuadrosAtivos();

}
