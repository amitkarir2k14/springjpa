package app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.OpenJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import app.repository.SpitterRepository;
import app.repository.SpittleRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses={SpitterRepository.class,SpittleRepository.class})
@ComponentScan(basePackages = { "app" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
public class RootConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/amit");
		ds.setUsername("root");
		ds.setPassword("root");
		
		
		return ds;
	}
	public Properties additionalProperties() {
	      Properties properties = new Properties();
	      properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	      return properties;
	   }
	
	/*@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
	 OpenJpaVendorAdapter adapter = new OpenJpaVendorAdapter();
	  adapter.setDatabase(Database.MYSQL);
	  adapter.setShowSql(true);
	  adapter.setGenerateDdl(false);
	  return adapter;
	}*/

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
			JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		emfb.setJpaVendorAdapter(jpaVendorAdapter);
		emfb.setPackagesToScan("app.pojos");
		emfb.setJpaProperties(additionalProperties());
		return emfb;
	}
	
//	@Bean
//	public JndiObjectFactoryBean entityManagerFactory() {
//	JndiObjectFactoryBean jndiObjectFB = new JndiObjectFactoryBean();
//	  jndiObjectFB.setJndiName("jdbc/SpittrDS");
//	  return jndiObjectFB;
//	}
}
