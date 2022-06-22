import org.junit.Test;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Examples {

    GregorianCalendar g1 = new GregorianCalendar(2020, 10, 29);
    GregorianCalendar g2 = new GregorianCalendar(2020, 10, 26);
    GregorianCalendar g3 = new GregorianCalendar(2020, 10, 19);
    GregorianCalendar g4 = new GregorianCalendar(2020, 10, 04);
    //GregorianCalendar g5 = new GregorianCalendar(2020, 11, 05);

    LinkedList<Reading> temps1 = new LinkedList<>();
    LinkedList<Reading> temps2 = new LinkedList<>();
    LinkedList<Reading> temps3 = new LinkedList<>();
    LinkedList<Reading> temps4 = new LinkedList<>();

    LinkedList<Reading> rainfall1 = new LinkedList<>();
    LinkedList<Reading> rainfall2 = new LinkedList<>();
    LinkedList<Reading> rainfall3 = new LinkedList<>();
    LinkedList<Reading> rainfall4 = new LinkedList<>();

    Time time1 = new Time(2, 30);

    Reading reading1 = new Reading(time1,45, 2);
    Reading reading2 = new Reading(time1,55, 2.5);
    Reading reading3 = new Reading(time1,35, 3);
    Reading reading4 = new Reading(time1,40, 1);
    Reading reading5 = new Reading(time1,50, 1.5);
    Reading reading6 = new Reading(time1,35, 3);
    Reading reading7 = new Reading(time1,25, 1.5);
    Reading reading8 = new Reading(time1,55, 5);
    Reading reading9 = new Reading(time1,50, 1.5);
    Reading reading10 = new Reading(time1,45, 2.5);
    Reading reading11 = new Reading(time1,45, 2);
    Reading reading12 = new Reading(time1,55, 2.5);
    Reading reading13 = new Reading(time1,35, 3);
    Reading reading14 = new Reading(time1,50, 1.5);
    Reading reading15 = new Reading(time1,45, 2.5);
    Reading reading16 = new Reading(time1,55, 2.5);
    Reading reading17 = new Reading(time1,35, 3);
    Reading reading18 = new Reading(time1,50, 1.5);
    Reading reading19 = new Reading(time1,40, 1);
    Reading reading20 = new Reading(time1,50, 1.5);

    LinkedList<TodaysWeatherReport> weatherReports1 = new LinkedList<>();
    LinkedList<TodaysWeatherReport> weatherReports2 = new LinkedList<>();
    LinkedList<TodaysWeatherReport> weatherReports3 = new LinkedList<>();

    IReport reports = new ReportLinkedList(weatherReports1);
    IReport reports2 = new ReportLinkedList(weatherReports2);
    IReport reports3 = new ReportLinkedList(weatherReports3);

    WeatherStation monitor = new WeatherStation(reports);
    WeatherStation monitor2 = new WeatherStation(reports2);
    WeatherStation monitor3 = new WeatherStation(reports3);

    public Examples() {

        temps1.add(reading1);
        temps1.add(reading2);
        temps1.add(reading3);
        temps1.add(reading4);
        temps1.add(reading5);//avg 45

        temps2.add(reading6);
        temps2.add(reading7);
        temps2.add(reading8);
        temps2.add(reading9);
        temps2.add(reading10);//avg 42

        temps3.add(reading11);
        temps3.add(reading12);
        temps3.add(reading13);
        temps3.add(reading14);
        temps3.add(reading15);//avg 46

        temps4.add(reading16);
        temps4.add(reading17);
        temps4.add(reading18);
        temps4.add(reading19);
        temps4.add(reading20);//avg 46

        rainfall1.add(reading1);
        rainfall1.add(reading2);
        rainfall1.add(reading3);
        rainfall1.add(reading4);
        rainfall1.add(reading5);//total 10

        rainfall2.add(reading6);
        rainfall2.add(reading7);
        rainfall2.add(reading8);
        rainfall2.add(reading9);
        rainfall2.add(reading10);//total 13.5

        rainfall3.add(reading11);
        rainfall3.add(reading12);
        rainfall3.add(reading13);
        rainfall3.add(reading14);
        rainfall3.add(reading15);//total 11.5

        rainfall4.add(reading16);
        rainfall4.add(reading17);
        rainfall4.add(reading18);
        rainfall4.add(reading19);
        rainfall4.add(reading20);//total 9.5

        TodaysWeatherReport r1 = new TodaysWeatherReport(g1, temps1, rainfall1);
        TodaysWeatherReport r2 = new TodaysWeatherReport(g2, temps2, rainfall2);
        TodaysWeatherReport r3 = new TodaysWeatherReport(g3, temps3, rainfall3);
        TodaysWeatherReport r4 = new TodaysWeatherReport(g4, temps4, rainfall4);

        weatherReports1.add(r1);
        weatherReports1.add(r2);
        weatherReports1.add(r3);
        weatherReports1.add(r4);

        weatherReports2.add(r1);
        weatherReports2.add(r2);
        weatherReports2.add(r3);

    }

    @Test
    public void testAverageTempForMonth() {
        assertEquals(44.75, monitor.averageTempForMonth(10, 2020), 0.0);
    }

    @Test
    public void testTotalRainfallForMonth() {
        assertEquals(44.5, monitor.totalRainfallForMonth(10, 2020), 0.0);
    }

    @Test
    public void testAddDailyReport() {
        monitor2.addDailyReport(g4, temps4);
        assertEquals(monitor, monitor2);
    }

    @Test
    public void testAddDailyReport2() {
        monitor3.addDailyReport(g1, temps1);
        monitor3.addDailyReport(g2, temps2);
        monitor3.addDailyReport(g3, temps3);
        assertEquals(monitor2, monitor3);
    }

    @Test
    public void testAddReport() {
        reports2.addReport(g4, temps4, rainfall4);
        assertTrue(reports.equals(reports2));
    }

    @Test
    public void testAddReport2() {
        reports2.addReport(g4, temps4, rainfall4);
        assertEquals(reports, reports2);
    }

    @Test
    public void testAdd() {
        TodaysWeatherReport r5 = new TodaysWeatherReport(g4, temps4, rainfall4);
        weatherReports2.add(r5);
        assertTrue(weatherReports1.equals(weatherReports2));
    }

    @Test
    public void nodate() {
        assertEquals(0, monitor.averageTempForMonth(11, 2020), 0.0);
    }

    @Test
    public void createWeatherStation() {

        assertEquals(0, monitor.averageTempForMonth(11, 2020), 0.0);
    }
}