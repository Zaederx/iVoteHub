package app.iVoteHub.responseObjects;

import app.iVoteHub.domain.Party;

/**
 * PartyResponse
 */
public class PartyResponse {
    String name;
    Integer votes;

    public PartyResponse() {}

    public PartyResponse(String name, Integer votes) {
        this.name = name;
        this.votes = votes;
    }

    public PartyResponse(Party p) {
        this.name = p.getName();
        this.votes = p.getVotes().size();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVotes() {
        return this.votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    
}