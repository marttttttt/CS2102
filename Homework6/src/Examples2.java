import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class Examples2 {

    // method to set up a ballot and cast votes

    ElectionData Setup1() {
        ElectionData ED = new ElectionData();
        // put candidates on the ballot
        try {
            ED.addCandidate("gompei");
            ED.addCandidate("husky");
            ED.addCandidate("ziggy");
        } catch (Exception e) {}

        // cast votes
        try {
            ED.processVote("gompei", "husky", "ziggy");
            ED.processVote("gompei", "ziggy", "husky");
            ED.processVote("husky", "gompei", "ziggy");
        } catch (Exception e) {}
        return(ED);
    }

    @Test
    public void testMostFirstWinner () {
        assertEquals ("gompei", Setup1().findWinnerMostFirstVotes());
    }

    ElectionData Setup2() {
        ElectionData ED = new ElectionData();
        // put candidates on the ballot
        try {
            ED.addCandidate("gompei");
            ED.addCandidate("husky");
            ED.addCandidate("ziggy");
        } catch (Exception e) {}

        // cast votes
        try {
            ED.processVote("gompei", "husky", "ziggy");
            ED.processVote("ziggy", "gompei", "husky");
            ED.processVote("husky", "gompei", "ziggy");
        } catch (Exception e) {}
        return(ED);
    }

    @Test
    public void testInconclusiveFirstWinner () {
        assertEquals ("Runoff required", Setup2().findWinnerMostFirstVotes());
    }

    @Test
    public void testMostPointsWinner () {
        assertEquals ("gompei", Setup2().findWinnerMostPoints());
    }

    ElectionData Setup3() {
        ElectionData ED = new ElectionData();
        // put candidates on the ballot
        try {
            ED.addCandidate("gompei");
            ED.addCandidate("husky");
            ED.addCandidate("ziggy");
        } catch (Exception e) {}

        return(ED);
    }

    @Test(expected = DuplicateVotesException.class)
    public void processVoteDuplicateException() throws DuplicateVotesException, UnknownCandidateException {
        Setup3().processVote("husky", "ziggy", "ziggy");
    }

    @Test(expected = UnknownCandidateException.class)
    public void processVoteUnknownException() throws DuplicateVotesException, UnknownCandidateException {
        Setup3().processVote("husky", "ziggy", "afj;alja");
    }

    @Test(expected = UnknownCandidateException.class)
    public void processVoteBothException() throws DuplicateVotesException, UnknownCandidateException {
        Setup3().processVote("husky", "husky", "UnknownCandidate");
    }


    ElectionData Setup4() {
        ElectionData ED = new ElectionData();
        // put candidates on the ballot
        try {
            ED.addCandidate("gompei");
            ED.addCandidate("husky");
            ED.addCandidate("ziggy");
        } catch (Exception e) {}

        return(ED);
    }

    @Test(expected = CandidateExistsException.class)
    public void addCandidateExistsException() throws CandidateExistsException {
        Setup4().addCandidate("ziggy");
    }

    @Test
    public void addCandidateNoError() throws CandidateExistsException {
        LinkedList<String> ballot = new LinkedList<String>();
        ballot.add("gompei"); ballot.add("husky"); ballot.add("ziggy"); ballot.add("new cand");
        ElectionData electionData = Setup4();
        electionData.addCandidate("new cand");

        assertEquals(ballot, electionData.getBallot());
    }

}

