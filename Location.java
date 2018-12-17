package faketaxi;
import java.util.Random;  //needed to generate random locations
/**
 * 
 * @author carloschavez
 * CIS 112 FINAL PROJECT
 * //Location class defines a location in terms of X and Y points
 */



public class Location {
    private int x; //x position
    private int y; //y position

    
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //no-arg constructor
    public Location() {
        this.x = 0;
        this.y = 0;
    }

    
    public void setX(int x) {
        this.x = x;
    }

    
    public void setY(int y) {
        this.y = y;
    }

    
    public int getX() {
        return x;
    }

    //returns y value
    public int getY() {
        return y;
    }

    //generates random location. needed for drivers.
    public static Location getRandomLocation() {
        Random random = new Random(); //random object
        //random x and y values
        int x = random.nextInt(400);
        int y = random.nextInt(320);
        //creates a location object with random values
        Location randomLocation = new Location(x, y);

        return randomLocation;
    }

    @Override
    public String toString() {
        return "coordinates: " + x + ", " + y;
    }
}
