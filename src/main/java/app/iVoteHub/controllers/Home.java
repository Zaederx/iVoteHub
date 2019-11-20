package app.iVoteHub.controllers;





import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.iVoteHub.addressEnums.CAddressBook;
import app.iVoteHub.addressEnums.HomeAddressBook;
import app.iVoteHub.addressEnums.Role;
import app.iVoteHub.addressEnums.VAddressBook;
import app.iVoteHub.domain.User;
import app.iVoteHub.modelAttributes.LoginForm;
import app.iVoteHub.repositories.GeneralUserRepository;
import app.iVoteHub.validators.UserLoginValidator;

@Controller
public class Home {
	
	@Autowired
	GeneralUserRepository uRepo;
	
	@InitBinder("loginForm")
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new UserLoginValidator(uRepo));
	}
	
	@GetMapping("/")
	public String root (Model model) {
	
		return "redirect:/home";
	}
	
	@GetMapping("logged-user")
	public String loggedUser() {
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		String authority =  auth.getAuthorities().stream().findFirst().get().getAuthority();
		print("Home - loggedUser - authroity:"+authority);
		switch (authority) {
		
		case "ROLE_VOTER": print("Home-loggedUser-VOTER");return VAddressBook.V_HOME.jsp() ;
		
		case "ROLE_CANDIDATE": print("Home-loggedUser-CANDIDATE");return CAddressBook.C_HOME.jsp();
		
		}
		return "redirect:/home";
	}

	String s = "At view:";
	@GetMapping("home")
	public String home (Model model) {
		print(s+"home");
		return "home";
	}
	
	@GetMapping("login")
	public String login (Model model) {
		model.addAttribute("loginForm", new LoginForm());
		print(s+"login-page");
		return "login-page";
	}
	
	@PostMapping("preprocessing")
	public String loginPrep(HttpServletRequest request, @Valid @ModelAttribute("loginForm")LoginForm loginForm, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			System.out.println("\n\n************hasErrors*************\n\n");
			return "login-page";
		}
		System.out.println("preprocessing - no errors");
		System.out.println(request.getRequestURI());
		try {
			request.login(loginForm.getUsername(), loginForm.getPassword());
		} catch (ServletException e) {
			System.out.println("User Already Authenticated");
		}
		return "redirect:/logged-user";
	}
	
	
	@GetMapping("login-success")
	public String loginSuccess () {
		return "homeHome";
	}

	@GetMapping("logout-success")
	public String logout() {
		return "user-logout";
	}

	@RequestMapping(value = "error-login", method = RequestMethod.GET)
	public String error (Model model) {
//		model.addAttribute("error",true); use later for ajax?
		print(s+"error-login");
		print("Login error occured!!!!");
		return "login-error";
	}
	
	public void print(String s) {
		System.out.println(s);
	}
}

