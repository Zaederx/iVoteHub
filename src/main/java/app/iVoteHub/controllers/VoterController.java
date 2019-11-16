package app.iVoteHub.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.iVoteHub.addressEnums.VAddressBook;
import app.iVoteHub.domain.Candidate;
import app.iVoteHub.domain.Voter;
import app.iVoteHub.modelAttributes.VoteForm;
import app.iVoteHub.repositories.CandidateRepository;
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
	@Autowired
	CandidateRepository cRepo;

	/*Returns voter-home*/
	@GetMapping("/voter-main")
	public String voterHome(@RequestParam(defaultValue = "false", name = "voted",required = false) boolean voted,@ModelAttribute("voter") Voter voter) {
	Print.p("voter-main controller");
	
		return "voter/voter-home";
	}
	
	/* Return the page from which voter can vote.<br>
	 * if the voter has voted, redirects to voter-main*/
	@GetMapping("/vote")
	public String vote( Model model,Principal principal) {
		
		Print.p("VoterController - vote() - principal.getNam()=:"+ principal.getName());
		Voter voter = (Voter)vRepo.findByUsername(principal.getName());
		if (voter == null) {Print.p("voter is null");} else {Print.p("WHAT!!!!!!!!!!!!");}
		if (voter.getVoted()) {
			Print.p("vote - hasVoted Loop");
			Print.p("hasVoted"+voter.getName());
			return "redirect:/voter/voter-main?voted=true";//forward?
		} else {
//			ModelAndView m = new ModelAndView();
			List<Candidate> candidates = (List<Candidate>) cRepo.findAll();
			model.addAttribute("candidates", candidates);
			Print.p("vote - else statement");
			Print.p("vote - voter.getName()"+voter.getName());
			model.addAttribute("name", voter.getName());
			model.addAttribute("voteForm", new VoteForm());
			return VAddressBook.VOTE.jsp();
		}
	}
	@Transactional
	@PostMapping("/vote-post")
	public String votePost(@ModelAttribute("voteForm") VoteForm voteForm, Principal principal) {
		String vUsername = principal.getName();
		Voter voter = vRepo.findByUsername(vUsername);
		Print.p("VoterController - voter.getName():"+voter.getName()); //TODO DELETE
		Print.p("Voter Controller - votePost - voteForm.getVote:"+voteForm.getVote());//TODO DELETE
		voter.setCandidate(voteForm.getVote());
		Print.p("Voter Controller - votePost - voter.getCandidate:"+voter.getCandidate());//TODO delete 
		
		cRepo.findById(voteForm.getVote()).addVote();
		voter.setVoted(true);
		vRepo.save(voter);

		
		return "redirect:/voter/voter-success";
	}
	
	@GetMapping("/voter-success")
	public String successHome() {
		return VAddressBook.VOTE_SUCCESS.jsp();
		
	}

	
	
}
