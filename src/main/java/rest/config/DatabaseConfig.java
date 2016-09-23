package rest.config;

import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class DatabaseConfig {

  @Bean
  public BasicDataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    
    dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
    dataSource.setUrl("jdbc:hsqldb:mem:testdb;shutdown=true"); 
    dataSource.setUsername("SA");
    dataSource.setPassword("");
    
    return dataSource;
  }
  
  @Bean 
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    
    sessionFactory.setDataSource(dataSource());
    Properties hibernateProperties = new Properties();
    hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
    hibernateProperties.put("hibernate.hbm2ddl.auto", "create");
    hibernateProperties.put("hibernate.order_inserts", "true");
    hibernateProperties.put("hibernate.order_updates", "true");
    hibernateProperties.put("hibernate.jdbc.batch_size", "2");
    sessionFactory.setPackagesToScan("rest");
    
    sessionFactory.setHibernateProperties(hibernateProperties);
    return sessionFactory;
  } 
}