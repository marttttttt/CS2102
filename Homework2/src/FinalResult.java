public class FinalResult {

  ShootingResult shootingResult;
  SkiingResult skiingResult;

  FinalResult(ShootingResult shootingResult,SkiingResult skiingResult){
      this.shootingResult = shootingResult;
      this.skiingResult = skiingResult;
  }

  public double finalScore() {
    if (skiingResult.placement == 1) {
        return skiingResult.pointsEarned() + skiingResult.getPenalties() + shootingResult.getPenalties() - 10;
      }
    else if (skiingResult.placement == 2) {
        return skiingResult.pointsEarned() + skiingResult.getPenalties() + shootingResult.getPenalties() - 7;
    }
    else if (skiingResult.placement == 3) {
        return skiingResult.pointsEarned() + skiingResult.getPenalties() + shootingResult.getPenalties() - 3;
    }
    else if (skiingResult.placement == 4) {
        return skiingResult.pointsEarned() + skiingResult.getPenalties() + shootingResult.getPenalties() - 1;
    }
    else {
        return skiingResult.pointsEarned() + skiingResult.getPenalties() + shootingResult.getPenalties();
    }
  }
}
