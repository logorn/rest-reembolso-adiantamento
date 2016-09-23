package rest.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ADIANTAMENTO")
public class Adiantamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@DecimalMin("0.01")
	@Column(name="VALOR", nullable=false, updatable=false)
	private double valor;
	
	@AssertFalse
	@Column(name="APROVADO", updatable=true)
	private boolean aprovado;
	
	@NotNull
	@ManyToOne(cascade=CascadeType.ALL)
	private CentroCusto centroCusto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public CentroCusto getCentroCusto() {
		return centroCusto;
	}

	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
	}

	public Adiantamento(double valor, boolean aprovado, CentroCusto centroCusto) {
		super();
		this.valor = valor;
		this.aprovado = aprovado;
		this.centroCusto = centroCusto;
	}

	public Adiantamento() {
		super();
	}

}
