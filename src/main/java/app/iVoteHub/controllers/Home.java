package app.iVoteHub.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.iVoteHub.modelAttributes.LoginForm;

@Controller
public class Home {
	
	@GetMapping("/")
	public String root () {
		return "redirect:home";
	}

	String s = "At view:";
	@GetMapping("home")
	public String home () {
		print(s+"home");
		return "home";
	}
	
	@GetMapping("login")
	public String login () {
		
		print(s+"login-page");
		return "login-page";
	}
	
	@GetMapping("login-success")
	public String loginSuccess () {
		return "homeHome";
	}

	
	@RequestMapping(value = "error-login", method = RequestMethod.GET)
	public String error (Model model) {
		model.addAttribute("error",true);
		print(s+"error-login");
		print("Login error occured!!!!");
		return "login-error";
	}
	
	public void print(String s) {
		System.out.println(s);
	}
}

