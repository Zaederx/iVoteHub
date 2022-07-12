package app.iVoteHub.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import app.iVoteHub.addressEnums.CAddressBook;
import app.iVoteHub.addressEnums.VAddressBook;
import app.iVoteHub.domain.User;
import app.iVoteHub.modelAttributes.LoginForm;
import app.iVoteHub.repositories.GeneralUserRepository;
import app.iVoteHub.validators.UserLoginValidator;

@Controller
public class Home {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	@Autowired
	GeneralUserRepository uRepo;
	
	@InitBinder("loginForm")
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new UserLoginValidator(uRepo));
	}
	
	@GetMapping({"/"})
	public String root (Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		boolean hasPermissions = !auth.getAuthorities().isEmpty();//true if not empty
		if (auth != null && hasPermissions) {
			return "redirect:/logged-user";
		}
		return "home";
	}
	
	@GetMapping("logged-user")
	public String loggedUser(@RequestParam(required = false) String uname, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		User u = uRepo.findByUsername(username);
		
		if (u!=null) {
		model.addAttribute("name", u.getName());
		}
		/*Not included in if statement to protect against timing based hacker strategies for
		 * determining true users */
		String authority =  auth.getAuthorities().stream().findFirst().get().getAuthority();
		
		print("Home - loggedUser - authroity:"+authority);
		switch (authority) {
		
		case "ROLE_VOTER": print("Home-loggedUser-VOTER");return VAddressBook.V_HOME.jsp();
		
		case "ROLE_ELECTION_COMMISSION": print("Home-loggedUser-COMMISION");return CAddressBook.C_HOME.jsp();
		
		}
		return "home";
	}

	String s = "At view:";
	@GetMapping("home")
	public String home (Model model) {
		print(s+"home");
		return "home";
	}
	
	/*Login form redirects to home if user has an
	 * "iVoteHub" cookie with valid user credentials*/
	@GetMapping("login")
	public String login (Model model) {
		model.addAttribute("loginForm", new LoginForm());
		String uname = SecurityContextHolder.getContext().getAuthentication().getName();//gets the username
		System.out.println("username is:"+uname);
		if (!uname.equals("anonymousUser")) {
			System.out.println("Home: login - redirect:logged-user");
			model.addAttribute("name", uname);
			return "redirect:logged-user?name="+uname;
		}
		print(s+"login-page");
		return "login-page";
	}
	
	@PostMapping("preprocessing")
	public String loginPrep(HttpServletRequest request, @Valid @ModelAttribute("loginForm")LoginForm loginForm, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			System.out.println("\n\n************hasErrors*************\n\n");
			return "login-page";
		}
		/*keeps request as a post request after interception at this controller.
		The user login form request will not be accepted by spring security otherwise*/
		request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
		return "redirect:/authenticate";
	}
	
	
	@GetMapping("login-success")
	public String loginSuccess () {
		return "home";
	}

	@GetMapping("logout-success")
	public String logout() {
		return "user-logout";
	}

	
	public void print(String s) {
		System.out.println(s);
	}
}

