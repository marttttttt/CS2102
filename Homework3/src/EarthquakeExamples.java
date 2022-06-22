import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
    Earthquake1 E1 = new Earthquake1();
    Earthquake2 E2 = new Earthquake2();
    LinkedList<Double> noData = new LinkedList<Double>();
    LinkedList<Double> threeDates = new LinkedList<Double>();
    LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();


    LinkedList<Double> testList = new LinkedList<Double>();
    LinkedList<MaxHzReport> testRept = new LinkedList<MaxHzReport>();

    public EarthquakeExamples() {
        threeDates.add(20151013.0);
        threeDates.add(10.0);
        threeDates.add(5.0);
        threeDates.add(20151020.0);
        threeDates.add(40.0);
        threeDates.add(50.0);
        threeDates.add(45.0);
        threeDates.add(20151101.0);
        threeDates.add(6.0);
        NovReports.add(new MaxHzReport(20151101.0,6.0));

        testList.add(20000413.0);
        testList.add(-1.0);
        testList.add(0.0);
        testList.add(50.0);
        testList.add(20000505.0);
        testList.add(-1.0);
        testList.add(50.0);
        testList.add(0.0);
        testList.add(20000510.0);
        testList.add(50.0);
        testList.add(-999.0);
        testList.add(0.0);
        testList.add(20000520.0);
        testList.add(50.0);
        testList.add(-1.0);
        testList.add(0.0);
        testList.add(20000601.0);
        testList.add(50.0);
        testList.add(-1.0);
        testList.add(0.0);
        testRept.add(new MaxHzReport(20000505.0, 50.0));
        testRept.add(new MaxHzReport(20000510.0, 50.0));
        testRept.add(new MaxHzReport(20000520.0, 50.0));


    }

    @Test
    public void instructorTestEQ() {
        assertEquals(NovReports,
                E1.dailyMaxForMonth(threeDates, 11));
    }

    @Test
    public void instructorTestEQ2() {
        assertEquals(NovReports,
                E2.dailyMaxForMonth(threeDates, 11));
    }

    @Test
    public void instructorTestEQ3() {
        assertEquals(testRept,
                E1.dailyMaxForMonth(testList, 05));
    }

    @Test
    public void instructorTestEQ4() {
        assertEquals(testRept,
                E2.dailyMaxForMonth(testList, 05));
    }

}
/*

go through the list of doubles and identify a date. If the date has the correct month then continue
and if not, move on to the next date

then identify the largest following frequency

and turn the two into a new instance of MaxHzReport and add them to a list

repeat through the entire list of doubles and return the list of MaxHzReport


 */