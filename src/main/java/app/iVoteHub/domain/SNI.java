package app.iVoteHub.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Zachary Ishmael
 * Entity class to represent SNI numbers.
 * SNI stands for Shangri-La National Insurance number.
 */
@Entity(name = "SNI_Table")
public class SNI {
	
	@Id
	private String sniCode;
	
	@OneToOne(mappedBy = "sni")
	private Voter voter;
	@Column
	private boolean used;
	
	public SNI () {
		used = false;
	}

	public SNI(String sniCode) {
		this.sniCode = sniCode;
	}

	public String getSniCode() {
		return sniCode;
	}

	public void setSniCode(String sni) {
		sniCode = sni;
	}

	public boolean getUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	
	
}
