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
import app.iVoteHub.domain.Party;
import app.iVoteHub.repositories.CandidateRepository;
import app.iVoteHub.repositories.PartyRepository;
import app.iVoteHub.responseObjects.CandidateResponse;
import app.iVoteHub.responseObjects.PartyResponse;

@RestController
public class CommissionRest {
	
	@Autowired
	CandidateRepository cRepo;
	
	@Autowired
	PartyRepository pRepo;

	@GetMapping("/candidate/{name}")
	public Candidate getCandidate( @PathVariable("name") String name) {
	System.out.println("At getCandidate Rest mapping");
		Candidate candidate = cRepo.findByName(name);
		return candidate;
	}
	
	@GetMapping("/candidates-all")
	public List<CandidateResponse> getAllCandidates() {
		List<Candidate> candidates = (List<Candidate>) cRepo.findAll();
		List<CandidateResponse> cResponse = new ArrayList<CandidateResponse>();
		candidates.forEach( (c) -> {cResponse.add(new CandidateResponse(c));});
		return cResponse;
	}

	@GetMapping("/parties-all")
	public List<PartyResponse> getAllParties() {
		List<Party> candidates = (List<Party>) pRepo.findAll();
		List<PartyResponse> pResponse = new ArrayList<PartyResponse>();
		candidates.forEach( (p) -> {pResponse.add(new PartyResponse(p));});
		return pResponse;
	}

}
