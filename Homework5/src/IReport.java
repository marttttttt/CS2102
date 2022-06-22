import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * and interface for a any type of data that put into the system
 */
public interface IReport {

    /**
     * the method looks through the reports list and finds entries that match month and year
     * @param month
     * @param year
     * @returns a LinkedList of all the days that matched the month and the year
     */
    public LinkedList<TodaysWeatherReport> findMonthDates(int month, int year);

    /**
     * calculates the average temperature for the days given
     * @param reports
     * @returns a double, the average temps for all the days in the list
     */
    public double averageTemp(LinkedList<TodaysWeatherReport> reports);

    /**
     * calculates the total rain fall for the given list
     * @param reports
     * @return
     */
    public double totalRainfall(LinkedList<TodaysWeatherReport> reports);

    /**
     * creates a daily weather report and adds it to the reports linked list
     * @param date
     * @param temp
     * @param rainfall
     */
    public void addReport(GregorianCalendar date, LinkedList<Reading> temp,
                          LinkedList<Reading> rainfall);

    /**
     * determines if two reports are equal
     * @param p
     * @returns true if the reports are the same false if not
     */
    public boolean equals(Object p);
}