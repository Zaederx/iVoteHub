package app.iVoteHub.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import app.iVoteHub.addressEnums.VoterAddress;
import app.iVoteHub.domain.Voter;
import app.iVoteHub.modelAttributes.VoterForm;
import app.iVoteHub.repositories.VoterRepository;
import helperClass.Print;

/**
 * A controller for all the voter pages.
 * 
 * Controller addresses should correspond to 
 * VoterAddress enum - which acts should act as
 * an authority on matters of url / domain addresses.
 * 
 * @author Zachary Ishmael
 *
 */
@Controller
@RequestMapping("voter")
public class VoterController {
	@Autowired
	VoterRepository vRepo;

	/*Returns voter-home*/
	@GetMapping("/voter-main")
	public String voterHome(@ModelAttribute("voter") Voter voter) {
	Print.p("voter-main controller");

		return "voter/voter-home";
	}
	
	/* Return the page from which voter can vote.<br>
	 * if the voter has voted, redirects to voter-main*/
	@GetMapping("/vote")
	public String vote(@ModelAttribute("voter") Voter voter,@ModelAttribute Model model) {
		if (voter.hasVoted()) {
			Print.p("vote - hasVoted Loop");
			return "redirect:voter/voter-main?voted=true";//forward?
		} else {
//			ModelAndView m = new ModelAndView();
			List<Voter> candidates = (List<Voter>) vRepo.findAll();
			model.addAttribute("candidates", candidates);
			Print.p("vote - else statement");
			System.out.println(voter.getName());
			model.addAttribute("name", voter.getName());
			return VoterAddress.VOTE.jsp();
		}
	}
	
	@PostMapping("/vote-post")
	public String votePost(@ModelAttribute("voterForm") VoterForm voterForm, @ModelAttribute("voter") Voter voter) {
		voter.setCandidate(voterForm.getVote());
		voter.setVoted(true);
		
		return "redirect:"+VoterAddress.HOME.jsp();
	}
	
	
	
}
