package rest.model;

import java.io.Serializable;

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
@Table(name="DESPESA")
public class Despesa implements Serializable {

	private static final long serialVersionUID = -5794746025963890107L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private TipoDespesa tipoDespesa;
	
	@NotNull
	@ManyToOne(cascade=CascadeType.ALL)
	private CentroCusto centroCusto;
	
	@DecimalMin("0.01")
	@Column(name="VALOR", nullable=false, unique=false, updatable=false)
	private double valor;
	
	@AssertFalse
	@Column(name="APROVADO")
	private boolean aprovado;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}
	
	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	
	public CentroCusto getCentroCusto() {
		return centroCusto;
	}
	
	public void setCentroCusto(CentroCusto centroCusto) {
		this.centroCusto = centroCusto;
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
	
	public Despesa(TipoDespesa tipoDespesa, CentroCusto centroCusto, double valor) {
		super();
		this.tipoDespesa = tipoDespesa;
		this.centroCusto = centroCusto;
		this.valor = valor;
	}
	
	public Despesa() {
		super();
	}
	
}
