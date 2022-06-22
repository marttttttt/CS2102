public class SkiingResult implements IEvent {

    int placement;
    double lap1;
    double lap2;
    double lap3;
    double lap4;
    int penalties;

    SkiingResult(int placement, double lap1, double lap2, double lap3, double lap4, int penalties) {
        this.placement = placement;
        this.lap1 = lap1;
        this.lap2 = lap2;
        this.lap3 = lap3;
        this.lap4 = lap4;
        this.penalties = penalties;
    }

    public double pointsEarned() {
        return lap1 + lap2 + lap3 + lap4;
    }

    public double getPenalties() {
        return 5 * penalties;
    }

}
