package app.iVoteHub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
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
	@PostMapping("loginForm")
	public String login (Model model,@RequestAttribute(required = true, name = "usertype")
	String usertype, @RequestAttribute(value="username") String username) {
		String type = "";
		String view = "";
		switch (usertype) {
		case "1": type = "VOTER"; view = "/authenticate"; break;
		case "2": type = "CANDIDATE"; view = "/authenticate"; break;
		default : view = "login";
		}
		String concat = type+":"+username;
		model.addAttribute("username", concat);
		
		return view;
	}
	
	@RequestMapping(value = "login?error", method = RequestMethod.GET)
	public String error (Model model) {
		model.addAttribute("error",true);
		return "login";
	}
}
