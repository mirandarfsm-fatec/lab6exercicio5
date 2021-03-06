package br.gov.sp.fatec.sisgenc.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "tb_usuario")
@AttributeOverride(name = "id", column = @Column(name = "id_usuario", insertable = false, updatable = false))
public class Usuario extends EntidadeGenerica implements UserDetails {

	private static final long serialVersionUID = 1L;

	private static final String SEQ_NAME = "seq_usuario_id";

	private String nome;
	private String login;
	private String senha;
	private boolean ativo = true;
	private String email;
	private Set<Perfil> perfis = new HashSet<Perfil>();

	public Usuario() {
	}

	public Usuario(String nome, String login, String senha, boolean ativo,
			String email, Set<Perfil> perfis) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.ativo = ativo;
		this.email = email;
		this.perfis = perfis;
	}

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = SEQ_NAME, sequenceName = SEQ_NAME)
	@GeneratedValue(generator = SEQ_NAME, strategy = GenerationType.SEQUENCE)
	@Override
	@Column(name = "id_usuario")
	public Long getId() {
		return id;
	}

	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	@Pattern(regexp = "^[A-Za-záàâãéèêíîïóôõöúûçñÁÀÂÃÉÈÊÍÏÎÓÔÕÖÚÛÇÑ. ]*$", message = "O campo Nome não pode conter números.")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	@Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotNull(message = "Campo obrigatório!")
	@ElementCollection(targetClass = Perfil.class, fetch = FetchType.EAGER)
	@JoinTable(name = "tb_usuario_perfil", joinColumns = @JoinColumn(name = "id_usuario"), foreignKey = @ForeignKey(name = "fk_usuario_perfil_id_usuario"))
	@Enumerated(EnumType.STRING)
	@Column(name = "id_perfil", nullable = false)
	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}

	@Transient
	public Collection<Perfil> getAuthorities() {
		Set<Perfil> authorities = new HashSet<Perfil>();
		authorities.add(Perfil.ROLE_USER);
		for (Perfil perfil : this.getPerfis()) {
			authorities.add(perfil);
		}
		return authorities;
	}

	@Transient
	public String getPassword() {
		return senha;
	}

	@Transient
	public String getUsername() {
		return login;
	}

	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Transient
	public boolean isEnabled() {
		return ativo;
	}

}
