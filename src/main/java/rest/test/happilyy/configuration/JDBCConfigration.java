package rest.test.happilyy.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import rest.test.happilyy.repo.CheatCodeRepository;

@Configuration
@ComponentScan("rest.test.happilyy")
public class JDBCConfigration {



	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://bywoliopsog5nuvc:a20pzvsuk4nt70wu@ui0tj7jn8pyv9lp6.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/w0qvlp2ad0mnaj1b?serverTimezone=UTC");
		dataSource.setUsername("bywoliopsog5nuvc");
		dataSource.setPassword("a20pzvsuk4nt70wu");

		return dataSource;

	}


	@Bean
	public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {

		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
		
		return template;
	}
	
	
	@Bean
	public CheatCodeRepository cheatCodeRepository(NamedParameterJdbcTemplate jdbcTemplate) {

		CheatCodeRepository cheatCodeRepository = new CheatCodeRepository();
		cheatCodeRepository.setTemplate(jdbcTemplate);
		
		return cheatCodeRepository;
	}
	
	


}
