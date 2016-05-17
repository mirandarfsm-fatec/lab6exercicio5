package br.gov.sp.fatec.sisgenc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContextTest.xml" })
@Transactional
public class EncomendaServiceTest {

	@Autowired
	private EncomendaService encomendaService;
	
	@Test
	public void testGenerateHashLocalizator() {
		Assert.assertNotNull(encomendaService.generateHashLocalizator());
	}

}
