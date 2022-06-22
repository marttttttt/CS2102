import java.util.Collections;
import java.util.LinkedList;

/**
 * The class is used to dissect a binary tree and grab all the data necessary to analyze it
 */
public class DataBT implements IBinTree {
    int data;
    IBinTree left;
    IBinTree right;

    DataBT(int data, IBinTree left, IBinTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // an alternate constructor for when both subtrees are empty
    DataBT(int data) {
        this.data = data;
        this.left = new MtBT();
        this.right = new MtBT();
    }

    // determines whether this node or node in subtree has given element
    public boolean hasElt(int e) {
        return this.data == e || this.left.hasElt(e) || this.right.hasElt(e) ;
    }

    // adds 1 to the number of nodes in the left and right subtrees
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }

    // adds 1 to the height of the taller subtree
    public int height() {
        return 1 + Math.max(this.left.height(), this.right.height());
    }

    /**
     * Checks to see if the dataBT is a heap.
     * @return True if it is a heap.
     */
    public boolean isHeap() {
        if (this.size() == 0) return true;
        else return (this.right.isHeap() && this.left.isHeap() && smallestOnTop());
    }

    /**
     * confirms that the root is smaller than the nodes below it.
     * @return True if the root is smaller than the nodes below it.
     */
    public boolean smallestOnTop() {
        if (this.size() == 1) return true;
        else if (this.left.size() ==  0) {
            return (((DataHeap) right).isBigger(this.data));
        }
        else if (this.right.size() ==  0) {
            return (((DataHeap) left).isBigger(this.data));
        }
        else {
            return (((DataHeap) right).isBigger(this.data)
                    && ((DataHeap) left).isBigger(this.data));
        }
    }

    /**
     * sorts the tree in order to put the heap/IBinTree into a linked list
     * @return The list of values in the tree in ascending order.
     */
    public LinkedList<Integer> sortTree() {
        LinkedList<Integer> treeList = new LinkedList<>();

        if (this.left.size() == 0 && this.right.size() == 0) {
            treeList.add(this.data);
        }
        else if (this.left.size() == 0) {
            treeList.add(this.data);
            treeList.addAll(this.right.sortTree());
        }
        else if (this.right.size() == 0) {
            treeList.add(this.data);
            treeList.addAll(this.left.sortTree());
        }
        else {
            treeList.add(this.data);
            treeList.addAll(this.left.sortTree());
            treeList.addAll(this.right.sortTree());
        }
        Collections.sort(treeList);
        return treeList;
    }
}