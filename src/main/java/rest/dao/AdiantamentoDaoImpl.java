package rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rest.model.Adiantamento;

@Repository("adiantamentoDao")
@Transactional(readOnly=false)
public class AdiantamentoDaoImpl<T> extends HibernateDaoSupport implements AdiantamentoDao {

  @Override
  public Adiantamento findById(long id) {
    return (Adiantamento) getHibernateTemplate().get(Adiantamento.class, id);
  }

  @Override
  public List<Adiantamento> findAll() {
    return getHibernateTemplate().loadAll(Adiantamento.class);
  }

  @Override
  public void save(Adiantamento adiantamento) {
    getHibernateTemplate().save(adiantamento);
  }

  @Override
  public void update(Adiantamento adiantamento) {
    getHibernateTemplate().update(adiantamento); 
  }

  @Override
  public void delete(Adiantamento adiantamento) {
    getHibernateTemplate().delete(adiantamento);
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
