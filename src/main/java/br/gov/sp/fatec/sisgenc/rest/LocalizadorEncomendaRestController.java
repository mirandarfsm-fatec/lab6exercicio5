package br.gov.sp.fatec.sisgenc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.sisgenc.domain.Encomenda;
import br.gov.sp.fatec.sisgenc.service.EncomendaService;

@RestController
@RequestMapping(value = "/localizador")
public class LocalizadorEncomendaRestController {

	@Autowired
	private EncomendaService encomendaService;

	@RequestMapping(value = "/{localizador}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Encomenda> getEncomendaPorLocalizador(
			@PathVariable("localizador") String localizador) {
		Encomenda encomenda = encomendaService.findByLocalizador(localizador);
		if (encomenda == null) {
			return new ResponseEntity<Encomenda>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Encomenda>(encomenda, HttpStatus.OK);
	}

}
