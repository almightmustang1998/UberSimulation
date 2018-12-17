/*

 */
package faketaxi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author carloschavez
 */
public class DenialController implements Initializable {
    
     @FXML
    private AnchorPane anotherOne;
     
     //opens locations page
     @FXML
    private void handleButtonAction(ActionEvent event) throws Exception { 
        AnchorPane lol = FXMLLoader.load(getClass().getResource("Locations.fxml"));
        anotherOne.getChildren().setAll(lol);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
