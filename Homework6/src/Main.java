public class Main {

    public static void main(String[] args) {
        ElectionData setup1 = new Examples().Setup1();
        ElectionData setup2 = new Examples().Setup2();
        ElectionData setup3 = new Examples().Setup3();

        VotingMachine vote1 = new VotingMachine(setup1);
        vote1.screen();

        VotingMachine vote2 = new VotingMachine(setup2);
        //vote2.screen();

        VotingMachine vote3 = new VotingMachine(setup3);
        //vote3.screen();
    }
}
