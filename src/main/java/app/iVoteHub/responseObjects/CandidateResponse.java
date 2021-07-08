package app.iVoteHub.responseObjects;

import app.iVoteHub.domain.Candidate;

/**
 * CandidateResponse
 */
public class CandidateResponse {

    String name;
    String constituency;
    Integer votes;

    public CandidateResponse() {}
    
    public CandidateResponse(String name, String constituency, Integer votes) {
        this.name = name;
        this.constituency = constituency;
        this.votes = votes;
    }

    public CandidateResponse(Candidate c) {
        this.name = c.getName();
        this.constituency = c.getConstituency().getName();
        this.votes = c.getVotes().size();
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConstituency() {
        return this.constituency;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }

    public Integer getVotes() {
        return this.votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }
    
    
}