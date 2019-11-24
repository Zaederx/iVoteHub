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
import app.iVoteHub.domain.Party;
import app.iVoteHub.repositories.CandidateRepository;
import app.iVoteHub.repositories.PartyRepository;

@Controller
@RequestMapping("commission")
public class CommissionController {

	@Autowired
	CandidateRepository canRepo;
	
	@Autowired
	PartyRepository pRepo;
	
	@GetMapping("/home")
	public String candidateHome() {
		return CAddressBook.C_HOME.jsp();
	}
	
	@GetMapping("/view-polls")
	public String viewPolls(Model model) {
		
		List<Candidate> candidates = (List<Candidate>) canRepo.findAll();
		List<Party> party = (List<Party>) pRepo.findAll();
//		constituency.stream().findAny().filter(con -> con.get)
		model.addAttribute("candidates", candidates);
		model.addAttribute("parties", party);
//		model.addAttribute("votes", );
		
		
		return "/commission/commission-all-polls-view";
	}
	
	
	
	@GetMapping("/candidate-search") 
	public String candidateSearch() {
		
		return "commission/commission-candidate-search";
	}
//	@GetMapping("/view-individual")
//	public String candidatePoll(Model model) {
//		
//		List<Candidate> candidates = (List<Candidate>) cRepo.findAll();
//		
//		model.addAttribute("candidates", candidates);
//		
//		return "/candidate/candidate-polls-view";
//	}
//	
//	@GetMapping("/view-constituency")
//	public String constituencyPoll(Model model) {
//		
//		List<Candidate> candidates = (List<Candidate>) cRepo.findAll();
//		
//		model.addAttribute("candidates", candidates);
//		
//		return "/candidate/candidate-polls-view";
		
//	}
	
	
	
}
