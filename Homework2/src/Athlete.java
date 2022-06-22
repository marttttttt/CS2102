public class Athlete {
    FinalResult finalResult;

    Athlete (FinalResult finalResult) {

        this.finalResult = finalResult;
    }

    public boolean betterSkiier(Athlete anAthlete) {
        return (this.finalResult.skiingResult.pointsEarned()
                < anAthlete.finalResult.skiingResult.pointsEarned()) ;
    }

    public boolean betterShooter(Athlete anAthlete) {
        return (this.finalResult.shootingResult.pointsEarned()
                > anAthlete.finalResult.shootingResult.pointsEarned()) ;
    }

    public boolean hasBeaten(Athlete anAthlete) {
        if (this.betterShooter(anAthlete) || this.betterSkiier(anAthlete)) {
            return true;
        }
        else {
            return false;
        }
    }
}
