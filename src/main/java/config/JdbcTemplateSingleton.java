package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JdbcTemplateSingleton {

	public JdbcTemplateSingleton() {
		// TODO Auto-generated constructor stub
	}
	
//	 @Bean
//	 @Primary
//	 public DataSource getDataSource() {
//	    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//	    dataSourceBuilder.driverClassName("org.sqlite.JDBC");
//	    dataSourceBuilder.url("jdbc:sqlite:memory:school_db?cache=shared");
//	    dataSourceBuilder.password("");
//	    return dataSourceBuilder.build();
//	 }
	
	@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}

}
