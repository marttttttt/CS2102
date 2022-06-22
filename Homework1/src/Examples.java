import static org.junit.Assert.*;
import org.junit.Test;
public class Examples {
    ShootingRound aRound1 = new ShootingRound(1);
    ShootingRound aRound2 = new ShootingRound(2);
    ShootingRound aRound3 = new ShootingRound(3);
    ShootingRound aRound4 = new ShootingRound(6);

    ShootingRound anotherRound1 = new ShootingRound(4);
    ShootingRound anotherRound2 = new ShootingRound(5);
    ShootingRound anotherRound3 = new ShootingRound(5);
    ShootingRound anotherRound4 = new ShootingRound(3);

    ShootingResult aShootingResult = new ShootingResult(aRound1, aRound2, aRound3, aRound4);
    ShootingResult anotherShootingResult = new ShootingResult(anotherRound1,
            anotherRound2, anotherRound3, anotherRound4);

    SkiingResult aSkiingResult = new SkiingResult(2, 2.25, 2.5,
            2.75, 3.0, 2);
    SkiingResult anotherSkiingResult = new SkiingResult(3, 4.25, 3.5,
            3.75, 4.00, 5);

    FinalResult aFinalResult = new FinalResult(aShootingResult, aSkiingResult);
    FinalResult anotherFinalResult = new FinalResult(anotherShootingResult, anotherSkiingResult);
    FinalResult aThirdFinalResult = new FinalResult(anotherShootingResult, aSkiingResult);

    Athlete anAthlete = new Athlete(aFinalResult);
    Athlete anotherAthlete = new Athlete(anotherFinalResult);
    Athlete aThirdAthlete = new Athlete(aThirdFinalResult);

    @Test
    public void testGetPenaltiesShooting() {
        assertEquals(480.00,
                aShootingResult.getPenalties(), 0.00);
    }

    @Test
    public void testAnotherGetPenaltiesShooting() {
        assertEquals(180.00,
                anotherShootingResult.getPenalties(), 0.00);
    }

    @Test
    public void testPointsEarnedShooting() {
        assertEquals(12.00, aShootingResult.pointsEarned(), 0.00);
    }

    @Test
    public void testAnotherPointsEarnedShooting() {
        assertEquals(17.00, anotherShootingResult.pointsEarned(), 0.00);
    }

    @Test
    public void testGetPenaltiesSkiing() {
        assertEquals(10.00,
                aSkiingResult.getPenalties(), 0.00);
    }

    @Test
    public void testAnotherGetPenaltiesSkiing() {
        assertEquals(25.00,
                anotherSkiingResult.getPenalties(), 0.00);
    }

    @Test
    public void testPointsEarnedSkiing() {
        assertEquals(10.50, aSkiingResult.pointsEarned(), 0.00);
    }

    @Test
    public void testAnotherPointsEarnedSkiing() {
        assertEquals(15.50, anotherSkiingResult.pointsEarned(), 0.00);
    }

    @Test
    public void testFinalScore() {
        assertEquals(493.50, aFinalResult.finalScore(), 0.00);
    }

    @Test
    public void testAnotherFinalScore() {
        assertEquals(217.50, anotherFinalResult.finalScore(), 0.00);
    }

    @Test
    public void testBetterSkiier() {
        assertTrue(anAthlete.betterSkiier(anotherAthlete));
    }

    @Test
    public void testAnotherBetterSkiier() {
        assertFalse(anAthlete.betterSkiier(aThirdAthlete));
    }

    @Test
    public void testBetterShooter() {
        assertFalse(anAthlete.betterShooter(anotherAthlete));
    }

    @Test
    public void testAnotherBetterShooter() {
        assertFalse(anAthlete.betterShooter(aThirdAthlete));
    }

    @Test
    public void testHasBeaten() {
        assertTrue(anAthlete.hasBeaten(anotherAthlete));
    }

    @Test
    public void testAnotherHasBeaten() {
        assertTrue(anotherAthlete.hasBeaten(anAthlete));
    }

    @Test
    public void testAThirdHasBeaten() {
        assertTrue(aThirdAthlete.hasBeaten(anAthlete));
    }

    @Test
    public void testAFourthHasBeaten() { assertFalse(anAthlete.hasBeaten(aThirdAthlete));}
}
