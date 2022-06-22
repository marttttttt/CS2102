import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class Examples {

    ShootingRound aRound1 = new ShootingRound(0, true);
    ShootingRound aRound2 = new ShootingRound(3, true);
    ShootingRound aRound3 = new ShootingRound(4, true);
    ShootingRound aRound4 = new ShootingRound(5, true);

    ShootingRound anotherRound1 = new ShootingRound(4, false);
    ShootingRound anotherRound2 = new ShootingRound(5, false);
    ShootingRound anotherRound3 = new ShootingRound(3, false);
    ShootingRound anotherRound4 = new ShootingRound(5, false);

    LinkedList<ShootingRound> shootingRoundsList = new LinkedList<ShootingRound>();
    LinkedList<ShootingRound> anotherShootingRoundsList = new LinkedList<ShootingRound>();
    LinkedList<ShootingRound> aThirdShootingRoundsList = new LinkedList<>();
    LinkedList<ShootingRound> aDNFShootingRoundsList = new LinkedList<>();

    ShootingResult aShootingResult = new ShootingResult(shootingRoundsList);
    ShootingResult anotherShootingResult = new ShootingResult(anotherShootingRoundsList);
    ShootingResult aThirdShootingResult = new ShootingResult(aThirdShootingRoundsList);
    ShootingResult aDNFShootingResult = new ShootingResult(aDNFShootingRoundsList);

    LinkedList<Double> lapsList = new LinkedList<Double>();
    LinkedList<Double> anotherLapsList = new LinkedList<Double>();
    LinkedList<Double> aThirdLapsList = new LinkedList<Double>();

    SkiingResult aSkiingResult = new SkiingResult(2, 2.5, 2.25,
            2.75, 3.0, 2);
    SkiingResult anotherSkiingResult = new SkiingResult(3, 4.25, 3.5,
            3.75, 4.00,  5);

    MassStartResult aMassStartResult = new MassStartResult(3, 4, 6.5,
            7.25, 7.0, 6.75, 3);

    FinalResult aFinalResult = new FinalResult(aShootingResult, aSkiingResult);
    FinalResult anotherFinalResult = new FinalResult(anotherShootingResult, anotherSkiingResult);
    FinalResult aThirdFinalResult = new FinalResult(anotherShootingResult, aSkiingResult);
    FinalResult aDNFinalResult = new FinalResult(aDNFShootingResult, aSkiingResult);

    Athlete anAthlete = new Athlete(aFinalResult, "Steve");// 493.5
    Athlete anotherAthlete = new Athlete(anotherFinalResult, "Jenna");// 217.5
    Athlete aThirdAthlete = new Athlete(aThirdFinalResult, "Ben");// 193.5
    Athlete aDNFAthlete = new Athlete(aDNFinalResult, "Olivia");
    Athlete anotherDNFAthlete = new Athlete(aDNFinalResult, "Jeff");

    Athlete anAthlete2 = new Athlete(anotherFinalResult, "Steve");// 217.5
    Athlete anotherAthlete2 = new Athlete(aThirdFinalResult, "Jenna");// 193.5
    Athlete aThirdAthlete2 = new Athlete(aThirdFinalResult, "Ben");// 193.5

    LinkedList<Athlete> anAthletesList = new LinkedList<>();
    LinkedList<Athlete> anotherAthletesList = new LinkedList<>();
    LinkedList<Athlete> aThirdAthletesList = new LinkedList<>();

    LinkedList<String> emptyAthletesList = new LinkedList<>();
    LinkedList<String> aDNFAthletesList = new LinkedList<>();

    Competition aCompetition = new Competition(4, anAthletesList);
    Competition anotherCompetition = new Competition(4, anotherAthletesList);
    Competition aThirdCompetition =  new Competition(4, aThirdAthletesList);

    @Before
    public void setUp() {
        aShootingResult.shootingRounds.add(aRound1);
        aShootingResult.shootingRounds.add(aRound2);
        aShootingResult.shootingRounds.add(aRound3);
        aShootingResult.shootingRounds.add(aRound4);

        anotherShootingResult.shootingRounds.add(anotherRound1);
        anotherShootingResult.shootingRounds.add(anotherRound2);
        anotherShootingResult.shootingRounds.add(anotherRound3);
        anotherShootingResult.shootingRounds.add(anotherRound4);

        aThirdShootingResult.shootingRounds.add(aRound2);
        aThirdShootingResult.shootingRounds.add(aRound4);
        aThirdShootingResult.shootingRounds.add(anotherRound1);
        aThirdShootingResult.shootingRounds.add(anotherRound3);

        aDNFShootingResult.shootingRounds.add(aRound1);
        aDNFShootingResult.shootingRounds.add(aRound2);
        aDNFShootingResult.shootingRounds.add(aRound3);

        anAthletesList.add(anAthlete);
        anAthletesList.add(anotherAthlete);
        anAthletesList.add(aThirdAthlete);

        anotherAthletesList.add(anAthlete);
        anotherAthletesList.add(aDNFAthlete);
        anotherAthletesList.add(anotherAthlete);
        anotherAthletesList.add(aThirdAthlete);
        anotherAthletesList.add(anotherDNFAthlete);

        aThirdAthletesList.add(aThirdAthlete2);
        aThirdAthletesList.add(anAthlete2);
        aThirdAthletesList.add(anotherAthlete2);

        aDNFAthletesList.add(aDNFAthlete.name);
        aDNFAthletesList.add(anotherDNFAthlete.name);

    }

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
    public void testAThirdFinalScore() {
        assertEquals(193.50, aThirdFinalResult.finalScore(), 0.00);
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
    public void testAThirdHasBeaten() { assertTrue(aThirdAthlete.hasBeaten(anAthlete));}

    @Test
    public void testAFourthHasBeaten() { assertFalse(anAthlete.hasBeaten(aThirdAthlete));}

    @Test
    public void testPointEarnedSkiingEmpty() {
        aSkiingResult.laps = new LinkedList<Double>();
        assertEquals(0.00, aSkiingResult.pointsEarned(), 0.00);
    }

    @Test
    public void testPointsEarnedMassStart() {
        assertEquals(27.5, aMassStartResult.pointsEarned(), 0.0);
    }

    @Test
    public void testGetPenaltiesMassStart() {
        assertEquals(15.0,  aMassStartResult.getPenalties(), 0.0);
    }

    @Test
    public void testPointEarnedShootingEmpty() {
        aShootingResult.shootingRounds = new LinkedList<ShootingRound>();
        assertEquals(0.00, aShootingResult.pointsEarned(), 0.00);
    }

    @Test
    public void testBestRoundByType() {
        assertSame(aRound4, aShootingResult.bestRoundByType(true));
    }

    @Test
    public void testAnotherBestRoundByType() {
        assertSame(null, anotherShootingResult.bestRoundByType(true));
    }

    @Test
    public void testAThirdBestRoundByType() {
        assertSame(aRound4, aThirdShootingResult.bestRoundByType(true));
    }

    @Test
    public void testAFourthBestRoundByType() {
        assertSame(anotherRound1, aThirdShootingResult.bestRoundByType(false));
    }

    @Test
    public void testAFifthBestRoundByType() {
        assertSame(anotherRound4, anotherShootingResult.bestRoundByType(false));
    }

    @Test
    public void testShootingDNF() {
        assertEquals(emptyAthletesList, aCompetition.shootingDNF());
    }

    @Test
    public void testAnotherShootingDNF() {
        assertEquals(aDNFAthletesList, anotherCompetition.shootingDNF());
    }

    @Test
    public void testFinalScoreForAthlete() {
        assertEquals(493.5, aCompetition.finalScoreForAthlete("Steve"), 0.0);
    }

    @Test
    public void testAnotherFinalScoreForAthlete() {
        assertEquals(217.5, aCompetition.finalScoreForAthlete("Jenna"), 0.0);
    }

    @Test
    public void testAnyImprovement() {
        assertFalse(aCompetition.anyImprovement(aThirdCompetition));
    }

    @Test
    public void testAnotherAnyImprovement() {
        assertFalse(aThirdCompetition.anyImprovement(aThirdCompetition));
    }

    @Test
    public void testAThirdAnyImprovement() {
        assertTrue(aThirdCompetition.anyImprovement(aCompetition));
    }
}