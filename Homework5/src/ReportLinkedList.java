import java.util.GregorianCalendar;
import java.util.LinkedList;


/**
 * the class is used to analyze the data and return desired data
 */
public class ReportLinkedList implements IReport {

    private LinkedList<TodaysWeatherReport> reports;

    public ReportLinkedList(LinkedList<TodaysWeatherReport> reports) {
        this.reports = reports;
    }

    /**
     * the method looks through the reports list and finds the entries that match month and year
     * @param month
     * @param year
     * @returns LinkedList of all the days that matched the month and the year
     */
    public LinkedList<TodaysWeatherReport> findMonthDates(int month,int year) {
        LinkedList<TodaysWeatherReport> report = new LinkedList<>();
        for(TodaysWeatherReport aReport : this.reports) {            //runs through the reports list
            if(aReport.checkDate(month, year)) {        //checks if the year and month match then adds it to a new list
                report.add(aReport);
            }
        }
        return report;
    }

    /**
     * calculates the average temperature for the days given
     * @param reports
     * @returns a double, the average temps for all the days in the list
     */
    public double averageTemp(LinkedList<TodaysWeatherReport> reports) {
        double total = 0;
        int numTotalReadings = 0;
        for(TodaysWeatherReport aReport : reports) {         // runs through the list given
            total += aReport.dailyAverageTemp();            //adds all the temperatures together
            numTotalReadings++;                             //interments everytime the program runs through to find
        }                                                   //how many days there are

        if(reports.size() == 0)
            return 0;
        else
            return total/numTotalReadings;
    }

    /**
     * calculates the total rainfall for the list given
     * @param reports
     * @return
     */
    public double totalRainfall(LinkedList<TodaysWeatherReport> reports) {
        double total = 0;
        for(TodaysWeatherReport aReport : reports) {
            total += aReport.totalDailyRainfall();
        }
        return total;
    }

    /**
     * creates a daily weather report and adds it to the reports linked list in the class
     * @param date
     * @param temp
     * @param rainfall
     */
    public void addReport(GregorianCalendar date, LinkedList<Reading> temp,
                          LinkedList<Reading> rainfall) {
        TodaysWeatherReport report = new TodaysWeatherReport(date, temp, rainfall);
        this.reports.add(report);
    }

    /**
     * determines if two reports are equal
     * @param p
     * @returns true if the reports are the same false if not
     */
    public boolean equals(Object p) {
        ReportLinkedList otherL = (ReportLinkedList) p;

        if (reports.size() == otherL.reports.size()) {
            for (int i = 0; i < reports.size(); i++) {
                reports.get(i).equals(otherL.reports.get(i));
            }
            return true;
        }
        return false;
    }
}