package rest.dao;

import java.util.List;

import rest.model.TipoDespesa;

public interface TipoDespesaDao {
	public TipoDespesa findById(long id);
	public List<TipoDespesa> findAll();
	public void save(TipoDespesa tipoDespesa);
	public void update(TipoDespesa tipoDespesa);
	public void delete(TipoDespesa tipoDespesa);
	public void shutdown();
}
