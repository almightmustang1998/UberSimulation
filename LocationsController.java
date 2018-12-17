package faketaxi;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
/**
 * FXML Controller class
 *
 * @author carloschavez
 */
public class LocationsController implements Initializable {
    
       
        //adds places to the choice boxes
    ObservableList<String> currentList = FXCollections.observableArrayList(FakeTaxi.vertexHotel.getName(), FakeTaxi.vertexMcBurger.getName(), FakeTaxi.vertexLibrary.getName(),
                FakeTaxi.vertexCoffeeShop.getName(), FakeTaxi.vertexSchool.getName(), FakeTaxi.vertexAirport.getName(), FakeTaxi.vertexSuperMarket.getName(), FakeTaxi.vertexZoo.getName());
    ObservableList<String> destinationList = FXCollections.observableArrayList(FakeTaxi.vertexHotel.getName(), FakeTaxi.vertexMcBurger.getName(), FakeTaxi.vertexLibrary.getName(),
                FakeTaxi.vertexCoffeeShop.getName(), FakeTaxi.vertexSchool.getName(), FakeTaxi.vertexAirport.getName(), FakeTaxi.vertexSuperMarket.getName(), FakeTaxi.vertexZoo.getName());
       @FXML
       private AnchorPane loc;
       
       @FXML
       private ChoiceBox current;
       @FXML
       private ChoiceBox destination;
       
   
   //gives user the option of picking a driver
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        //opens locations page
        ButtonType foo = new ButtonType("Choose next highest ranked driver", ButtonBar.ButtonData.APPLY);
        ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        //shows top rated driver
        Alert alert = new Alert(AlertType.CONFIRMATION,"Highest ranked driver: " + FakeTaxi.driversPri.peek().getName()
                                    + "\t\t Rate: " + FakeTaxi.driversPri.peek().getRate(), ok);
        alert.setTitle("Confirmation");
        alert.getButtonTypes().add(foo);
        Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == foo){
              next();   //removes highest ranked driver from priority queue
            }
        alert.setHeaderText(null);
        }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // adds choiceBox options
        current.setItems(currentList);
        destination.setItems(destinationList);
    }    
    
    //handles driver choice
    private void next(){
         ButtonType foo = new ButtonType("Choose next highest ranked driver", ButtonBar.ButtonData.APPLY);
         
        FakeTaxi.driversPri.poll();  //removes highest ranked 
        //shows next highest ranked
        Alert second = new Alert(AlertType.CONFIRMATION,"Next highest ranked driver: " + FakeTaxi.driversPri.peek().getName() 
                        + "\t\t Rate: " + FakeTaxi.driversPri.peek().getRate());
        second.getButtonTypes().add(foo);
        second.setTitle("Confirmation");
       Optional<ButtonType> result = second.showAndWait();
            if (result.get() == foo){
             next();   //RECURSION :)
            }
 
        second.setHeaderText(null);
    } 
    
    //checks user input before loading next page
    @FXML
    private void confirmAction(ActionEvent event) throws Exception {
        
        FakeTaxi.currently = (String) current.getSelectionModel().getSelectedItem();  //place user is at 
        FakeTaxi.destiny = (String) destination.getSelectionModel().getSelectedItem();    //place user is going
        
        if(!FakeTaxi.currently.equals(FakeTaxi.destiny)){  //checks to make sure user isn't going to place they're at
        History latest = new History(FakeTaxi.driversPri.peek(), FakeTaxi.currently, FakeTaxi.destiny);    //history object
        FakeTaxi.userHistory.push(latest);   //pushes most recent trip to userHistory class
        //shows user the fastest route
        AnchorPane panes;
        panes = FXMLLoader.load(getClass().getResource("FastestRoute.fxml"));
        loc.getChildren().setAll(panes);
        }
        
        else {
            AnchorPane panes;
            panes = FXMLLoader.load(getClass().getResource("Denial.fxml"));
            loc.getChildren().setAll(panes);
        }

    }
}
