package app.iVoteHub.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Vote Entity class for storing votes.
 * 
 * Votes do not directly reference voters for privacy and 
 * security reasons. Instead an encrypted hash of voters email is used to 
 * ensure privacy of the voters.
 * 
 * @author Zachary Ishmael
 *
 */
@Entity
public class Vote {
	@Transient
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "candidate_id", referencedColumnName = "id")
	private Candidate candidate;
	
	@ManyToOne
	@JoinColumn(name = "constituency_id", referencedColumnName = "id")
	private Party party;
	
	/*to make sure votes are unique / verify no double voting
	 * without compromising user confidentiality*/
	@Column(unique = true, nullable = false)
	private String emailHash;

	public Vote() {
		
	}
	
	public Vote (Candidate candidate, Party party, String email) {
		this.candidate = candidate;
		this.party = party;
		this.emailHash = encoder.encode(email);
		
	}
	public Vote(Candidate c, String email) {
		
	}
	
	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public String getEmail() {
		return emailHash;
	}

	/*Email is hashed on set but not decrypted on get
	 * for the purpose of user confidentiality*/
	public void setEmail(String email) {
		this.emailHash = encoder.encode(email);
	}
	
	
	
}
