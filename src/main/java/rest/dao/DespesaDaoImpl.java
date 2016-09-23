package rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rest.model.Despesa;

@Repository("despesaDao")
@Transactional(readOnly=false)
public class DespesaDaoImpl<T> extends HibernateDaoSupport implements DespesaDao {

  @Override
  public Despesa findById(long id) {
    return (Despesa) getHibernateTemplate().get(Despesa.class, id);
  }

  @Override
  public List<Despesa> findAll() {
    return getHibernateTemplate().loadAll(Despesa.class);
  }

  @Override
  public void save(Despesa despesa) {
    getHibernateTemplate().save(despesa);
  }

  @Override
  public void update(Despesa despesa) {
    getHibernateTemplate().update(despesa); 
  }

  @Override
  public void delete(Despesa despesa) {
    getHibernateTemplate().delete(despesa);
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
