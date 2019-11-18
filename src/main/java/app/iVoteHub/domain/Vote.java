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

@Entity
public class Vote {
	@Transient
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "candidate")
	private Candidate candidate;
	
	@ManyToOne
	@JoinColumn(name = "constituency")
	private Constituency constituency;
	
	/*to make sure votes are unique / verify no double voting
	 * without compromising user confidentiality*/
	@Column(unique = true, nullable = false)
	private String emailHash;

	public Vote() {
		
	}
	
	public Vote (Candidate candidate, Constituency constituency, String email) {
		this.candidate = candidate;
		this.constituency = constituency;
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
