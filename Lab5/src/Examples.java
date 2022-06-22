import java.util.LinkedList;

public class Examples {
    EventGuests guestsBST = new EventGuests(
            new DataBST("Steve", new DataBST("Mark", new EmptyBST(), new EmptyBST()),
                    new DataBST("John", new EmptyBST(), new EmptyBST())));
    LinkedList<String> guestList = new LinkedList<String>();
    EventGuests guestLinkedList = new EventGuests(new DataLinkedList(guestList));
    EventGuests guestAVL = new EventGuests(new DataAVL("Steve", new DataAVL("John", new EmptyAVL(), new EmptyAVL()),
            new DataAVL("Mark", new EmptyAVL(), new EmptyAVL())));

    public Examples() {
        guestList.add("Steve");
        guestList.add("John");
        guestList.add("Mark");
    }
}