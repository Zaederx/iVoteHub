package app.iVoteHub.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.iVoteHub.domain.Candidate;
import app.iVoteHub.repositories.CandidateRepository;

@RestController
@RequestMapping("commission-rest/")
public class CommissionRest {
	
	@Autowired
	CandidateRepository cRepo;
	

	@GetMapping("candidate/{name}")
	public Candidate getCandidate( @PathVariable("name") String name) {
	System.out.println("At getCandidate Rest mapping");
		Candidate candidate = cRepo.findByName(name);
		return candidate;
	}
	
	@GetMapping("candidate-all")
	public List<Candidate> getAllCandidates() {
		List<Candidate> candidates = (List<Candidate>) cRepo.findAll();
		return candidates;
	}

}
