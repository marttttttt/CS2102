import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class ShowExamples {
    ShowManager1 sm1 = new ShowManager1();
    ShowManager2 sm2 = new ShowManager2();
    LinkedList<Show> shows = new LinkedList<Show>();
    ShowSummary report1 = new ShowSummary();

    Show startrek = new Show("Star Trek", 1800, 45.0, false);
    Show futurama = new Show("Futurama", 1900, 23.0, false);
    Show animaniacs = new Show("Animaniacs", 1630, 7.0, false);
    Show sesamestreet = new Show("Sesame Street", 900, 60.0, false);

    LinkedList<Show> shows2 = new LinkedList<Show>();
    Show show1f = new Show("show1f", 600, 0, false);
    Show show1t = new Show("show1t", 600, 0, true);
    Show show2f = new Show("show2f", 1700, 0, false);
    Show show2t = new Show("show2t", 1700, 0, true);
    Show show3f = new Show("show3f", 2200, 0, false);
    Show show3t = new Show("show3t", 2200, 0, true);
    Show show4f = new Show("show4f", 2400, 0, false);
    Show show4t = new Show("show4t", 2400, 0, true);
    Show show5f = new Show("show5f", 0, 0, false);
    Show show5t = new Show("show5t", 0, 0, true);
    Show show6f = new Show("show6f", 100, 0, false);
    Show show6t = new Show("show6t", 100, 0, true);
    Show show7f = new Show("show7f", 500, 0, false);
    Show show7t = new Show("show7t", 500, 0, true);
    ShowSummary report2 = new ShowSummary();


    public ShowExamples() {
        shows.add(startrek);
        report1.primetime.add(startrek);

        shows.add(futurama);
        report1.primetime.add(futurama);

        shows.add(animaniacs);
        report1.daytime.add(animaniacs);

        shows.add(sesamestreet);
        report1.daytime.add(sesamestreet);


        //Mine
        shows2.add(show1f);
        shows2.add(show1t);
        report2.daytime.add(show1f);

        shows2.add(show2f);
        shows2.add(show2t);
        report2.primetime.add(show2f);

        shows2.add(show3f);
        shows2.add(show3t);
        report2.latenight.add(show3f);

        shows2.add(show4f);
        shows2.add(show4t);
        report2.latenight.add(show4f);

        shows2.add(show5f);
        shows2.add(show5t);
        report2.latenight.add(show5f);

        shows2.add(show6f);
        shows2.add(show6t);

        shows2.add(show7f);
        shows2.add(show7t);
    }

    @Test
    public void instructorTestShowSummary_EmptyReport() {
        ShowSummary report2 = new ShowSummary();
        assertFalse(report1.equals(report2));
    }


    @Test
    public void instructorTestShowSummary_WrongOrder() {
        ShowSummary report2 = new ShowSummary();

        report2.primetime.add(futurama);
        report2.primetime.add(startrek);
        report2.daytime.add(animaniacs);
        report2.daytime.add(sesamestreet);

        assertFalse(report1.equals(report2));
    }

    @Test
    public void instructorTestShowSummary_DifferentInstances() {
        ShowSummary report2 = new ShowSummary();

        Show startrek2 = new Show("Star Trek", 1800, 60.0, true);
        Show futurama2 = new Show("Futurama", 1900, 20.0, false);
        Show animaniacs2 = new Show("Animaniacs", 1630, 9.0, true);
        Show sesamestreet2 = new Show("Sesame Street", 900, 55.0, false);

        report2.primetime.add(startrek2);
        report2.primetime.add(futurama2);
        report2.daytime.add(animaniacs2);
        report2.daytime.add(sesamestreet2);

        assertTrue(report1.equals(report2));
    }

    @Test
    public void instructorTestShowSummary_SameInstances() {
        ShowSummary report2 = report1;
        assertTrue(report1.equals(report2));
    }


    @Test
    public void instructorTestOrganizeShows() {
        ShowSummary report2 = sm1.organizeShows(shows);
        assertEquals(report1, report2);
    }

    @Test
    public void instructorTestOrganizeShows2() {
        ShowSummary report2 = sm2.organizeShows(shows);
        assertEquals(report1, report2);
    }

    @Test
    public void instructorTestOrganizeShows3() {
        ShowSummary report1 = sm1.organizeShows(shows2);
        assertEquals(report1, report2);
    }

    @Test
    public void instructorTestOrganizeShows4() {
        ShowSummary report1 = sm2.organizeShows(shows2);
        assertEquals(report1, report2);
    }
}


/*
organizeShows has to:
go through the list of shows
identify which shows are part of the three list fields and sort them into separate lists
construct a ShowSummary instance from those lists and then return it
*/