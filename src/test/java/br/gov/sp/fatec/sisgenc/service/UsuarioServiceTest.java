package br.gov.sp.fatec.sisgenc.service;

import java.util.HashSet;
import java.util.Set;

import org.hsqldb.util.DatabaseManagerSwing;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.sisgenc.domain.Perfil;
import br.gov.sp.fatec.sisgenc.domain.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContextTest.xml" })
@Transactional
public class UsuarioServiceTest {

	private static final String NOME = "teste";
	private static final String SENHA = "698dc19d489c4e4db73e28a713eab07b";
	private static final String LOGIN = "teste";
	private static final String EMAIL = "teste@teste.com";

	@Autowired
	private transient UsuarioService usuarioService;

	@Before
	public void setUp() {
		DatabaseManagerSwing.main(new String[] { "--url",
				"jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
	}

	@Test
	public void testFindByNome() {
		boolean ativo = true;
		Set<Perfil> perfis = new HashSet<Perfil>();
		perfis.add(Perfil.ROLE_USER);
		Usuario usuario = new Usuario(NOME, LOGIN, SENHA, ativo, EMAIL, perfis);
		usuarioService.save(usuario);
		Assert.assertTrue(usuario.getId() != null);
		usuario = usuarioService.findByNome(NOME);
		Assert.assertTrue(usuario.getId() != null);
	}

	@Test
	public void testInsercaoUsuario() {
		boolean ativo = true;
		Set<Perfil> perfis = new HashSet<Perfil>();
		perfis.add(Perfil.ROLE_USER);
		Usuario usuario = new Usuario(NOME, LOGIN, SENHA, ativo, EMAIL, perfis);
		usuarioService.save(usuario);
		usuario = usuarioService.findOne(usuario.getId());
		Assert.assertNotNull(usuario);
	}

	@Test
	public void testFindByLogin() {
		boolean ativo = true;
		Set<Perfil> perfis = new HashSet<Perfil>();
		perfis.add(Perfil.ROLE_USER);
		Usuario usuario = new Usuario(NOME, LOGIN, SENHA, ativo, EMAIL, perfis);
		usuarioService.save(usuario);
		Assert.assertTrue(usuario.getId() != null);
		usuario = usuarioService.findByLogin(LOGIN);
		Assert.assertTrue(usuario.getId() != null);
	}

}
