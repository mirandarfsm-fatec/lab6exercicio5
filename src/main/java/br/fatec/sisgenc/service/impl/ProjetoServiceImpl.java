package br.fatec.sisgenc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.fatec.sisgenc.dao.ProjetoDAO;
import br.fatec.sisgenc.dominio.Projeto;
import br.fatec.sisgenc.service.ProjetoService;

@Repository(value = "projetoService")
@Transactional
public class ProjetoServiceImpl implements ProjetoService {

	@Autowired
	private ProjetoDAO projetoDAO;

	@Override
	public List<Projeto> listar() {
		return projetoDAO.listar();
	}

	@Override
	public List<Projeto> listarAtivos() {
		return projetoDAO.listarAtivos();
	}

	@Override
	public List<Projeto> listarNaoAtivos() {
		return projetoDAO.listarNaoAtivos();
	}

	@Override
	public Projeto obterPorId(int id) {
		return projetoDAO.obterPorId(id);
	}

	@Override
	public Projeto salvar(Projeto projeto) {
		return projetoDAO.salvar(projeto);
	}

	@Override
	public void mudarStatusAtivoProjeto(Integer id, boolean b) {
		projetoDAO.mudarStatusAtivoProjeto(id, b);
	}

	@Override
	public boolean verificarUnicidade(Integer id, String sigla) {
		return projetoDAO.verificarUnicidade(id, sigla);
	}

}