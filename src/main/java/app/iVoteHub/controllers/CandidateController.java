package app.iVoteHub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.iVoteHub.addressEnums.CAddressBook;
import app.iVoteHub.domain.Candidate;
import app.iVoteHub.repositories.CandidateRepository;

@Controller
@RequestMapping("candidate")
public class CandidateController {

	@Autowired
	CandidateRepository cRepo;
	
	@GetMapping("/home")
	public String candidateHome() {
		return CAddressBook.C_HOME.jsp();
	}
	
	@GetMapping("/view-polls")
	public String viewPolls() {
		
		return "/candidate/all-polls-view";
	}
	
	@GetMapping("/view-individual")
	public String candidatePoll(Model model) {
		
		List<Candidate> candidates = (List<Candidate>) cRepo.findAll();
		
		model.addAttribute("candidates", candidates);
		
		return "/candidate/candidate-polls-view";
	}
	
	@GetMapping("/view-constituency")
	public String constituencyPoll(Model model) {
		
		List<Candidate> candidates = (List<Candidate>) cRepo.findAll();
		
		model.addAttribute("candidates", candidates);
		
		return "/candidate/candidate-polls-view";
		
	}
	
	
	
}
