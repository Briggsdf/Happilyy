package rest.test.happilyy.dto;

import java.util.Date;

public class CheatCode {

	private String cheatCodeId;
	
	private String cheatCodeInput;
	
	private String gameName; 
	
	private String consoleName;
	
	private Date lastUpdated;

	public String getCheatCodeId() {
		return cheatCodeId;
	}

	public void setCheatCodeId(String cheatCodeId) {
		this.cheatCodeId = cheatCodeId;
	}

	public String getCheatCodeInput() {
		return cheatCodeInput;
	}

	public void setCheatCodeInput(String cheatCodeInput) {
		this.cheatCodeInput = cheatCodeInput;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getConsoleName() {
		return consoleName;
	}

	public void setConsoleName(String consoleName) {
		this.consoleName = consoleName;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	} 
	
  
}