import java.util.LinkedList;

public interface IBinTree {
    // determines whether element is in the tree
    boolean hasElt(int e);
    // returns number of nodes in the tree; counts duplicate elements as separate items
    int size();
    // returns depth of longest branch in the tree
    int height();

    /**
     * Checks to see if the dataBT is a heap.
     * @return True if it is a heap.
     */
    boolean isHeap();

    /**
     * sorts the tree in order to put the heap/IBinTree into a linked list
     * @return The list of values in the tree in ascending order.
     */
    LinkedList sortTree();
}