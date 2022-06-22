import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples2 {
    Earthquake1 E1 = new Earthquake1();
    LinkedList<Double> noData = new LinkedList<Double>();
    LinkedList<Double> threeDates = new LinkedList<Double>();
    LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
    LinkedList<MaxHzReport> OctReports = new LinkedList<MaxHzReport>();
    LinkedList<MaxHzReport> MayReports = new LinkedList<MaxHzReport>();

    public EarthquakeExamples2() {
        threeDates.add(20151013.0);
        threeDates.add(10.0);
        threeDates.add(5.0);
        threeDates.add(20151020.0);
        threeDates.add(40.0);
        threeDates.add(50.0);
        threeDates.add(45.0);
        threeDates.add(20151101.0);
        threeDates.add(6.0);
        NovReports.add(new MaxHzReport(20151101.0, 6.0));

        OctReports.add(new MaxHzReport(20151013.0, 10.0));
        OctReports.add(new MaxHzReport(20151020.0, 50.0));
    }

    @Test
    public void instructorTestEQ() {
        assertEquals(NovReports,
                E1.dailyMaxForMonth(threeDates, 11));
    }

    @Test
    public void testDailyMaxForMonth() {
        assertEquals(MayReports,
                E1.dailyMaxForMonth(threeDates, 5));
    }

    @Test
    public void testDailyMaxForMonthAgain() {
        assertEquals(OctReports,
                E1.dailyMaxForMonth(threeDates, 10));

    }
}

/*
Subtasks:
- check if data is date
    - if so check if desired month
        - add date to max report
        - filter readings up until next date
        - store highest reading
        - add reading to max report
 */