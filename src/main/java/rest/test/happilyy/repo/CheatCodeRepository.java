package rest.test.happilyy.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import rest.test.happilyy.dto.CheatCode;


//	CREATE TABLE cheat_codes (
//	    cheat_code_id VARCHAR(100),
//	    cheat_code_input VARCHAR(100),
//	    game_name VARCHAR(100),
//	    console_name VARCHAR(100),
//	    Last_Updated Date,
//		PRIMARY KEY (cheat_code_id)
//
//	);


@Component
public class CheatCodeRepository {
	
	@Autowired
	NamedParameterJdbcTemplate template;
	
	private class CheatCodeRowMapper implements RowMapper<CheatCode> {
		public CheatCode mapRow(ResultSet results, int rowNumber)throws SQLException{  
				CheatCode cheatCode = new CheatCode();
				cheatCode.setCheatCodeId(results.getString("cheat_code_id"));
				cheatCode.setCheatCodeInput(results.getString("cheat_code_input"));
				cheatCode.setConsoleName(results.getString("console_name"));
				cheatCode.setGameName(results.getString("game_name"));
				cheatCode.setLastUpdated(results.getDate("Last_Updated"));
				
				return cheatCode;
		}
				
	}
	
	public List<CheatCode> getAllCheatCodes(){
		
		String sql = "Select * from cheat_codes";
		
		List<CheatCode> results = template.query(sql, new CheatCodeRowMapper());		
		
		return results;
		
		
		}
	



	public List<CheatCode> getCheatCodeByConsoleAndGame(String consoleName, String gameName){
	
		String sql = "SELECT * FROM cheat_codes WHERE console_name = :consoleName "
				+ " AND WHERE game_name = :gameName";
		MapSqlParameterSource source = new MapSqlParameterSource();
		
		source.addValue("consoleName", consoleName);
		source.addValue("gameName", gameName);

		
		List<CheatCode> results = template.query(sql,source,new CheatCodeRowMapper());
	
		return results;
		
		}


	public List<CheatCode> getCheatCodeByGame(String gameName){
	
		String sql = "SELECT * FROM cheat_codes WHERE game_name = :gameName";
		MapSqlParameterSource source = new MapSqlParameterSource();
		
		source.addValue("gameName", gameName);
		 
		List<CheatCode> results = template.query(sql,source, new CheatCodeRowMapper());
	
		return results;


		}
	
	public void addCheatCode(String cheatCodeId, String cheatCodeInput, String gameName, String consoleName) {
		
		String sql = "INSERT INTO cheat_codes " + 
				"VALUES (:cheatCodeId, :cheatCodeInput, :gameName, :consoleName, SYSDATE());";
		
		MapSqlParameterSource source = new MapSqlParameterSource();
		
		source.addValue("cheatCodeId", cheatCodeId);
		source.addValue("cheatCodeInput", cheatCodeInput);
		source.addValue("consoleName", consoleName);
		source.addValue("gameName", gameName);

		template.update(sql, source);
		
	}
	




	public void setTemplate(NamedParameterJdbcTemplate template) {
		this.template = template;
	}


	

}
