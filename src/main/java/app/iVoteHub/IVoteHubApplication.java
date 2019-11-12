package app.iVoteHub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import app.iVoteHub.domain.Candidate;
import app.iVoteHub.domain.User;
import app.iVoteHub.repositories.CandidateRepository;
import app.iVoteHub.repositories.GeneralUserRepository;
import app.iVoteHub.repositories.VoterRepository;
import app.iVoteHub.services.GeneralUserDetailsService;

@SpringBootApplication
public class IVoteHubApplication implements CommandLineRunner {

	@Autowired
	VoterRepository vRepo;
	
	@Autowired
	CandidateRepository cRepo;
	
	@Autowired
	GeneralUserRepository uRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(IVoteHubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User u = uRepo.findByUsername("Z");
//		if (!u.equals(null)) {
//			uRepo.delete(u);
//		}
//		
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		User c = new Candidate("Zachary", "Z");
//		c.setPassword(encoder.encode("password"));
//		((Candidate) c).setConstituency("Constituency");
//		((Candidate) c).setParty("party");
//		((Candidate) c).setVotes(10000);
//		
//		uRepo.save(c);
//		cRepo.save((Candidate) c);
//		Candidate u = cRepo.findById(1);
//		cRepo.delete(u);

	}

	
}
