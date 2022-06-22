import java.util.LinkedList;

/**
 * the class is intened to be used when a branch is empty or when something is empty
 */
public class MtBT implements IBinTree {
    MtBT(){}

    // returns false since empty tree has no elements
    public boolean hasElt(int e) {
        return false;
    }

    // returns 0 since empty tree has no elements
    public int size() {
        return 0;
    }

    // returns 0 since empty tree has no branches
    public int height() {
        return 0;
    }

    /**
     * Checks to see if the dataBT is a heap.
     * @return True if it is a heap.
     */
    public boolean isHeap() {
        return true;
    }

    /**
     * sorts the tree in order to put the heap/IBinTree into a linked list
     * @return The list of values in the tree in ascending order.
     */
    public LinkedList sortTree() {
        return new LinkedList<Integer>();
    }
}