import java.util.GregorianCalendar;
import java.util.LinkedList;


/**
 * the format of how the reports are feed into the system
 */
public class TodaysWeatherReport {

    private GregorianCalendar date;
    private LinkedList<Reading> dailyTemp;
    private LinkedList<Reading> dailyRainfall;

    public TodaysWeatherReport(GregorianCalendar date, LinkedList<Reading> dailyTemp,
                              LinkedList<Reading> dailyRainfall){
        this.date = date;
        this.dailyTemp = dailyTemp;
        this.dailyRainfall = dailyRainfall;
    }

    /**
     * will take the date and check to see if the month and the year is the same
     * @param month
     * @param year
     * @return  returns true if dates the day matches the month and the year else returns false
     */
    public boolean checkDate(int month, int year) {
        return month == date.get(GregorianCalendar.MONTH) &&
                year == date.get(GregorianCalendar.YEAR);
    }

    /**
     * finds the average temperature for the given day
     * @returns a double for the given day
     */
    public double dailyAverageTemp() {
        double dailyTotal = 0;
        int numDailyReadings = 0;

        for (Reading tempReading : this.dailyTemp) {
            dailyTotal += tempReading.getTempReading();
            numDailyReadings++;
        }
        return dailyTotal/numDailyReadings;
    }

    /**
     * finds the total rain fall for the given day
     * @returns the sum for all the rain for the given day
     */
    public double totalDailyRainfall() {
        double dailyTotal = 0;
        for (Reading rainfallReading : this.dailyRainfall) {
            dailyTotal += rainfallReading.getRainfallReading();
        }
        return dailyTotal;
    }

    /**
     * determines if the object given and the time are equal
     * @param p
     * @returns if object and the day are equal it will return true else equal false
     */
    public boolean equals(Object p) {
        TodaysWeatherReport otherR = (TodaysWeatherReport) p;

        return this.date.equals(otherR.date) &&
                this.dailyTemp.equals(otherR.dailyTemp) &&
                this.dailyRainfall.equals(otherR.dailyRainfall);
    }
}


