package br.fatec.sisgenc.framework.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import br.fatec.sisgenc.dominio.Perfil;
import br.fatec.sisgenc.dominio.Usuario;

public class UsuarioUserDetails implements UserDetails {

	private static final long serialVersionUID = 179367981399803786L;

	private Usuario usuario;

	public UsuarioUserDetails(Usuario usuario) {
		super();
		this.setUsuario(usuario);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Collection<PerfilGrantedAuthority> getAuthorities() {
		Set<PerfilGrantedAuthority> authorities = new HashSet<PerfilGrantedAuthority>();
		authorities.add(new PerfilGrantedAuthority(Perfil.PERFIL_USUARIO));
		for (Perfil perfil : this.getUsuario().getPerfis()) {
			authorities.add(new PerfilGrantedAuthority(perfil));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return getUsuario().getSenha();
	}

	@Override
	public String getUsername() {
		return getUsuario().getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return getUsuario().isAtivo();
	}

}