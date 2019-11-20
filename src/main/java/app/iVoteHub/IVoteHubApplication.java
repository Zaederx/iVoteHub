package app.iVoteHub;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import app.iVoteHub.domain.Candidate;
import app.iVoteHub.domain.Constituency;
import app.iVoteHub.domain.User;
import app.iVoteHub.domain.Voter;
import app.iVoteHub.repositories.CandidateRepository;
import app.iVoteHub.repositories.ConstituencyRepository;
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
	ConstituencyRepository conRepo;
	
	@Autowired
	GeneralUserRepository uRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(IVoteHubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		Voter v = new Voter();
//		v.setName("Zach");
//		v.setUsername("user");
//		v.setEmail("email@email.com");
//		v.setPassword(encoder.encode("pword"));
//		v.setId(3);
//		vRepo.save(v);
//		
//		vRepo.delete(v);
		/*Can cast UserType to User and save/ delete from User Repo
		 * */
//		Optional<User> u = uRepo.findById(1);
//		if (!u.equals(null)) {
//			
//			uRepo.delete(u.get());
//		}
////	
		Constituency con = new Constituency("Main party");
		con.setCount(0);
		conRepo.save(con);
//		
//		BCryptPasswordEncoder encoder2 = new BCryptPasswordEncoder();
//		Candidate c = new Candidate("Zach", "Z");
//		c.setPassword(encoder2.encode("password"));
//		((Candidate) c).setConstituency(con);
//		((Candidate) c).setParty("party2");
//		cRepo.save(c); //works
//		c.setId(1);
//		cRepo.delete(c);
		
//		uRepo.delete(c); //works
//		uRepo.save(c);//works
//		cRepo.save((Candidate) c);
//		Candidate u = cRepo.findById(1);
//		cRepo.delete(u);

	}

	
}
