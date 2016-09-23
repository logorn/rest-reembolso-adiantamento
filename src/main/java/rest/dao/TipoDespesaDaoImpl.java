package rest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import rest.model.TipoDespesa;

@Repository("tipoDespesaDao")
@Transactional(readOnly=false)
public class TipoDespesaDaoImpl<T> extends HibernateDaoSupport implements TipoDespesaDao {

  @Override
  public TipoDespesa findById(long id) {
    return (TipoDespesa) getHibernateTemplate().get(TipoDespesa.class, id);
  }

  @Override
  public List<TipoDespesa> findAll() {
    return getHibernateTemplate().loadAll(TipoDespesa.class);
  }

  @Override
  public void save(TipoDespesa tipoDespesa) {
    getHibernateTemplate().save(tipoDespesa);
  }

  @Override
  public void update(TipoDespesa tipoDespesa) {
    getHibernateTemplate().update(tipoDespesa); 
  }

  @Override
  public void delete(TipoDespesa tipoDespesa) {
    getHibernateTemplate().delete(tipoDespesa);
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
