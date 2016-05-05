package br.gov.sp.fatec.sisgenc.domain;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tb_encomenda")
@AttributeOverride(name = "id_encomenda", column = @Column(name = "id_encomenda", insertable = false, updatable = false))
public class Encomenda extends EntidadeGenerica {

	private static final long serialVersionUID = 7762648993793173974L;
	private static final String SEQ_NAME = "seq_encomenda_id";

	private String localizador;
	private String descricao;
	private Usuario responsavel;
	private String origem;
	private String destino;
	private String telefone;
	private List<Percurso> percursos;
	private boolean ativo;

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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Percurso.class)
	@JoinTable(name = "tb_percurso", joinColumns = @JoinColumn(name = "id_encomenda"), foreignKey = @ForeignKey(name = "percurso_id_encomenda_fkey"))
	public List<Percurso> getPercursos() {
		return percursos;
	}

	public void setPercursos(List<Percurso> percursos) {
		this.percursos = percursos;
	}

}
