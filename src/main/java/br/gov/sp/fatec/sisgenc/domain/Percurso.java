package br.gov.sp.fatec.sisgenc.domain;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="tb_percurso")
@AttributeOverride(name = "id_percurso", column = @Column(name = "id_percurso", insertable = false, updatable = false))
public class Percurso extends EntidadeGenerica {

	private static final long serialVersionUID = -1246475284682193214L;
	private static final String SEQ_NAME = "seq_percurso_id";


	private Date data;
	private Encomenda encomenda;
	private String endereco;
	private Estado estado;

	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = SEQ_NAME, sequenceName = SEQ_NAME)
	@GeneratedValue(generator = SEQ_NAME, strategy = GenerationType.SEQUENCE)
	@Override
	public Long getId() {
		return id;
	};
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@OneToMany(fetch=FetchType.LAZY,targetEntity=Encomenda.class)
	@JoinTable(name = "tb_encomenda", joinColumns = @JoinColumn(name = "id_encomenda"))
	public Encomenda getEncomenda() {
		return encomenda;
	}

	public void setEncomenda(Encomenda encomenda) {
		this.encomenda = encomenda;
	}
	
	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@NotNull
	@NotEmpty(message = "Campo obrigatório!")
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
