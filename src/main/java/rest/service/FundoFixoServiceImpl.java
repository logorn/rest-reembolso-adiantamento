package rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import rest.dao.FundoFixoDao;
import rest.model.FundoFixo;

@Service
@Repository("fundoFixoService")
public class FundoFixoServiceImpl implements FundoFixoService {
  
  @Autowired
  private FundoFixoDao fundoFixoDao;

  @Override
  public FundoFixo findById(long id) {
    return fundoFixoDao.findById(id);
  }

  @Override
  public List<FundoFixo> findAll() {
    return fundoFixoDao.findAll();
  }

  @Override
  public void save(FundoFixo fundoFixo) {
	  fundoFixoDao.save(fundoFixo);
  }

  @Override
  public void update(FundoFixo fundoFixo) {
	  fundoFixoDao.update(fundoFixo);
  }

  @Override
  public void delete(FundoFixo fundoFixo) {
	  fundoFixoDao.delete(fundoFixo);
  }

  @Override
  public void shutdown() {
	  fundoFixoDao.shutdown();
  }
}
