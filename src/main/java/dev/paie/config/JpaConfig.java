package dev.paie.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration

public class JpaConfig {

@Bean
// Cette configuration nécessite une source de données configurée.
// Elle s'utilise donc en association avec un autre fichier de configuration
// d éfinissant un bean DataSource.
public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//vendorAdapter.setGenerateDdl(true); 
// activer les logs SQL
vendorAdapter.setShowSql(true);
LocalContainerEntityManagerFactoryBean factory = new
LocalContainerEntityManagerFactoryBean();
factory.setJpaVendorAdapter(vendorAdapter);
// alternative au persistence.xml
factory.setPackagesToScan("dev.paie.entite");
factory.setDataSource(dataSource);
Properties jpaProperties = new Properties(); 
jpaProperties.setProperty("javax.persistence.schema-generation.database.action", "drop-and-create");
factory.setJpaProperties(jpaProperties);
factory.afterPropertiesSet();
return factory.getObject();
}
}

