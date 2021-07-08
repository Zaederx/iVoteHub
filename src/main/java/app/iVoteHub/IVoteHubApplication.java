package app.iVoteHub;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import app.iVoteHub.domain.Candidate;
import app.iVoteHub.domain.Constituency;
import app.iVoteHub.domain.ElectionCommission;
import app.iVoteHub.domain.Party;
import app.iVoteHub.domain.SNI;
import app.iVoteHub.domain.User;
import app.iVoteHub.domain.Voter;
import app.iVoteHub.repositories.CandidateRepository;
import app.iVoteHub.repositories.ConstituencyRepository;
import app.iVoteHub.repositories.ElectionCommissionRepository;
import app.iVoteHub.repositories.PartyRepository;
import app.iVoteHub.repositories.SNIRepository;
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
	PartyRepository pRepo;
	
	@Autowired
	GeneralUserRepository uRepo;
	
	@Autowired
	ConstituencyRepository consRepo;
	
	@Autowired
	SNIRepository sniRepo;
	
	@Autowired
	ElectionCommissionRepository ecRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(IVoteHubApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		// test();//used to fill DB when empty
	}

	/**
	 * Used to fill DB with test data when empty
	 */
	public void test() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		ElectionCommission com = new ElectionCommission();
		
		com.setName("Thomas Anderson");
		com.setPassword(encoder.encode("ADMIN"));
		com.setUsername("ADMIN");
		ecRepo.save(com);
//		//TODO - REMOVE OLD DATA SET
//		//Generate SNI's
		SNI s = new SNI("OXFG75MZ");
		SNI s1 = new SNI("B7F6EM2Y");
		SNI s2 = new SNI("Q7OW5WWM");
		SNI s3 = new SNI("7XP02HJ3");
		SNI s4 = new SNI("FWM4HQEQ");
		SNI s5 = new SNI("R824O2NZ");
		SNI s6 = new SNI("JTP70XGU");
		SNI s7 = new SNI("P8AO57RS");
		SNI s8= new SNI("S3ATWJUZ");
		SNI s9= new SNI("4M6YFNAC");
		SNI s10 = new SNI("RR9E1MBQ");
		SNI s11 = new SNI("DABSP97S");
		SNI s12 = new SNI("XIO0FT40");
		SNI s13 = new SNI("Z4PHBVY9");
		SNI s14 = new SNI("G9H3FM8G");
		SNI s15 = new SNI("4817YN1C");
		SNI s16 = new SNI("70EV6SC4");
		SNI s17 = new SNI("AUTIHS8I");
		SNI s18 = new SNI("72GQU9ZK");
		SNI s19 = new SNI("P4YHAJUX");

		
		sniRepo.save(s);
		sniRepo.save(s1);
		sniRepo.save(s2);
		sniRepo.save(s3);
		sniRepo.save(s4);
		sniRepo.save(s5);
		sniRepo.save(s6);
		sniRepo.save(s7);
		sniRepo.save(s8);
		sniRepo.save(s9);
		sniRepo.save(s10);
		sniRepo.save(s11);
		sniRepo.save(s12);
		sniRepo.save(s13);
		sniRepo.save(s14); 
		sniRepo.save(s15);
		sniRepo.save(s16);
		sniRepo.save(s17);
		sniRepo.save(s18);
		sniRepo.save(s19);
		
		//TODO - Create Voters
		Voter v = new Voter();
		v.setName("Captain Kirk");
		v.setUsername("Z-Voter");
		v.setEmail("email@email.com");
		v.setPassword(encoder.encode("password"));
		v.setSNI(s);
		s.setUsed(true);
		
		
		Voter v1 = new Voter();
		v1.setName("Roger Moore");
		v1.setUsername("P1");
		v1.setEmail("email1@email.com");
		v1.setPassword(encoder.encode("password"));
		v1.setSNI(s1);
		s1.setUsed(true);
		
		
		Voter v2 = new Voter();
		v2.setName("Commander Spock");
		v2.setUsername("Person2");
		v2.setEmail("email2@email.com");
		v2.setPassword(encoder.encode("password"));
		v2.setSNI(s2);
		s2.setUsed(true);
		
		Voter v3 = new Voter();
		v3.setName("David Attenbourough");
		v3.setUsername("Person3");
		v3.setEmail("email3@email.com");
		v3.setPassword(encoder.encode("password"));
		v3.setSNI(s3);
		s3.setUsed(true);
		
		vRepo.save(v);
		vRepo.save(v1);
		vRepo.save(v2);
		vRepo.save(v3);
		
		//TODO - Create Constituencies
		Constituency con = new Constituency("Shangri-la Town");
		Constituency con1 = new Constituency("Northern Kuen-Lun Mountain");
		Constituency con2 = new Constituency("Western Shangri-la");
		consRepo.save(con);
		consRepo.save(con1);
		consRepo.save(con2);
		
		//TODO - Create Parties
		Party p = new Party("Blue Party");
		Party p1 = new Party("Red Party");
		Party p2 = new Party("Yellow Party");
		Party p3 = new Party("Independent");
		pRepo.save(p);
		pRepo.save(p1);
		pRepo.save(p2);
		pRepo.save(p3);
		
		//TODO - Create Candidates
		Candidate c = new Candidate();
		c.setName("Newt Scamander");
		c.setConstituency(con);
		c.setParty(p);
		
		
		Candidate c1 = new Candidate();
		c1.setName("Morgan Freeman");
		c1.setConstituency(con1);
		c1.setParty(p1);
		
		Candidate c2 = new Candidate();
		c2.setName("Senator Palpatine");
		c2.setConstituency(con2);
		c2.setParty(p2);
		
		Candidate c3 = new Candidate();
		c3.setName("Dr Dolittle");
		c3.setConstituency(con);
		c3.setParty(p3);
		
		Candidate c4 = new Candidate();
		c4.setName("Thomas Edison");
		c4.setConstituency(con1);
		c4.setParty(p);
		
		Candidate c5 = new Candidate();
		c5.setName("Peter B. Parker");
		c5.setConstituency(con2);
		c5.setParty(p1);
		
		Candidate c6 = new Candidate();
		c6.setName("Russel M. Nelson");
		c6.setConstituency(con);
		c6.setParty(p2);
		
		Candidate c7 = new Candidate();
		c7.setName("Roger Rabbit");
		c7.setConstituency(con1);
		c7.setParty(p3);
		
		Candidate c8 = new Candidate();
		c8.setName("Byrom Sulli");
		c8.setConstituency(con2);
		c8.setParty(p);
		
	
		cRepo.save(c);
		cRepo.save(c1);
		cRepo.save(c2);
		cRepo.save(c3);
		cRepo.save(c4);
		cRepo.save(c5);
		cRepo.save(c6);
		cRepo.save(c7);
		cRepo.save(c8);
		
	}

	
}
