package rest.test.happilyy.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.jdbc.core.JdbcTemplate;
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
	JdbcTemplate template;
	
	
	

	public List<CheatCode> getAllCheatCodes(){
		
		
		
		String sql = "Select * from cheat_codes";
		
		List<Map<String, Object>> results = template.queryForList(sql);
		List<CheatCode> cheats = new ArrayList<CheatCode>();
		
		for(Map<String, Object> result: results) {
			CheatCode cheatCode = new CheatCode();
			cheatCode.setCheatCodeId((String)result.get("cheat_code_id"));
			cheatCode.setCheatCodeInput((String)result.get("cheat_code_input"));
			cheatCode.setConsoleName((String)result.get("console_name"));
			cheatCode.setGameName((String)result.get("game_name"));
			cheatCode.setLastUpdated((Date)result.get("Last_Updated"));
			cheats.add(cheatCode);
			
		}
		
		return cheats;
		
		
	}
	




	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}


	

}
