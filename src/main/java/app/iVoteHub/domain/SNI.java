package app.iVoteHub.domain;

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
	private int sniCode;
	
//	@OneToOne(mappedBy = "sni")
//	private Voter voter;
	
	private boolean used;
	
	public SNI () {
		used = false;
	}

	public int getsniCode() {
		return sniCode;
	}

	public void setsniCode(int sni) {
		sniCode = sni;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	
	
}
