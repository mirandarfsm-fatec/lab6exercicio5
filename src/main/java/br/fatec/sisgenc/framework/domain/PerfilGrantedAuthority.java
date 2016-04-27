package br.fatec.sisgenc.framework.domain;

import org.springframework.security.core.GrantedAuthority;

import br.fatec.sisgenc.dominio.Perfil;

public class PerfilGrantedAuthority implements GrantedAuthority {

	private static final long serialVersionUID = 1518627224476945058L;

	private Perfil perfil;

	public PerfilGrantedAuthority(Perfil perfil) {
		super();
		this.perfil = perfil;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public String getAuthority() {
		return perfil.name();
	}

}