package faketaxi;

/**
 *
 * @author carloschavez
 */
//Driver class describes drivers

public class Driver {
    String name;   //drivers name
    int rate;   //their rate out of 5
    Location location;   //the location of driver
    String car; //type of car the driver owns

    //constructor
    public Driver(String name, int rate, String car) {
        this.name = name;
        this.rate = rate;
        this.location = Location.getRandomLocation();   //drivers start off at random locations
        this.car = car;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRate(int name) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public void setCar(String name) {
        this.car = car;
    }

    public String getCar() {
        return car;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Driver: " + name + ", Rate: " + rate + ", Car: " + car + ", " + location;
    }
}
