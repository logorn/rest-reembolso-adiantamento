package rest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import rest.constants.ValidacaoRegex;

@Entity
@Table(name="CENTRO_CUSTO")
public class CentroCusto implements Serializable{

	private static final long serialVersionUID = -1273097419717924222L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@NotNull
	@Column(name="CENTRO_CUSTO", unique=true, updatable=false)
	private String centroCusto;
	
	@NotNull
	@Pattern(regexp=ValidacaoRegex.NOME_PROPRIO, message="Nome de Centro de Custo inválido")
	@Column(name="NOME", unique=true, updatable=false)
	private String nome;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.ALL)  
	private List<Despesa> despesas;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade=CascadeType.ALL)  
	private List<Adiantamento> adiantamentos;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCentroCusto() {
		return centroCusto;
	}
	
	public void setCentroCusto(String centroCusto) {
		this.centroCusto = centroCusto;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Despesa> getDespesas() {
		return despesas;
	}
	
	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}
	
	
	public List<Adiantamento> getAdiantamentos() {
		return adiantamentos;
	}

	public void setAdiantamentos(List<Adiantamento> adiantamentos) {
		this.adiantamentos = adiantamentos;
	}

	public CentroCusto(String centroCusto, String nome) {
		super();
		this.centroCusto = centroCusto;
		this.nome = nome;
	}

	public CentroCusto() {
		super();
	}
}
