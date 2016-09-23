package rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rest.model.FundoFixo;

@Repository("fundoFixoDao")
@Transactional(readOnly=false)
public class FundoFixoDaoImpl<T> extends HibernateDaoSupport implements FundoFixoDao {

  @Override
  public FundoFixo findById(long id) {
    return (FundoFixo) getHibernateTemplate().get(FundoFixo.class, id);
  }

  @Override
  public List<FundoFixo> findAll() {
    return getHibernateTemplate().loadAll(FundoFixo.class);
  }

  @Override
  public void save(FundoFixo fundoFixo) {
    getHibernateTemplate().save(fundoFixo);
  }

  @Override
  public void update(FundoFixo fundoFixo) {
    getHibernateTemplate().update(fundoFixo); 
  }

  @Override
  public void delete(FundoFixo fundoFixo) {
    getHibernateTemplate().delete(fundoFixo);
  }

  @Override
  public void shutdown() {
    getHibernateTemplate().getSessionFactory()
    .openSession()
    .createSQLQuery("SHUTDOWN")
    .executeUpdate(); 
  }
  
  @Autowired
  public void init(SessionFactory sessionFactory) {	
    setSessionFactory(sessionFactory);
  }
}
