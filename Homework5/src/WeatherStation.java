import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * represents weather station with weather reports from different dates
 */
public class WeatherStation {

    private IReport reports;

    public WeatherStation(IReport reports) {
        this.reports = reports;
    }

    /**
     * to find the average temperature for the month and year given
     * @param month
     * @param year
     * @returns a double for the average rain fall
     */
    public double averageTempForMonth(int month, int year) {
        return reports.averageTemp(reports.findMonthDates(month, year));
    }

    /**
     * The sum of the fall for the month of the year given
     * @param month
     * @param year
     * @returns a double with the total rainfall
     */
    public double totalRainfallForMonth(int month, int year) {
        return reports.totalRainfall(reports.findMonthDates(month, year));
    }

    /**
     * Add a new daily report to list of data
     * @param date
     * @param readings
     */
    public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings) {
        reports.addReport(date, readings, readings);
    }

    /**
     * Chekc to see if the report that is currently in the system, matches a report given
     * @param p
     * @returns true if the two reports are equal, else it returns false
     */
    public boolean equals(Object p) {
        WeatherStation otherM = (WeatherStation) p;

        if (this.reports.equals(otherM.reports)) {   //determines the two reports are equal
            return true;
        }
        return false;
    }
}