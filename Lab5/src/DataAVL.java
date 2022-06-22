public class DataAVL implements IAVL {
    String data;
    IAVL left;
    IAVL right;

    DataAVL(String data, IAVL left, IAVL right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // returns the number of distinct elements in the AVL
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }

    // returns AVL containing all existing elements and the given element
    public IAVL addElt(String elt) {
        if (elt.equals(this.data))
            return this; // not storing duplicate values
        else if (elt.compareTo(this.data) < 0)
            return new DataAVL(this.data, this.left.addElt(elt), this.right);
        else // elt > this.data
            return new DataAVL(this.data, this.left, this.right.addElt(elt));
    }

    // determines whether the given element is in the AVL
    public boolean hasElt(String elt) {
        if (elt.equals(this.data))
            return true;
        else if (elt.compareTo(this.data) < 0)
            return this.left.hasElt(elt);
        else // elt > this.data
            return this.right.hasElt(elt);
    }
}