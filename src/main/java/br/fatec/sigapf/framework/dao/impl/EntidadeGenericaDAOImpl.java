package br.fatec.sigapf.framework.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.fatec.sigapf.framework.dao.EntidadeGenericaDAO;
import br.fatec.sigapf.framework.domain.EntidadeGenerica;

@Transactional
public abstract class EntidadeGenericaDAOImpl<T extends EntidadeGenerica>
		implements EntidadeGenericaDAO<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> type;

	@SuppressWarnings("unchecked")
	public EntidadeGenericaDAOImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@Override
	public T persist(T object) {
		entityManager.persist(object);
		return object;
	}

	@Override
	public T findById(Integer id) {
		return entityManager.find(type, id);
	}

	@Override
	public T merge(T object) {
		if (object.getId() != null && object.getId() < 0) {
			object.setId(null);
		}
		return entityManager.merge(object);
	}

	@Override
	public void delete(Integer id) {
		entityManager.remove(entityManager.getReference(type, id));
	}

	@Override
	public List<T> findAll() {
		return entityManager.createQuery("from " + type.getName(), type)
				.getResultList();
	}

	public String criarLike(String coluna, Map<String, Object> filters) {
		if (filters.get(coluna) != null) {
			String value = (String) filters.get(coluna);
			return "AND UPPER(TRANSLATE ("
					+ coluna
					+ ", 'ÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜáçéíóúàèìòùâêîôûãõëü','ACEIOUAEIOUAEIOUAOEUaceiouaeiouaeiouaoeu')) "
					+ "LIKE UPPER((TRANSLATE('%"
					+ value
					+ "%', 'ÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜáçéíóúàèìòùâêîôûãõëü', 'ACEIOUAEIOUAEIOUAOEUaceiouaeiouaeiouaoeu'))) ";
		}
		return "";
	}

}
