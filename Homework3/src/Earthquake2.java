import java.util.LinkedList;

class Earthquake2 {
    Earthquake2(){}

    // checks whether a datum is a date
    boolean isDate(double anum) { return (int)anum > 10000000; }
    // extracts the month from an 8-digit date
    int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }

    /**
     * filters through a list of doubles containing dates and data samples and returns a list of MaxHzReport of
     * the maximum frequencies for each day of the given month
     *
     * @param data the list of data to be analyzed
     * @param month the month to filter the data by
     * @return a list of MaxHzReport of all data that corresponds to the given month
     */

    public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,
                                                    int month) {

        int yearVal = (int) (Math.round(data.get(0)) / 10000 * 10000);
        LinkedList<MaxHzReport> HzList = new LinkedList<MaxHzReport>();
        LinkedList<MaxHzReport> returnList = new LinkedList<MaxHzReport>();

        for (int j = 0; j < data.size(); j++) {

            if ((data.get(j) > 500)){
                double date = data.get(j);
                double maxHz = -1;

                for (int k = j+1; k < data.size(); k++){

                    if (data.get(k) > 500) break;
                    if (data.get(k) > maxHz) maxHz = data.get(k);
                }
                HzList.add(new MaxHzReport(date, maxHz));
            }
        }

        for (MaxHzReport hzRep : HzList){
            if ((int) (hzRep.date - yearVal) / 100 == month){ //substring 5,7 when we want index 4 and 5 of double because string is in scientific notation and has added decimal point
                returnList.add(hzRep);
            }
        }
        return returnList;
    }
}