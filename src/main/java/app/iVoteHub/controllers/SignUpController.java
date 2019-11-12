package app.iVoteHub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

	@PostMapping("register")
	String signUp () {
		
		return "sign-up";
	}
	
	 
}
