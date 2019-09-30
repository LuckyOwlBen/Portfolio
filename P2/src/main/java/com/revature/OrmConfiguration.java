package com.revature;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement 
public class OrmConfiguration {

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(getDataSource());
		sf.setPackagesToScan("com.revature.beans");
		sf.setHibernateProperties(getHibernateProps());
		return sf;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dsrc = new DriverManagerDataSource();
		dsrc.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dsrc.setUrl(System.getenv("REV_DB_URL"));
		dsrc.setUsername(System.getenv("REV_DB_USERNAME"));
		dsrc.setPassword(System.getenv("REV_DB_PASSWORD"));
		return dsrc;
	}
	
	@Bean
	public Properties getHibernateProps() {
		Properties props = new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle8iDialect");
		return props;
	}
	
	@Bean
	public PlatformTransactionManager getTransactionManager() {
		HibernateTransactionManager txman = new HibernateTransactionManager();
		txman.setSessionFactory(getSessionFactory().getObject());
		return txman;
	}
}
