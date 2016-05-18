package br.gov.sp.fatec.sisgenc.view;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.sisgenc.domain.Usuario;
import br.gov.sp.fatec.sisgenc.helper.ManagedBeanUtils;

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
	
	public void logout() throws IOException {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		((HttpSession) context.getSession(false)).invalidate();
		String logout = ((HttpServletRequest) context.getRequest()).getContextPath() + "/logout";
		context.redirect(context.encodeResourceURL(logout));
	}
	
	public void acessarMeuPerfil() {
		ManagedBeanUtils.redirecionar("/perfil/");
	}

}