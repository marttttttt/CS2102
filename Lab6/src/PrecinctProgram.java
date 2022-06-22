import java.util.Scanner;


public class PrecinctProgram {

    public static void main(String[] args){
        Precinct worcester12;
        worcester12 = new Precinct("Worcester12", "130 Winter Street", 1673);
        System.out.println(worcester12);

        System.out.println("Input an integer");
        Scanner keyboard = new Scanner(System.in);
        int amount = keyboard.nextInt();

        Precinct anotherPrecinct = worcester12.grow(amount);
        System.out.println(anotherPrecinct.toString() + "\n");

        System.out.println("Enter Precinct Name");
        keyboard.nextLine();
        String aName = keyboard.nextLine();

        System.out.println("Enter Precinct Address");
        String anAddress = keyboard.nextLine();

        System.out.println("Enter Precinct Population");
        int aPop = keyboard.nextInt();

        Precinct newPrecinct = new Precinct(aName, anAddress, aPop);
        System.out.println(newPrecinct.toString());

    }




}
