package br.gov.sp.fatec.sisgenc.view;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.sisgenc.domain.Usuario;

@Component("authenticationContext")
public class AuthenticationContext {

	public Usuario getUsuarioLogado() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication == null
				|| authentication.getPrincipal() == "anonymousUser") {
			return null;
		}
		return ((Usuario) authentication.getPrincipal());
	}

}