public class Precinct {

    String name;
    String address;
    int population;

    Precinct(String name, String address, int population) {
        this.name = name;
        this.address = address;
        this.population = population;
    }

    public String toString(){
        return ("Precinct:" + ' ' + name + ',' + ' ' + "Address:" + ' ' + address + ',' + ' ' + "Population:" + population);

    }

    public Precinct grow(int amount) {
        Precinct aPrecinct = new Precinct(name, address, population+amount);
        return aPrecinct;

    }

}
