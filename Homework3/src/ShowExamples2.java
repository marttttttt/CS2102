import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;
import java.util.Arrays;

public class ShowExamples2
{
    ShowManager1 sm1 = new ShowManager1();
    LinkedList<Show> shows = new LinkedList<Show>();
    ShowSummary report1 = new ShowSummary();

    LinkedList<Show> shows2 = new LinkedList<>();

    public ShowExamples2()
    {
        LinkedList<Show> eps1 = new LinkedList<Show>();
        eps1.add(new Show("Best of Both Worlds", 88));
        eps1.add(new Show("The Ultimate Computer", 49));
        eps1.add(new Show("Trials and Tribble-ations", 43));
        Show s1 = new Show("Star Trek", 1800);
        shows.add(s1);
        report1.primetime.add(s1);

        LinkedList<Show> eps2 = new LinkedList<Show>();
        eps2.add(new Show("Fear of a Bot Planet", 23));
        eps2.add(new Show("The Why of Fry", 21));
        eps2.add(new Show("Roswell that Ends Well", 23));
        eps2.add(new Show("Meanwhile", 22));
        Show s2 = new Show("Futurama", 1900);
        shows.add(s2);
        report1.primetime.add(s2);

        LinkedList<Show> eps3 = new LinkedList<Show>();
        eps3.add(new Show("Yakko's World", 4));
        eps3.add(new Show("Hello Nice Warners", 8));
        eps3.add(new Show("Where Rodents Dare", 9));
        Show s3 = new Show("Animaniacs", 1630);
        shows.add(s3);
        report1.daytime.add(s3);

        LinkedList<Show> eps4 = new LinkedList<Show>();
        eps4.add(new Show("The Letter W", 59));
        eps4.add(new Show("The Letter P", 57));
        eps4.add(new Show("The Letter I", 58));
        Show s4 = new Show("Sesame Street", 900);
        shows.add(s4);
        report1.daytime.add(s4);

        Show s5 = new Show("Sesame Street", 200);
        Show s6 = new Show("Sesame Street", 200);

        shows2.add(s1);
        shows2.add(s5);
        shows2.add(s2);
        shows2.add(s6);
        shows2.add(s3);
        shows2.add(s4);

    }

    @Test
    public void instructorTestOrganizeShows()
    {
        ShowSummary report2 = sm1.organizeShows(shows);
        assertEquals(report1, report2);
    }

    @Test
    public void testOrganizeShows()
    {
        ShowSummary report2 = sm1.organizeShows(shows2);
        assertEquals(report1, report2);
    }
}

/*
Subtasks:
- filter through list of shows
	- check if show is special
		- if not determine what time slot it is
		- add show to corresponding section of report
- return report
 */