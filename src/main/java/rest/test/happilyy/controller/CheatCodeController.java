package rest.test.happilyy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rest.test.happilyy.dto.CheatCode;
import rest.test.happilyy.repo.CheatCodeRepository;

@RestController
public class CheatCodeController {
	
	@Autowired
	CheatCodeRepository repo;


    @RequestMapping("/cheat_code" )
    public List<CheatCode> allCheatCodes(@RequestParam(value="name", defaultValue="World") String name) {
        return repo.getAllCheatCodes();
        
    }
    
    @RequestMapping(value={"/console/{consoleName}"})
    public List<CheatCode> console(@PathVariable String consoleName) {
        return repo.getCheatCodeByConsole(consoleName);
        
    }
   
    @RequestMapping(value={"/game/{gameName}"})
    public List<CheatCode> game(@PathVariable String gameName) {
        return repo.getCheatCodeByGame(gameName);
        
    }
}