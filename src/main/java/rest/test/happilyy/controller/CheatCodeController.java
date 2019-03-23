package rest.test.happilyy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rest.test.happilyy.dto.CheatCode;
import rest.test.happilyy.repo.CheatCodeRepository;

@RestController
public class CheatCodeController {
	
	@Autowired
	CheatCodeRepository repo;


    @RequestMapping("/cheat_code")
    public List<CheatCode> greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	
        return repo.getAllCheatCodes();
    }
}