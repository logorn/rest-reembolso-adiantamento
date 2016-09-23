package rest.dao;

import java.util.List;

import rest.model.Adiantamento;

public interface AdiantamentoDao {
	public Adiantamento findById(long id);
	public List<Adiantamento> findAll();
	public void save(Adiantamento adiantamento);
	public void update(Adiantamento adiantamento);
	public void delete(Adiantamento adiantamento);
	public void shutdown();
}
