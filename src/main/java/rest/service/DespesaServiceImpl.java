package rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import rest.dao.DespesaDao;
import rest.model.Despesa;

@Service
@Repository("despesaService")
public class DespesaServiceImpl implements DespesaService {
  
  @Autowired
  private DespesaDao despesaDao;

  @Override
  public Despesa findById(long id) {
    return despesaDao.findById(id);
  }

  @Override
  public List<Despesa> findAll() {
    return despesaDao.findAll();
  }

  @Override
  public void save(Despesa despesa) {
	  despesaDao.save(despesa);
  }

  @Override
  public void update(Despesa despesa) {
	  despesaDao.update(despesa);
  }

  @Override
  public void delete(Despesa despesa) {
	  despesaDao.delete(despesa);
  }

  @Override
  public void shutdown() {
	  despesaDao.shutdown();
  }
}
