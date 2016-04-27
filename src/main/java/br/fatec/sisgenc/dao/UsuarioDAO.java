package br.fatec.sisgenc.dao;

import java.util.List;

import br.fatec.sisgenc.dominio.Perfil;
import br.fatec.sisgenc.dominio.Usuario;

public interface UsuarioDAO {

	public List<Usuario> listar();
	public List<Usuario> listarAtivos();
	public List<Usuario> listarNaoAtivos();
	public Usuario obterPorId(int id);
	public Usuario salvar(Usuario usuario);
	public void resetarSenha(Integer id);
	public void gerarPrimeiraSenha(Usuario usuario);
	public void atualizarSenha(String novaSenha, Integer id);
	public void validacaoAtualizarSenha(String velhaSenha, String novaSenha,
			String repeticaoNovaSenha, Integer id);
	public Usuario obterPorNomeUsuario(String nomeUsuario);
	public List<Perfil> obterPerfisPorUsuario(Integer id);
	public void mudarStatusAtivoUsuario(Integer id, boolean b);
	public boolean verificarUnicidade(Integer id, String login);
	
}
