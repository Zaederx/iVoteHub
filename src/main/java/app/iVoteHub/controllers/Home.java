package app.iVoteHub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Home {

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home () {
		
		return "home";
	}
	
	@GetMapping("login")
	public String login () {
		return "login";
	}
	
	@RequestMapping(value = "login?error", method = RequestMethod.GET)
	public String error (Model model) {
		model.addAttribute("error",true);
		return "login";
	}
}
