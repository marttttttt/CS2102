import java.util.Scanner;

public class VotingMachine {

    private ElectionData voting = new ElectionData();
    private Scanner keyboard = new Scanner(System.in);

    public VotingMachine(ElectionData election) {
        this.voting = election;
    }

    public void printBallot() {
        System.out.println("The candidates are ");
        for (String s : voting.getBallot()) {
            System.out.println(s);
        }
    }

    public void screen() {
        this.printBallot();
        System.out.println("Who do you want to vote for first choice?");
        String candidate1 = keyboard.next();
        System.out.println("Who do you want to vote for second choice?");
        String candidate2 = keyboard.next();
        System.out.println("Who do you want to vote for third choice?");
        String candidate3 = keyboard.next();

        try {
            voting.processVote(candidate1, candidate2, candidate3);
            System.out.println("You voted for " + candidate1 + " " + candidate2
                    + " " + candidate3);
        }
        catch (UnknownCandidateException e) {
            System.out.println("Candidate " + e.getName()
                    + " not found. If you would like to add " + e.getName()
                    + " to the ballot type Y or y. ");
            String response = keyboard.next();
            if (response.equals("Y") || response.equals("y")) {
                try {
                    addWriteIn(e.getName());
                    System.out.println("This candidate was added successfully.");
                }
                catch (CandidateExistsException e2) {
                    System.out.println("This candidate already exists!");
                }
            }
            this.screen();

        }
        catch (DuplicateVotesException e3) {
            System.out.println("You cannot vote for the same candidate twice!");
            this.screen();
        }
    }

    private void addWriteIn(String candidate) throws CandidateExistsException {
        voting.addCandidate(candidate);
    }
}