package app.iVoteHub.controllers;

import java.util.HashMap;
import java.util.Map;

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

	String s = "At view:";
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home () {
		print(s+"home");
		return "home";
	}
	@GetMapping("login")
	public ModelAndView login () {
		ModelAndView mv = new ModelAndView("login-page");
		
		Map<String,String> usertype = new HashMap<String,String>();
		usertype.put("Voter", "1");
		usertype.put("Candidate", "2");
		
		mv.addObject("usertypeMap", usertype);
		mv.addObject("LoginForm", new LoginForm());
		
		print(s+"login-page");
		return mv;
	}
	

	@PostMapping("loginForm")
	public String login (@ModelAttribute("LoginForm") LoginForm login, Model model) {
	
		print(s+"loginForm");
		String type = "";
		String view = "";
		switch (login.getUsertype()) {
		case "1": type = "VOTER"; view = "/authentication"; break;
		case "2": type = "CANDIDATE"; view = "/authentication"; break;
		default : view = "login-error";
		}
		String concat = type+":"+ login.getUsername();
		model.addAttribute("username", concat);
		System.out.println("This is the selected view:"+view);
		return view;
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

