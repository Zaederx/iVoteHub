package app.iVoteHub.modelAttributes;

/**
 * Class used to perform voter vote.
 * Helps to retrieve user data from Form.
 * @author Zachary Ishmael
 *
 */
public class VoteForm {
	/*The id of the candidate to be chosen */
	private int vote;
	
	public VoteForm () {
	
	}
	
	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}
	
}
