package app.iVoteHub.domain;

/**
 * @author Zachary Ishmael
 *
 */

public class SNI {
	
	private int SNI;
	
	private boolean used;
	
	public SNI () {
		used = false;
	}

	public int getSNI() {
		return SNI;
	}

	public void setSNI(int sNI) {
		SNI = sNI;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	
	
}
