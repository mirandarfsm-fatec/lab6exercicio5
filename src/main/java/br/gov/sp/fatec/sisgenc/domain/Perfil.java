package br.gov.sp.fatec.sisgenc.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Perfil implements GrantedAuthority {

	ROLE_USER("Usuário"), ROLE_ADMIN("Administrador do Sistema");

	private String label;

	private Perfil(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getAuthority() {
		return name();
	}

	
}
