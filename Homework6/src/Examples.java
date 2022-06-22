import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class Examples {

    ElectionData Setup1 () {

        ElectionData ED = new ElectionData();

        try {

            ED.addCandidate("gompei");
            ED.addCandidate("husky");
            ED.addCandidate("ziggy");

        } catch (Exception e) {}

        try {

            ED.processVote("gompei", "husky", "ziggy");
            ED.processVote("gompei", "ziggy", "husky");
            ED.processVote("husky", "gompei", "ziggy");

        } catch (Exception e) {}

        return(ED);

    }

    ElectionData Setup2 () {

        ElectionData ED = new ElectionData();

        try {

            ED.addCandidate("gompei");
            ED.addCandidate("husky");
            ED.addCandidate("ziggy");

        } catch (Exception e) {}

        try {

            ED.processVote("gompei", "husky", "ziggy");
            ED.processVote("gompei", "ziggy", "husky");
            ED.processVote("husky", "gompei", "ziggy");
            ED.processVote("husky", "ziggy", "gompei");

        } catch (Exception e) {}

        return(ED);

    }

    ElectionData Setup3 () {

        ElectionData ED = new ElectionData();

        try {

            ED.addCandidate("gompei");
            ED.addCandidate("husky");
            ED.addCandidate("ziggy");
            ED.addCandidate("steve");

        } catch (Exception e) {}

        try {

            ED.processVote("gompei", "husky", "ziggy");
            ED.processVote("gompei", "husky", "ziggy");
            ED.processVote("ziggy", "husky", "gompei");
            ED.processVote("ziggy", "husky", "gompei");
            ED.processVote("steve", "husky", "gompei");

        } catch (Exception e) {}

        return(ED);

    }

    @Test(expected = CandidateExistsException.class)
    public void testCandidateExistsException() throws CandidateExistsException {
        Setup1().addCandidate("gompei");
    }

    @Test(expected = DuplicateVotesException.class)
    public void testDuplicateVotesException() throws DuplicateVotesException, UnknownCandidateException {
        Setup1().processVote("gompei", "gompei", "husky");
    }

    @Test(expected = UnknownCandidateException.class)
    public void testUnknownCandidateException() throws DuplicateVotesException, UnknownCandidateException {
        Setup1().processVote("gompei", "gompe", "husky");
    }

    @Test(expected = UnknownCandidateException.class)
    public void testBothExceptions() throws DuplicateVotesException, UnknownCandidateException {
        Setup1().processVote("gompei", "gompei", "husk");
    }

    @Test
    public void testFindWinnerMostFirstVotes() {
        assertEquals("gompei", Setup1().findWinnerMostFirstVotes());
    }

    @Test
    public void testFindWinnerMostFirstVotes2() {
        assertEquals("Runoff required", Setup2().findWinnerMostFirstVotes());
    }

    @Test
    public void testFindWinnerMostPoints() {
        assertEquals("gompei", Setup1().findWinnerMostPoints());
    }

    @Test
    public void testFindWinnerMostPoints2() {
        LinkedList<String> test = new LinkedList<>();
        test.add("husky");
        test.add("gompei");
        assertTrue(test.contains(Setup2().findWinnerMostPoints()));
    }

    @Test
    public void testFindWinnerMostPoints3() {
        assertEquals("husky", Setup3().findWinnerMostPoints());
    }
}