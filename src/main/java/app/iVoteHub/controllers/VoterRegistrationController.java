package app.iVoteHub.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import app.iVoteHub.addressEnums.VAddressBook;
import app.iVoteHub.domain.SNI;
import app.iVoteHub.domain.User;
import app.iVoteHub.domain.Voter;
import app.iVoteHub.modelAttributes.VoterRegForm;
import app.iVoteHub.repositories.SNIRepository;
import app.iVoteHub.repositories.VoterRepository;
import app.iVoteHub.validators.VoterRegFormValidator;
import helperClass.Print;




@Controller
public class VoterRegistrationController {
	@Autowired
	SNIRepository sniRepo;
	@Autowired
	VoterRepository vRepo;
	
	@InitBinder("voterForm")
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new VoterRegFormValidator(sniRepo));
	}
	
	
	@GetMapping("voter-registration")
	public String signUp (Model model) {
		Print.p("sign-up");
		model.addAttribute("voterForm", new VoterRegForm());
		model.addAttribute("sni", new SNI());
		return "voter/sign-up";
	}
	
	@PostMapping("register-voter-form")
	public String postForm (@Valid @ModelAttribute(name = "voterForm") VoterRegForm voterForm, BindingResult result, Model model) { 
		Print.p("VoterRegistration - postForm");
	
		if(!result.hasErrors()) {
			SNI sni = getSNI(voterForm.getSniCode());
			sni.setUsed(true);
			User voter = new Voter(voterForm);
			((Voter) voter).setSNI(sni);//so that it also passes SNI object with id.
			vRepo.save((Voter) voter);
			model.addAttribute("voter", voter);
			model.addAttribute("name",voter.getName());
			Print.p("VoterRegistration - postForm - voter.getName()="+ voter.getName());//TODO - DELETE + REMOVE HELPER CLASS
			Print.p("redirect:"+VAddressBook.V_HOME.configUrl());//TODO -DELETE
			return "redirect:"+VAddressBook.V_HOME.configUrl();//TODO - TRY USING JSP DIRECTLY
			}
		return "/login-error";
	
		
		//TODO - REMOVE COMMENT TO SELF
		/*Note to self:
		 * redirect:something - directs url to new ${contextPath+something} url - work after posting data for processing
		 * forward:something - original request sent directly to server - but url on client browser stays unchnaged (lasy url sent by browser)
		 * redirect:forward:something - results in staying on the samge page and url [as forward cannot be appended] and forwarding of request still happens
		*/
	}
	
	
	
	/**
	 * Return an SNI object from db if found.
	 * Returns null otherwise
	 * @param sni - attribute from registration form.
	 * @return true if not used | false if used
	 */
	 private SNI getSNI(String sniCode) {
		 Print.p("getSNI");
		 SNI tableSni = null;
		 try {
		 tableSni = sniRepo.findBySniCode(sniCode);
		 } catch (NullPointerException e) {
			 e.printStackTrace();
			 return tableSni;
		 }
		 return tableSni;
	 }
}
