package br.gov.sp.fatec.sisgenc.domain;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tb_percurso")
@AttributeOverride(name = "id", column = @Column(name = "id_percurso", insertable = false, updatable = false))
public class Percurso extends EntidadeGenerica {

	private static final long serialVersionUID = -1246475284682193214L;
	private static final String SEQ_NAME = "seq_percurso_id";

	private Date data;
	private Encomenda encomenda;
	private String origem;
	private String destino;
	private String estado;

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = SEQ_NAME, sequenceName = SEQ_NAME)
	@GeneratedValue(generator = SEQ_NAME, strategy = GenerationType.SEQUENCE)
	@Override
	public Long getId() {
		return id;
	};

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Encomenda.class)
	@JoinColumn(name = "id_encomenda", foreignKey = @ForeignKey(name = "fk_percurso_id_encomenda"), nullable = false)
	public Encomenda getEncomenda() {
		return encomenda;
	}

	public void setEncomenda(Encomenda encomenda) {
		this.encomenda = encomenda;
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
	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
