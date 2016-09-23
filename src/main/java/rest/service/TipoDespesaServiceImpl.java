package rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import rest.dao.TipoDespesaDao;
import rest.model.TipoDespesa;

@Service
@Repository("tipoDespesaService")
public class TipoDespesaServiceImpl implements TipoDespesaService {
  
  @Autowired
  private TipoDespesaDao tipoDespesaDao;

  @Override
  public TipoDespesa findById(long id) {
    return tipoDespesaDao.findById(id);
  }

  @Override
  public List<TipoDespesa> findAll() {
    return tipoDespesaDao.findAll();
  }

  @Override
  public void save(TipoDespesa tipoDespesa) {
	  tipoDespesaDao.save(tipoDespesa);
  }

  @Override
  public void update(TipoDespesa tipoDespesa) {
	  tipoDespesaDao.update(tipoDespesa);
  }

  @Override
  public void delete(TipoDespesa tipoDespesa) {
	  tipoDespesaDao.delete(tipoDespesa);
  }

  @Override
  public void shutdown() {
	  tipoDespesaDao.shutdown();
  }
}
