package app.iVoteHub.modelAttributes;

/**
 * Class used to perform voter vote.
 * Helps to retrieve user data from Form.
 * @author Zachary Ishmael
 *
 */
public class VoterForm {
	/*The username of the candidate to be chosen */
	private String vote;
	
	public VoterForm () {
	
	}
	
	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}
	
}
