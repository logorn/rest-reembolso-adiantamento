package rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import rest.dao.CentroCustoDao;
import rest.model.CentroCusto;

@Service
@Repository("centroCustoService")
public class CentroCustoServiceImpl implements CentroCustoService {
  
  @Autowired
  private CentroCustoDao centroCustoDao;

  @Override
  public CentroCusto findById(long id) {
    return centroCustoDao.findById(id);
  }

  @Override
  public List<CentroCusto> findAll() {
    return centroCustoDao.findAll();
  }

  @Override
  public void save(CentroCusto centroCusto) {
	  centroCustoDao.save(centroCusto);
  }

  @Override
  public void update(CentroCusto centroCusto) {
	  centroCustoDao.update(centroCusto);
  }

  @Override
  public void delete(CentroCusto centroCusto) {
	  centroCustoDao.delete(centroCusto);
  }

  @Override
  public void shutdown() {
	  centroCustoDao.shutdown();
  }
}
