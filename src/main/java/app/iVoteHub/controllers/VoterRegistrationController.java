package app.iVoteHub.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.iVoteHub.addressEnums.VoterAddress;
import app.iVoteHub.domain.SNI;
import app.iVoteHub.domain.Voter;
import app.iVoteHub.modelAttributes.VoterRegForm;
import app.iVoteHub.repositories.SNIRepository;
import app.iVoteHub.repositories.VoterRepository;
import helperClass.Print;




@Controller
public class VoterRegistrationController {

	@Autowired
	SNIRepository sniRepo;
	@Autowired
	VoterRepository vRepo;
	
	
	@GetMapping("voter-registration")
	public String signUp (Model model) {
		Print.p("sign-up");
		model.addAttribute("voterForm", new VoterRegForm());
		model.addAttribute("sni", new SNI());
		return "voter/sign-up";
	}
	
	@PostMapping("register-voter-form")
	public String postForm (@ModelAttribute(name = "voterForm") VoterRegForm voterForm, Model model, HttpServletRequest request) { 
		Print.p("postForm");
	
		
		if (voterForm != null && getSNI(voterForm.getSniNum())!= null) {
			SNI sni = getSNI(voterForm.getSniNum());
			sni.setUsed(true);
			Voter voter = new Voter(voterForm);
			voter.setSNI(sni);//so that it also passes SNI object with id.
			vRepo.save(voter);
			model.addAttribute("voter", voter);
			model.addAttribute("name",voter.getName());
			Print.p("redirect:"+request.getContextPath()+VoterAddress.HOME.configUrl());
			return "redirect:"+request.getContextPath()+VoterAddress.HOME.configUrl();
		}
		return "login-error";
		
		
		
		
		
		/*Note to self:
		 * redirect:something - directs url to new ${contextPath+something} url - work after posting data for processing
		 * forward:something - original request sent directly to server - but url on client browser stays unchnaged (lasy url sent by browser)
		 * redirect:forward:something - results in staying on the samge page and url [as forward cannot be appended] and forwarding of request still happens
		*/
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
