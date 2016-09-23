package rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import rest.dao.AdiantamentoDao;
import rest.model.Adiantamento;

@Service
@Repository("adiantamentoService")
public class AdiantamentoServiceImpl implements AdiantamentoService {
  
  @Autowired
  private AdiantamentoDao adiantamentoDao;

  @Override
  public Adiantamento findById(long id) {
    return adiantamentoDao.findById(id);
  }

  @Override
  public List<Adiantamento> findAll() {
    return adiantamentoDao.findAll();
  }

  @Override
  public void save(Adiantamento adiantamento) {
	  adiantamentoDao.save(adiantamento);
  }

  @Override
  public void update(Adiantamento adiantamento) {
	  adiantamentoDao.update(adiantamento);
  }

  @Override
  public void delete(Adiantamento adiantamento) {
	  adiantamentoDao.delete(adiantamento);
  }

  @Override
  public void shutdown() {
	  adiantamentoDao.shutdown();
  }
}
