package br.gov.sp.fatec.sisgenc.helper;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class ManagedBeanUtils {
	public static String obterParametroRequest(String parameter) {
		HttpServletRequest req = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		return req.getParameter(parameter);
	}

	public static void redirecionar(String url) {
		try {
			ExternalContext context = FacesContext.getCurrentInstance()
					.getExternalContext();
			context.redirect(context.encodeResourceURL(context
					.getRequestContextPath() + url));
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
