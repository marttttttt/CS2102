import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {

    public Examples(){}
    Song HapBD = new Song("Happy Birthday", 18);
    Song Spider = new Song("The Itsy Bitsy Spider", 15);

    @Test

    public void checkHBLen() {
        assertEquals(18, HapBD.lenInSeconds);
    }

    @Test

    public void checkSpider() {
        assertEquals(8, Spider.lenInSeconds);
    }

    /*
    // This shows what a test case looks like
    @Test
    public void simpleCheck() {
	assertEquals(4, 4);
    }
    */

}

