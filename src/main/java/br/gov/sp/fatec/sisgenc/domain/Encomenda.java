package br.gov.sp.fatec.sisgenc.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tb_encomenda")
@AttributeOverride(name = "id", column = @Column(name = "id_encomenda", insertable = false, updatable = false))
public class Encomenda extends EntidadeGenerica {

	private static final long serialVersionUID = 7762648993793173974L;
	private static final String SEQ_NAME = "seq_encomenda_id";

	private String localizador;
	private String descricao;
	private String origem;
	private String destino;
	private String responsavelRemetente;
	private String telefoneRemetente;
	private String emailRemetente;
	private String responsavelDestinatario;
	private String telefoneDestinatario;
	private String emailDestinatario;
	private Estado estado = Estado.EM_ESTOQUE;

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = SEQ_NAME, sequenceName = SEQ_NAME)
	@GeneratedValue(generator = SEQ_NAME, strategy = GenerationType.SEQUENCE)
	@Override
	public Long getId() {
		return id;
	};

	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	@Column(unique = true)
	public String getLocalizador() {
		return localizador;
	}

	public void setLocalizador(String localizador) {
		this.localizador = localizador;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	@Pattern(regexp = "^[A-Za-záàâãéèêíîïóôõöúûçñÁÀÂÃÉÈÊÍÏÎÓÔÕÖÚÛÇÑ. ]*$", message = "O campo Remetente não pode conter números.")
	@Column(name = "responsavel_remetente")
	public String getResponsavelRemetente() {
		return responsavelRemetente;
	}

	public void setResponsavelRemetente(String responsavelRemetente) {
		this.responsavelRemetente = responsavelRemetente;
	}

	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	@Column(name = "telefone_remetente")
	public String getTelefoneRemetente() {
		return telefoneRemetente;
	}

	public void setTelefoneRemetente(String telefoneRemetente) {
		this.telefoneRemetente = telefoneRemetente;
	}

	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	@Email
	@Column(name = "email_remetente")
	public String getEmailRemetente() {
		return emailRemetente;
	}

	public void setEmailRemetente(String emailRemetente) {
		this.emailRemetente = emailRemetente;
	}

	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	@Pattern(regexp = "^[A-Za-záàâãéèêíîïóôõöúûçñÁÀÂÃÉÈÊÍÏÎÓÔÕÖÚÛÇÑ. ]*$", message = "O campo Remetente não pode conter números.")
	@Column(name = "responsavel_destinatario")
	public String getResponsavelDestinatario() {
		return responsavelDestinatario;
	}

	public void setResponsavelDestinatario(String responsavelDestinatario) {
		this.responsavelDestinatario = responsavelDestinatario;
	}

	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	@Column(name = "telefone_destinatario")
	public String getTelefoneDestinatario() {
		return telefoneDestinatario;
	}

	public void setTelefoneDestinatario(String telefoneDestinatario) {
		this.telefoneDestinatario = telefoneDestinatario;
	}

	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	@Email
	@Column(name = "email_destinatario")
	public String getEmailDestinatario() {
		return emailDestinatario;
	}

	public void setEmailDestinatario(String emailDestinatario) {
		this.emailDestinatario = emailDestinatario;
	}

	@NotNull(message = "Campo obrigatório!")
	@Enumerated(EnumType.STRING)
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
