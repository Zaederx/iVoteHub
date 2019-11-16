package app.iVoteHub.modelAttributes;

/**
 * Class used to perform voter vote.
 * Helps to retrieve user data from Form.
 * @author Zachary Ishmael
 *
 */
public class VoteForm {
	/*The username of the candidate to be chosen */
	private String vote;
	
	public VoteForm () {
	
	}
	
	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}
	
}
