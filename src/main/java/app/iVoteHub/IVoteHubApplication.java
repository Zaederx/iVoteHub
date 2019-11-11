package app.iVoteHub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import app.iVoteHub.domain.Candidate;
import app.iVoteHub.repositories.CandidateRepository;
import app.iVoteHub.repositories.VoterRepository;

@SpringBootApplication
public class IVoteHubApplication implements CommandLineRunner {

	@Autowired
	VoterRepository vRepo;
	
	@Autowired
	CandidateRepository cRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(IVoteHubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		Candidate c = new Candidate("Zachary", "Z");
//		c.setPassword(encoder.encode("password"));
//		c.setConstituency("Constituency");
//		c.setParty("party");
//		c.setVotes(10000);
//		
//		cRepo.save(c);
	}

	
}
