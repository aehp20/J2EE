package com.aehp.template.config;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.validation.Validator;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class DataBaseConfig {

	// ------------------------------------------------ Config properties.

	/**
	 * Creates a resource bundle.
	 */
	protected static ResourceBundle propertyResourceBundle = PropertyResourceBundle
			.getBundle("application");

	/**
	 * The database platform.
	 */
	private String jndiDatasource = getProperty("jdbc.jndi.datasource");

	/**
	 * The schema.
	 */
	private String schema = getProperty("jdbc.schema");

	/**
	 * The database platform.
	 */
	private String persistenceUnitName = getProperty("jdbc.persistenceUnitName");

	/**
	 * The database platform.
	 */
	private String databasePlatform = getProperty("jdbc.dialect");

	/**
	 * The flag to generate or not DDL.
	 */
	private boolean generateDdl = new Boolean(getProperty("jdbc.generateDdl"));

	/**
	 * True to output SQL, <code>false</code> otherwise.
	 */
	private boolean showSql = new Boolean(getProperty("jdbc.showSql"));

	// ------------------------------------------------ Placeholders.

	/**
	 * Configures a property source placeholder.
	 * 
	 * @return a property source placeholder.
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/**
	 * Gets the property.
	 * 
	 * @param key
	 *            the key to search.
	 * @return the property.
	 */
	public static String getProperty(String key) {
		return propertyResourceBundle.getString(key);
	}

	// ------------------------------------------------ JDBC/DAO configuration.

	/**
	 * Gets the datasource.
	 * 
	 * @return the datasource.
	 */
	@Bean(destroyMethod = "")
	public DataSource dataSource() {
		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName(jndiDatasource);
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setExpectedType(DataSource.class);
		try {
			jndiObjectFactoryBean.afterPropertiesSet();
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
		return (DataSource) jndiObjectFactoryBean.getObject();
	}

	/**
	 * Gets the JPA vendor adapter.
	 * 
	 * @return the JPA vendor adapter.
	 */
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setGenerateDdl(generateDdl);
		jpaVendorAdapter.setShowSql(showSql);
		jpaVendorAdapter.setDatabasePlatform(databasePlatform);
		return jpaVendorAdapter;
	}

	/**
	 * Creates an entity manager factory.
	 * 
	 * @return the local entity manager factory.
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
		entityManagerFactory
				.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		entityManagerFactory.setPersistenceUnitName(persistenceUnitName);
		entityManagerFactory.getJpaPropertyMap().put(
				Environment.DEFAULT_SCHEMA, schema);
		return entityManagerFactory;
	}

	/**
	 * Creates the transaction manager.
	 * 
	 * @return the transaction manager.
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}

	/**
	 * Creates a persistence annotation bean post processor.
	 * 
	 * @return a persistence annotation bean post processor.
	 */
	@Bean
	public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
		return new PersistenceAnnotationBeanPostProcessor();
	}

	// ------------------------------------------------ JSR-303 configuration.

	/**
	 * Gets a JSR-303 validator.
	 * 
	 * @return a JSR-303 validator.
	 */
	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}

	// ------------------------------------------------ Misc configuration.

}