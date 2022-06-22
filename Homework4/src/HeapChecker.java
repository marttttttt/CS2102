import java.util.Collections;
import java.util.LinkedList;

/**
 * the class is designers a person can call the class with a method and knwo if an item was added/removed from the list properly
 */
public class HeapChecker {

    /**
     * It takes in the differnt paramiters and addes the int to the heap then compares it to the IBinTree to see they match
     * it first confimes that the heape goes from smallest to largest, then is checks to make sure he IBin tree and the heap are the same size.
     * @param hOriginal The heap before the element was added.
     * @param element The element to be added to the heap.
     * @param hAdded The Binary tree after the element is added.
     * @return True is hAdded is a correct solution to hOriginal with the element.
     */
    public boolean  addEltTester(IHeap hOriginal, int element, IBinTree hAdded) {
        LinkedList<Integer> addedList = hOriginal.sortTree();
        addedList.add(element);
        Collections.sort(addedList);
        return (hAdded.isHeap() && hAdded.sortTree().equals(addedList));
    }

    /**
     * It takes in the both the heap and binary tree and the two shoudl match in the that they are both decending to ascending order
     * it also checks they are the same size.
     * @param hOriginal The heap before the element was removed.
     * @param hRemoved The Binary tree after the element has been removed.
     * @return True if hRemoved is a correct solution to hOriginal without the smallest element.
     */
    public boolean remMinEltTester(IHeap hOriginal, IBinTree hRemoved) {
        LinkedList<Integer> removedList = hOriginal.sortTree();
        if (removedList.size() == 0 && hRemoved.sortTree().size() == 0) {
            return true;
        }
        removedList.removeFirst();
        return (hRemoved.isHeap() && hRemoved.sortTree().equals(removedList));
    }
}
