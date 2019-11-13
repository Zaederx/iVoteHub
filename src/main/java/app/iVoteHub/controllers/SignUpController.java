package app.iVoteHub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.iVoteHub.domain.SNI;
import app.iVoteHub.domain.Voter;
import app.iVoteHub.modelAttributes.VoterRegForm;
import app.iVoteHub.repositories.SNIRepository;
import app.iVoteHub.repositories.VoterRepository;
import helperClass.Print;




@Controller
@RequestMapping("register")
public class SignUpController {

	@Autowired
	SNIRepository sniRepo;
	@Autowired
	VoterRepository vRepo;
	
	
	@GetMapping
	String signUp (Model model) {
		Print.p("sign-up");
		model.addAttribute("voterForm", new VoterRegForm());
		model.addAttribute("sni", new SNI());
		return "sign-up";
	}
	
	@PostMapping("/post")
	String postForm (@ModelAttribute(name = "voterForm") VoterRegForm voterForm, Model model) { 
		String view = "";
		Print.p("postForm");
		if (voterForm != null && getSNI(voterForm.getSniNum())!= null) {
			SNI sni = getSNI(voterForm.getSniNum());
			Voter voter = new Voter(voterForm);
			voter.setSNI(sni);//so that it also passes SNI object with id.
			vRepo.save(voter);
			model.addAttribute("voter", voterForm);
			view = "voter-home";
			
		}else {
			view = "register";
		}
		Print.p("postForm:end of method");
		return view;
	}
	
	
	
	/**
	 * Return an SNI object from db if found.
	 * Returns null otherwise
	 * @param sni - attribut from registration form.
	 * @return true if not used | false if used
	 */
	 private SNI getSNI(int sniNum) {
		 Print.p("isNotUsed");
		 SNI tableSni = sniRepo.findBySniCode(sniNum);
		 return tableSni;
	 }
}
