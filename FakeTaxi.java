package faketaxi;
import java.util.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.awt.geom.Point2D;
import java.util.Map; 
import java.util.HashMap; 
import java.util.concurrent.CountDownLatch;


/**
 *
 * @author carloschavez
 * CIS 112 
 * this FakeTaxi sets up the application 
 */
public final class FakeTaxi extends Application {
    public Pane root;
    public static ArrayList<Driver> drivers = new ArrayList<Driver>();    //list of drivers
    public static ArrayList<Double> distanceWeights = new ArrayList<Double>();  //holds distance between 2 places
    public static Stack<History> userHistory = new Stack<History>();    //history of rides taken
    public static Map<String, Vertex> vertices = new HashMap<String, Vertex>(); //holds vertex names and their values
    public static PriorityQueue<Driver> driversPri = new PriorityQueue<>(new Comparator<Driver>(){
        @Override
        public int compare(Driver one, Driver two){
            return two.rate - one.rate; //ranks drivers by rates
        }
    });
    //vertices
    public static Vertex vertexAirport = new Vertex("Airport");
    public static Vertex vertexCoffeeShop = new Vertex("Coffee Shop");
    public static Vertex vertexSchool = new Vertex("School");
    public static Vertex vertexHotel = new Vertex("Hotel");
    public static Vertex vertexZoo = new Vertex("Zoo");
    public static Vertex vertexLibrary = new Vertex("Library");
    public static Vertex vertexSuperMarket = new Vertex("SuperMarket");
    public static Vertex vertexMcBurger = new Vertex("McBurger");
    //drivers
    public static Driver luis = new Driver("Luis", 5, "Honda");
    public static Driver bob = new Driver("Bob", 1, "Mitsubishi");
    public static Driver sam = new Driver("Sam", 3, "Lamborgini");
    public static Driver peter = new Driver("Peter", 4, "Jeep");
    public static Driver lily = new Driver("Lily", 2, "Ford");
    public static Driver noah  = new Driver("Noah", 1, "Nissan");
    public static Location hotelLocation = new Location(51, 65);
    public static Location mcBurgerLocation = new Location(7, 183);
    public static Location libraryLocation= new Location(176, 202);
    public static Location coffeeLocation = new Location(188, 5);
    public static Location schoolLocation = new Location(315, 19);
    public static Location airportLocation= new Location(7, 6); 
    public static Location superMarketLocation = new Location(330, 176);
    public static Location zooLocation = new Location(167, 91);
        //place objects
    public static Place hotel = new Place("Hotel", hotelLocation);
    public static Place mcBurger = new Place("McBurger", mcBurgerLocation);
    public static Place library = new Place("Library", libraryLocation);
    public static Place coffeeShop = new Place("Coffee Shop", coffeeLocation);
    public static Place school = new Place("School", schoolLocation);
    public static Place airport = new Place("Airport", airportLocation);
    public static Place superMarket = new Place("Super Market", superMarketLocation);
    public static Place zoo = new Place("Zoo", zooLocation);
    //holds where user is at and where they want to go
    public static String currently;
    public static String destiny;
    //place to place distances
    public static double airportToCoffeeShop = calculateDistance(airport.location.getX(), airport.location.getY(),
        coffeeShop.location.getX(), coffeeShop.location.getY());
    public static double airportToHotel = calculateDistance(airport.location.getX(), airport.location.getY(),
        hotel.location.getX(), hotel.location.getY());
    public static double airportToMcBurger = calculateDistance(airport.location.getX(), airport.location.getY(),
            mcBurger.location.getX(), mcBurger.location.getY());
    public static double coffeeShopToSchool = calculateDistance(coffeeShop.location.getX(), coffeeShop.location.getY(),
            school.location.getX(), school.location.getY());
    public static double coffeeShopToZoo = calculateDistance(coffeeShop.location.getX(), coffeeShop.location.getY(),
            zoo.location.getX(), zoo.location.getY());
    public static double coffeeShopToHotel = calculateDistance(coffeeShop.location.getX(), coffeeShop.location.getY(),
            hotel.location.getX(), hotel.location.getY());
    public static double coffeeShopToAirport = calculateDistance(coffeeShop.location.getX(), coffeeShop.location.getY(),
            airport.location.getX(), airport.location.getY());
    public static double schoolToCoffeeShop = calculateDistance(school.location.getX(), school.location.getY(),
            coffeeShop.location.getX(), coffeeShop.location.getY());;
    public static double schoolToZoo = calculateDistance(school.location.getX(), school.location.getY(),
            zoo.location.getX(), zoo.location.getY());
    public static double schoolToSuperMarket = calculateDistance(school.location.getX(), school.location.getY(),
            superMarket.location.getX(), superMarket.location.getY());
    public static double hotelToCoffeeShop = calculateDistance(hotel.location.getX(), hotel.location.getY(),
           coffeeShop.location.getX(), coffeeShop.location.getY());
    public static double hotelToAirport = calculateDistance(hotel.location.getX(), hotel.location.getY(),
            airport.location.getX(), airport.location.getY());
    public static double hotelToMcBurger = calculateDistance(hotel.location.getX(), hotel.location.getY(),
             mcBurger.location.getX(), mcBurger.location.getY());
    public static double hotelToLibrary = calculateDistance(hotel.location.getX(), hotel.location.getY(),
            library.location.getX(), library.location.getY());
    public static double hotelToZoo = calculateDistance(hotel.location.getX(), hotel.location.getY(),
            zoo.location.getX(), zoo.location.getY());
    public static double zooToHotel = calculateDistance(zoo.location.getX(), zoo.location.getY(),
            hotel.location.getX(), hotel.location.getY());        
    public static double zooToCoffeeShop = calculateDistance(zoo.location.getX(), zoo.location.getY(),
            coffeeShop.location.getX(), coffeeShop.location.getY());        
    public static double zooToSchool = calculateDistance(zoo.location.getX(), zoo.location.getY(),
            school.location.getX(), school.location.getY());        
    public static double zooToLibrary = calculateDistance(zoo.location.getX(), zoo.location.getY(),
            library.location.getX(), library.location.getY());        
    public static double zooToSuperMarket = calculateDistance(zoo.location.getX(), zoo.location.getY(),
           superMarket.location.getX(), superMarket.location.getY());        
    public static double libraryToZoo = calculateDistance(library.location.getX(), library.location.getY(),
            zoo.location.getX(), zoo.location.getY());
    public static double libraryToHotel = calculateDistance(library.location.getX(), library.location.getY(),
            hotel.location.getX(), hotel.location.getY());
    public static double libraryToSuperMarket = calculateDistance(library.location.getX(), library.location.getY(),
            superMarket.location.getX(), superMarket.location.getY());        
    public static double libraryToMcBurger = calculateDistance(library.location.getX(), library.location.getY(),
            mcBurger.location.getX(), mcBurger.location.getY());       
    public static double superMarketToSchool = calculateDistance(superMarket.location.getX(), superMarket.location.getY(),
            school.location.getX(), school.location.getY());       
    public static double superMarketToZoo = calculateDistance(superMarket.location.getX(), superMarket.location.getY(),
            zoo.location.getX(), zoo.location.getY());
    public static double superMarketToLibrary = calculateDistance(superMarket.location.getX(), superMarket.location.getY(),
            library.location.getX(), library.location.getY());      
    public static double mcBurgerToHotel= calculateDistance(mcBurger.location.getX(), mcBurger.location.getY(),
            hotel.location.getX(), hotel.location.getY());        
    public static double mcBurgerToLibrary = calculateDistance(mcBurger.location.getX(), mcBurger.location.getY(),
            library.location.getX(), library.location.getY());
    public static double mcBurgerToAirport= calculateDistance(mcBurger.location.getX(), mcBurger.location.getY(),
            airport.location.getX(), airport.location.getY());
     public static final CountDownLatch latch = new CountDownLatch(1);  //used for loading application in Main
     public static FakeTaxi start = null;   //used for loading application in Main
     
