package faketaxi;

/**
 *
 * @author carloschavez
 * CIS 112 FINAL PROJECT
 * class describes a history object
 */
public class History {
    Driver driver;
    String pickedUpLocation;
    String droppedOffLocation;
    
    public History(Driver driver, String pickedUpLocation, String droppedOffLocation){
        this.driver = driver;
        this.pickedUpLocation = pickedUpLocation;
        this.droppedOffLocation = droppedOffLocation;
        
    }
    
    public Driver getDriver(){
        return driver;
    }
    public String getPickedUpLocation(){
        return pickedUpLocation;
    }
    public String getDroppedOffLocation(){
        return droppedOffLocation;
    }
    
    //@Override
    public String toString() {
        return "Driver: " + driver.getName() + ", Rate: " + driver.getRate() + ", Car: " + driver.getCar() + ",\t " + 
                "\tPicked up: " + pickedUpLocation + "\tDropped off: " + droppedOffLocation;
    }
    
}
