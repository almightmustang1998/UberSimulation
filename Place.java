/*
 *class describes a place object on a map
 */
package faketaxi;

/**
 *
 * @author carloschavez
 */
public class Place {
    String name;
   Location location;
   //constructor
   public Place(String name, Location location){
      this.name = name;
      this.location = location;
   }
   
   //returns name value
   public String getName(){
      return name;
   }
   
   //returns location
   public Location getLocation(){
      return location;
   }
   //to string method
   public String toString(){
      return "Name of place: " + name + ", " + location;
   }
    
    
}
