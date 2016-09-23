package rest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="FUNDO_FIXO")
public class FundoFixo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="FUNDO", nullable=false, updatable=true)
	private double fundo;
	
	@Column(name="SALDO", nullable=false, updatable=true)
	private double saldo;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.ALL)
	private List<Despesa> despesas;

	public long getId() {
		return id;
	}

	public void setFundo(double fundo) {
		this.fundo = fundo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}

	public FundoFixo(double fundo, double saldo, List<Despesa> despesas) {
		super();
		this.fundo = fundo;
		this.saldo = saldo;
		this.despesas = despesas;
	}

	public FundoFixo() {
		super();
	}
}
