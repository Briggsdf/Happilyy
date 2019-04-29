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
		dataSource.setUrl("jdbc:mysql://localhost:3306/cheat_code?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("Lightlinking21");

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
