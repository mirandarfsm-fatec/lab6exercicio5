package br.fatec.sisgenc.framework.dao;

import java.util.List;

import br.fatec.sisgenc.framework.domain.EntidadeGenerica;

public interface EntidadeGenericaDAO<T extends EntidadeGenerica> {

	public T persist(T object);
	public T findById(Integer id);
	public T merge(T object);
	public void delete(Integer id);
	public List<T> findAll();

}
