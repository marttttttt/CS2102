import java.util.LinkedList;

public class DataLinkedList implements ISet {
    LinkedList<String> list;

    public DataLinkedList(LinkedList<String> l) {
        this.list = l;
    }

    String data;

    @Override
    // returns DataLinkedList with the added element
    public ISet addElt(String elt) {
        this.list.add(elt);
        return this;
    }

    @Override
    // returns the size of the list
    public int size() {
        return this.list.size();
    }

    @Override
    // returns true if the list contains the element
    public boolean hasElt(String elt) {
        return this.list.contains(elt);
    }

}