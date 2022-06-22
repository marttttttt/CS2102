import java.util.LinkedList;

class ShowManager2 {

    ShowManager2() {}

    /**
     * Filters out all shows with isSpecial equal to true and then sorts
     * the shows into the daytime, primetime, and latenight lists of a
     * ShowSummary object and returns it. Daytime shows start at or after
     * 6:00 am and end before 5:00 pm. Primetime shows start at or after
     * 5:00 pm and before 10:00 pm. Late night shows have a start time
     * at or after 10:00 pm and before 1:00 am.
     *
     * @param shows list of shows to be sorted
     * @return a ShowSummary of the filtered and sorted shows
     */
    public ShowSummary organizeShows(LinkedList<Show> shows)
    {
        LinkedList<Show> daytime = new LinkedList<Show>();
        LinkedList<Show> primetime = new LinkedList<Show>();
        LinkedList<Show> latenight = new LinkedList<Show>();
        LinkedList<Show> nonSpecial = new LinkedList<Show>();

        for (Show show : shows){
            if (!show.isSpecial) nonSpecial.add(show);
        }

        for (Show show : nonSpecial){
            if (show.broadcastTime >= 600 && show.broadcastTime < 1700) daytime.add(show);
            if (show.broadcastTime >= 1700 && show.broadcastTime < 2200) primetime.add(show);
            if (show.broadcastTime >= 2200 || show.broadcastTime < 100) latenight.add(show);
        }
        return new ShowSummary(daytime, primetime, latenight);
    }

}