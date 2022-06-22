/**
 * the class is the format of the data from the weather sensor
 */

public class Reading {

    private Time time;
    private double tempReading;
    private double rainfallReading;

    public Reading(Time time, double tempReading, double rainfallReading){
        this.time = time;
        this.tempReading = tempReading;
        this.rainfallReading = rainfallReading;
    }

    /**
     * the method is used that when it is called the temperature reading for the sensor will be feed back
     * @return the temperature reading
     */
    public double getTempReading() {
        return this.tempReading;
    }

    /**
     * The method id used that when it is called the rainfall reading for the sensor will feed back
     * @return the rainfall reading
     */
    public double getRainfallReading() {
        return this.rainfallReading;
    }
}
