package br.fatec.sisgenc.service.impl;

import java.util.List;

import javax.persistence.MappedSuperclass;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.fatec.sisgenc.dao.PatenteDAO;
import br.fatec.sisgenc.dominio.Patente;
import br.fatec.sisgenc.framework.dao.impl.EntidadeGenericaDAOImpl;
import br.fatec.sisgenc.service.PatenteService;

@MappedSuperclass
@Transactional
@Repository(value = "patenteService")
public class PatenteServiceImpl extends EntidadeGenericaDAOImpl<Patente>
		implements PatenteService {

	@Autowired
	private PatenteDAO patenteDAO;

	@Override
	public List<Patente> listarPatentesAtivas() {
		return patenteDAO.listarPatentesAtivas();
	}

}
