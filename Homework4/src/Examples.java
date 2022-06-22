import org.junit.Test;
import static org.junit.Assert.*;

public class Examples {

    HeapChecker HT = new HeapChecker();

    IHeap dataHeap = new DataHeap(3, new DataHeap(4, new MtHeap(), new MtHeap()), new MtHeap());
    IHeap dataHeap2 = new DataHeap(3, new DataHeap(4, new MtHeap(), new MtHeap()), new DataHeap(5, new MtHeap(), new MtHeap()));
    IHeap dataHeap3 = new DataHeap(5, new DataHeap(4, new MtHeap(), new MtHeap()), new DataHeap(5, new MtHeap(), new MtHeap()));
    IHeap dataHeap4 = new DataHeap(4, new MtHeap(), new MtHeap());
    IHeap dataHeap5 = new DataHeap(3, new DataHeap(4, new MtHeap(), new MtHeap()), new DataHeap(5, new MtHeap(), new MtHeap()));
    IHeap dataHeap6 = new DataHeap(3, new DataHeap(3, new MtHeap(), new MtHeap()), new MtHeap());
    IHeap dataHeap7 = new DataHeap(3, new DataHeap(4, new MtHeap(), new MtHeap()), new MtHeap());
    IHeap dataHeap8 = new DataHeap(3, new DataHeap(4, new DataHeap(4, new MtHeap(), new MtHeap()), new MtHeap()), new MtHeap());

    IHeap emptyDataHeap = new MtHeap();


    //Tests for addEltTester
    @Test
    public void testValidHeap()  {
        assertTrue(HT.addEltTester(dataHeap, 6, dataHeap.addElt(6)));
    }

    @Test
    public void testAddedEltOccurWrong() {
        assertFalse(HT.addEltTester(dataHeap2, 3, dataHeap2.addElt(2)));
    }

    @Test
    public void testNotAHeap() {
        assertFalse(HT.addEltTester(dataHeap3, 4, dataHeap3.addElt(4)));
    }

    @Test
    public void testEmpty() {
        assertTrue(HT.addEltTester(emptyDataHeap, 4, dataHeap4));
    }

    @Test
    public void testOtherEltOccurWrong(){
        assertFalse(HT.addEltTester(dataHeap7, 3, dataHeap5.addElt(3)));
    }

    @Test
    public void testWrongNumberOfElements() {
        assertFalse(HT.addEltTester(dataHeap6, 3, dataHeap6));
    }


    //Tests for remEltTester
    @Test
    public void testRemoveValidHeap()  {
        assertTrue(HT.remMinEltTester(dataHeap, dataHeap.remMinElt()));
    }

    @Test
    public void testRemovingEltOccurWrong() {
        assertFalse(HT.remMinEltTester(dataHeap7, dataHeap6.remMinElt()));
    }

    @Test
    public void testRemoveNotAHeap() {
        assertFalse(HT.remMinEltTester(dataHeap3, dataHeap3.remMinElt()));
    }

    @Test
    public void testRemoveFromEmpty() {
        assertTrue(HT.remMinEltTester(emptyDataHeap, emptyDataHeap.remMinElt()));
    }

    @Test
    public void testWrongNumberOfElementsRemove() {
        assertFalse(HT.remMinEltTester(dataHeap4, dataHeap4));
    }

    @Test
    public void testWrongOtherEltOccur() {
        assertFalse(HT.remMinEltTester(dataHeap7, dataHeap8.remMinElt()));
    }

}


