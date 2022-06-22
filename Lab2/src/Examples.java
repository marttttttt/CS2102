import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {
    Fish aFish = new Fish(5, 1.00);

    Shark aShark = new Shark(5, 3);
    Shark anotherShark = new Shark(16, 0);

    Boa aBoa = new Boa("Drake", 8, "people");
    Boa anotherBoa = new Boa("TPain", 8, "mice");

    Dillo aDillo = new Dillo(4, false);

    @Test
    public void isFishAnimal() {
        assertTrue(aFish.isLenWithin(3, 6));
    }

    @Test
    public void isSharkAnimal() {
        assertTrue(aFish.isLenWithin(3, 8));
    }

    @Test
    public void isSharkShort() {
        assertFalse(aShark.isNormalSize());
    }

    @Test
    public void isSharkLong() {
        assertTrue(anotherShark.isNormalSize());
    }

    @Test
    public void isSharkDanger()  {
        assertTrue(aShark.isDangerToPeople());
    }

    @Test
    public void isSharkSafe() {
        assertFalse(anotherShark.isDangerToPeople());
    }

    @Test
    public void isBoaDanger() {
        assertTrue(aBoa.isDangerToPeople());
    }

    @Test
    public void isBoaSafe() {
        assertFalse(anotherBoa.isDangerToPeople());
    }

    @Test
    public void isDilloDanger() {
        assertFalse(aDillo.isDangerToPeople());
    }

    @Test
    public void isFishDanger() {
        assertFalse(aFish.isDangerToPeople());
    }
}