    public FakeTaxi(){
        setStartUpTest(this);
    }
   
   // Parent root;
    @Override
    public void start(Stage stage) throws Exception {
        
        //loads the main map
        root = FXMLLoader.load(getClass().getResource("Map.fxml"));
        makeDrivers();
        fillPri();
        createGraph();
        fillMap();
        stage.setTitle("Uber Simulation");
        stage.setMinHeight(500);
        stage.setMinWidth(500);
        stage.setMaxHeight(500);
        stage.setMaxWidth(500);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    //adds them to list and gui
    public void makeDrivers() {
        drivers.add(luis);
        drivers.add(bob);
        drivers.add(sam);
        drivers.add(peter);
        drivers.add(lily);
        drivers.add(noah);
        for (int i = 0; i < drivers.size(); i++) {
            Driver driver = drivers.get(i);
         	ImageView carview = new ImageView("faketaxi/topcar.jpg");
                carview.setFitWidth(30);
                carview.setFitHeight(30);
         	carview.setX((double)driver.location.getX());
                carview.setY((double)driver.location.getY());
               root.getChildren().add(carview); //adds drivers to map
       	}
    }
    //fills priority queue
    public void fillPri(){
        for(int i = 0; i < drivers.size(); i++){
            driversPri.add(drivers.get(i));
        }
    }
    
    //used to calculate distance between places
    public static double calculateDistance(double x1, double y1, double x2, double y2){
        return Point2D.distance(x1, y1, x2, y2);
    }
        //creates a graph of the map
    public void createGraph(){
        vertexAirport.addNeighbor(new Edge(airportToCoffeeShop, vertexAirport, vertexCoffeeShop));
        vertexAirport.addNeighbor(new Edge(airportToHotel, vertexAirport, vertexHotel));
        vertexAirport.addNeighbor(new Edge(airportToMcBurger, vertexAirport, vertexMcBurger));
        vertexCoffeeShop.addNeighbor(new Edge(coffeeShopToSchool, vertexCoffeeShop, vertexSchool));
        vertexCoffeeShop.addNeighbor(new Edge(coffeeShopToZoo, vertexCoffeeShop, vertexZoo));
        vertexCoffeeShop.addNeighbor(new Edge(coffeeShopToHotel, vertexCoffeeShop, vertexHotel));
        vertexCoffeeShop.addNeighbor(new Edge(coffeeShopToAirport, vertexCoffeeShop, vertexAirport));
        vertexSchool.addNeighbor(new Edge(schoolToCoffeeShop, vertexSchool, vertexCoffeeShop));
        vertexSchool.addNeighbor(new Edge(schoolToZoo, vertexSchool, vertexZoo));
        vertexSchool.addNeighbor(new Edge(schoolToSuperMarket, vertexSchool, vertexSuperMarket));
        vertexHotel.addNeighbor(new Edge(hotelToCoffeeShop, vertexHotel, vertexCoffeeShop));
        vertexHotel.addNeighbor(new Edge(hotelToAirport, vertexHotel, vertexAirport));
        vertexHotel.addNeighbor(new Edge(hotelToMcBurger, vertexHotel, vertexMcBurger));
        vertexHotel.addNeighbor(new Edge(hotelToLibrary, vertexHotel, vertexLibrary));
        vertexHotel.addNeighbor(new Edge(hotelToZoo, vertexHotel, vertexZoo));
        vertexZoo.addNeighbor(new Edge(zooToHotel, vertexZoo, vertexHotel));
        vertexZoo.addNeighbor(new Edge(zooToCoffeeShop, vertexZoo, vertexCoffeeShop));
        vertexZoo.addNeighbor(new Edge(zooToSchool, vertexZoo, vertexSchool));
        vertexZoo.addNeighbor(new Edge(zooToLibrary, vertexZoo, vertexLibrary));
        vertexZoo.addNeighbor(new Edge(zooToSuperMarket, vertexZoo, vertexSuperMarket));
        vertexLibrary.addNeighbor(new Edge(libraryToZoo, vertexLibrary, vertexZoo));
        vertexLibrary.addNeighbor(new Edge(libraryToHotel, vertexLibrary, vertexHotel));
        vertexLibrary.addNeighbor(new Edge(libraryToSuperMarket, vertexLibrary, vertexSuperMarket));
        vertexLibrary.addNeighbor(new Edge(libraryToMcBurger, vertexLibrary, vertexMcBurger));
        vertexSuperMarket.addNeighbor(new Edge(superMarketToSchool, vertexSuperMarket, vertexSchool));
        vertexSuperMarket.addNeighbor(new Edge(superMarketToZoo, vertexSuperMarket, vertexZoo));
        vertexSuperMarket.addNeighbor(new Edge(superMarketToLibrary, vertexSuperMarket, vertexLibrary));
        vertexMcBurger.addNeighbor(new Edge(mcBurgerToHotel, vertexMcBurger, vertexHotel));
        vertexMcBurger.addNeighbor(new Edge(mcBurgerToLibrary, vertexMcBurger, vertexLibrary));
        vertexMcBurger.addNeighbor(new Edge(mcBurgerToAirport, vertexMcBurger, vertexAirport));
    }
    //stores keys and values in map
    public void fillMap(){
        vertices.put("Library", vertexLibrary);
        vertices.put("Airport", vertexAirport);
        vertices.put("Coffee Shop", vertexCoffeeShop);
        vertices.put("School", vertexSchool);
        vertices.put("Hotel", vertexHotel);
        vertices.put("Zoo", vertexZoo);
        vertices.put("SuperMarket", vertexSuperMarket);
        vertices.put("McBurger", vertexMcBurger);
    }
    //loads class
    public static FakeTaxi waitForStartUpTest() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return start;
    }
    
    public static void setStartUpTest(FakeTaxi test) {
        start = test;
        latch.countDown();
    }
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
