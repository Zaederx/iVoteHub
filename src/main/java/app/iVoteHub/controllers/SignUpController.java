package app.iVoteHub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import app.iVoteHub.domain.SNI;
import app.iVoteHub.domain.Voter;

@Controller
public class SignUpController {

	@GetMapping("register")
	String signUp (@ModelAttribute(name = "voter") Voter voter, @ModelAttribute(name="sni") SNI sni) { 
		
		return "sign-up";
	}
	
	 
}
