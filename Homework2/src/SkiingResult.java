import java.util.LinkedList;

public class SkiingResult implements IEvent {

    int placement;
    LinkedList<Double> laps;
    int penalties;

    SkiingResult(int placement, double lap1, double lap2, double lap3, double lap4, int penalties) {
        this.placement = placement;
        LinkedList<Double> laps = new LinkedList<>();
        laps.add(lap1);
        laps.add(lap2);
        laps.add(lap3);
        laps.add(lap4);
        this.penalties = penalties;
        this.laps = laps;
    }

    public double pointsEarned() {
        double totalLapTime = 0;
        if (laps != null) {
            for (int i = 0; i < laps.size(); i++) {
                totalLapTime += laps.get(i);
            }
        }
        return totalLapTime;
    }
    public double getPenalties() {
        return 5 * penalties;
    }

}
