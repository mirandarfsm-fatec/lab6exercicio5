package br.gov.sp.fatec.sisgenc.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service("encomendaService")
public class EncomendaService {

	public String generateHashLocalizator(){
		return RandomStringUtils.randomAlphanumeric(17).toUpperCase();
	}
}
