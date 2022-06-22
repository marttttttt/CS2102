import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

class ElectionData {
    private LinkedList<String> ballot = new LinkedList<>();
    private HashMap<String, Integer> firstChoiceVotes = new HashMap<>();
    private HashMap<String, Integer> secondChoiceVotes = new HashMap<>();
    private HashMap<String, Integer> thirdChoiceVotes = new HashMap<>();
    private HashMap<String, HashMap<String, Integer>> votes = new HashMap<>();

    ElectionData() {}

    public LinkedList<String> getBallot() {
        return this.ballot;
    }

    public String findWinnerMostFirstVotes() {
        double totalFirstVotes = 0.0;
        int mostFirstVotes = Collections.max(firstChoiceVotes.values());
        String result = "";
        String winner = "";

        for (String candidate : firstChoiceVotes.keySet()) {
            totalFirstVotes += firstChoiceVotes.get(candidate);

            if (firstChoiceVotes.get(candidate) == mostFirstVotes) {
                winner = candidate;
            }
        }

        if (mostFirstVotes/totalFirstVotes > 0.5) {
            result = winner;
        }
        else result = "Runoff required";
        return result;
    }

    public String findWinnerMostPoints() {
        int mostPoints = 0;
        String winner = "";
        for (String candidate : firstChoiceVotes.keySet()) {
            if (getPoints(candidate) > mostPoints) {
                mostPoints = getPoints(candidate);
                winner = candidate;
            }
        }
        return winner;
    }

    private int getPoints(String candidate) {
        return 3 * firstChoiceVotes.get(candidate) + 2 * secondChoiceVotes.get(candidate)
                + thirdChoiceVotes.get(candidate);
    }

    public void processVote(String choice1, String choice2, String choice3)
            throws DuplicateVotesException, UnknownCandidateException {

        boolean allOnBallot = onBallot(choice1) && onBallot(choice2) && onBallot(choice3);
        if (allOnBallot && !(choice1.equals(choice2)) && !(choice1.equals(choice3)) && !(choice2.equals(choice3))) {
            firstChoiceVotes.put(choice1, firstChoiceVotes.get(choice1) + 1);
            secondChoiceVotes.put(choice2, secondChoiceVotes.get(choice2) + 1);
            thirdChoiceVotes.put(choice3, thirdChoiceVotes.get(choice3) + 1);
        }
        else if (!(onBallot(choice1))) {
            throw new UnknownCandidateException(choice1);
        }
        else if (!(onBallot(choice2))) {
            throw new UnknownCandidateException(choice2);
        }
        else if (!(onBallot(choice3))) {
            throw new UnknownCandidateException(choice3);
        }
        else if (isDuplicate(choice1, choice2, choice3)) {
            throw new DuplicateVotesException(choice1);
        }
        else if (isDuplicate(choice2, choice1, choice3)) {
            throw new DuplicateVotesException(choice2);
        }
        else if (isDuplicate(choice3, choice2, choice1)) {
            throw new DuplicateVotesException(choice3);
        }

        votes.put("First Choice", firstChoiceVotes);
        votes.put("Second Choice", secondChoiceVotes);
        votes.put("Third Choice", thirdChoiceVotes);
    }

    private boolean onBallot(String candidate) {
        return ballot.contains(candidate);
    }

    private boolean isDuplicate(String choice1, String choice2, String choice3) {
        return choice1.equals(choice2) || choice1.equals(choice2);
    }

    public void addCandidate(String candidate) throws CandidateExistsException {

        if (ballot.contains(candidate)) {
            throw new CandidateExistsException(candidate);
        }
        ballot.add(candidate);
        firstChoiceVotes.put(candidate, 0);
        secondChoiceVotes.put(candidate, 0);
        thirdChoiceVotes.put(candidate, 0);
    }
}