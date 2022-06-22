import java.util.LinkedList;
import java.util.Objects;

class 	ShowSummary {

    LinkedList<Show> daytime;
    LinkedList<Show> primetime;
    LinkedList<Show> latenight;

    ShowSummary()
    {
        this.daytime = new LinkedList<Show>();
        this.primetime = new LinkedList<Show>();
        this.latenight = new LinkedList<Show>();
    }

    ShowSummary(LinkedList<Show> daytime, LinkedList<Show> primetime, LinkedList<Show> latenight)
    {
        this.daytime = daytime;
        this.primetime = primetime;
        this.latenight = latenight;
    }


    /**
     * This method tests the equality of an instance of ShowSummary with an object o. The objects are
     * considered to be equal iff:
     * Object o is an instance of ShowSummary
     * All three lengths of the list fields of a ShowSummary instance are equal across both objects
     * All the shows within matching indices in any of the list fields have the same title and broadcast time
     *
     *
     * @param o another object that will be tested for equality
     * @return true if the objects are equal false if they are not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShowSummary that = (ShowSummary) o;
        if (this.daytime.size() != that.daytime.size() || this.primetime.size() != that.primetime.size() || this.latenight.size() != that.latenight.size()) return false;

        for (int j = 0; j < daytime.size(); j++) {
            if (!this.daytime.get(j).title.equals(that.daytime.get(j).title)) return false;
            if (this.daytime.get(j).broadcastTime != that.daytime.get(j).broadcastTime) return false;
        }

        for (int j = 0; j < primetime.size(); j++) {
            if (!this.primetime.get(j).title.equals(that.primetime.get(j).title)) return false;
            if (this.primetime.get(j).broadcastTime != that.primetime.get(j).broadcastTime) return false;
        }

        for (int j = 0; j < latenight.size(); j++) {
            if (!this.latenight.get(j).title.equals(that.latenight.get(j).title)) return false;
            if (this.latenight.get(j).broadcastTime != that.latenight.get(j).broadcastTime) return false;
        }

        return true;
    }
}