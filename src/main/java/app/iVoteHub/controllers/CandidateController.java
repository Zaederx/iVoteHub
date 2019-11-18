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
import app.iVoteHub.domain.Constituency;
import app.iVoteHub.repositories.CandidateRepository;
import app.iVoteHub.repositories.ConstituencyRepository;

@Controller
@RequestMapping("candidate")
public class CandidateController {

	@Autowired
	CandidateRepository cRepo;
	
	@Autowired
	ConstituencyRepository conRepo;
	
	@GetMapping("/home")
	public String candidateHome() {
		return CAddressBook.C_HOME.jsp();
	}
	
	@GetMapping("/view-polls")
	public String viewPolls(Model model) {
		
		List<Candidate> candidates = (List<Candidate>) cRepo.findAll();
		List<Constituency> constituency = (List<Constituency>) conRepo.findAll();
//		constituency.stream().findAny().filter(con -> con.get)
		model.addAttribute("candidates", candidates);
		model.addAttribute("constituencies", constituency);
		
		
		return "/candidate/all-polls-view";
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
