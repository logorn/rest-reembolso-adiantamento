package rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rest.model.CentroCusto;

@Repository("centroCustoDao")
@Transactional(readOnly=false)
public class CentroCustoDaoImpl<T> extends HibernateDaoSupport implements CentroCustoDao {

  @Override
  public CentroCusto findById(long id) {
    return (CentroCusto) getHibernateTemplate().get(CentroCusto.class, id);
  }

  @Override
  public List<CentroCusto> findAll() {
    return getHibernateTemplate().loadAll(CentroCusto.class);
  }

  @Override
  public void save(CentroCusto centroCusto) {
    getHibernateTemplate().save(centroCusto);
  }

  @Override
  public void update(CentroCusto centroCusto) {
    getHibernateTemplate().update(centroCusto); 
  }

  @Override
  public void delete(CentroCusto centroCusto) {
    getHibernateTemplate().delete(centroCusto);
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
