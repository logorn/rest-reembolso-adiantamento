package rest.dao;

import java.util.List;

import rest.model.Despesa;

public interface DespesaDao {
	public Despesa findById(long id);
	public List<Despesa> findAll();
	public void save(Despesa despesa);
	public void update(Despesa despesa);
	public void delete(Despesa despesa);
	public void shutdown();
}
